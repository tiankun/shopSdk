package com.redare.shop.unifyworkbench.service.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.redare.devframework.webplatform.sdk.common.arg.DictionaryArg;
import com.redare.devframework.webplatform.sdk.common.pojo.Dictionary;
import com.redare.devframework.webplatform.service.common.service.DictionaryService;
import com.redare.shop.unifyworkbench.sdk.pojo.Department;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DepartmentForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportPersonnelInfoForm;
import com.redare.shop.unifyworkbench.service.service.DepartmentService;
import com.redare.shop.unifyworkbench.service.service.ImportFileInfoService;
import com.redare.shop.unifyworkbench.service.service.ImportPersonnelInfoService;
import com.redare.shop.unifyworkbench.service.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/20 10:06
 * @version:
 */
public class ImportPersonnelInfoListener extends AnalysisEventListener<ImportPersonnelInfoExcel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportPersonnelInfoListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 2000;

    List<ImportPersonnelInfoExcel> list = new ArrayList<>();
    /**
     * 民族
     */
    List<Dictionary> nationList = new ArrayList<>();
    /**
     * 政治面貌
     */
    List<Dictionary> politicList = new ArrayList<>();
    /**
     * 任职职位
     */
    List<Dictionary> positionList = new ArrayList<>();
    /**
     * 最高学历
     */
    List<Dictionary> educationList = new ArrayList<>();
    /**
     * 任职类型
     */
    List<Dictionary> positionTypeList = new ArrayList<>();
    /**
     * 导入人员
     */
    List<ImportPersonnelInfo> personnelInfos = new ArrayList<>();
    /**
     * 部门信息
     */
    List<Department> departmentList = new ArrayList<>();

    /**
     * 数据导入类型:1-执委名单导入；2-人员名单导入
     */
    String importType;

    ImportFileInfoForm.Add fileAdd;

    DictionaryService dictionaryService;

    ImportPersonnelInfoService importPersonnelInfoService;

    ImportFileInfoService importFileInfoService;

    DepartmentService departmentService;



    public ImportPersonnelInfoListener(DictionaryService dictionaryService, ImportPersonnelInfoService importPersonnelInfoService,
                                       ImportFileInfoService importFileInfoService, String importType, ImportFileInfoForm.Add fileAdd, DepartmentService departmentService){
        this.dictionaryService = dictionaryService;
        this.importFileInfoService = importFileInfoService;
        this.importPersonnelInfoService = importPersonnelInfoService;
        this.importType = importType;
        this.fileAdd = fileAdd;
        this.departmentService = departmentService;
    }

    @Override
    public void invoke(ImportPersonnelInfoExcel importPersonnelInfoExcel, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(importPersonnelInfoExcel));
        list.add(importPersonnelInfoExcel);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    private void saveData(){
        final int size = list.size();
        LOGGER.info("{}条数据，开始检验合法性！", size);
        nationList = dictionaryService.findDictionaryList(new DictionaryArg.Search().setParentCode("nationName").setPlatform("shop").setStatus(1));
        politicList = dictionaryService.findDictionaryList(new DictionaryArg.Search().setParentCode("politicName").setPlatform("shop").setStatus(1));
        positionList = dictionaryService.findDictionaryList(new DictionaryArg.Search().setParentCode("womenPosition").setPlatform("shop").setStatus(1));
        educationList = dictionaryService.findDictionaryList(new DictionaryArg.Search().setParentCode("educationName").setPlatform("shop").setStatus(1));
        positionTypeList = dictionaryService.findDictionaryList(new DictionaryArg.Search().setParentCode("positionType").setPlatform("shop").setStatus(1));
        personnelInfos = importPersonnelInfoService.findImportPersonnelInfoList(new ImportPersonnelInfoForm.Search().setStatus(1).setImportType(importType).setOrgId(fileAdd.getOrgId()));
        departmentList = departmentService.findDepartmentList(new DepartmentForm.Search().setOrgId(fileAdd.getOrgId()).setStatus(1));
        //添加的集合
        List<ImportPersonnelInfo> addImportPersonnelInfos = new ArrayList<>();
        //数据重复的集合
        List<ImportPersonnelInfo> editImportPersonnelInfos = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            ImportPersonnelInfoExcel importPersonnelInfoExcel = list.get(i);
            if (StringUtils.isBlank(importPersonnelInfoExcel.getName())){
                throw new RuntimeException(String.format("第%s行【姓名】未填写", i + 2));
            }
            /*if (StringUtils.isBlank(importPersonnelInfoExcel.getBirthday())){
                throw new RuntimeException(String.format("第%s行【出生日期】未填写", i + 2));
            }
            if (StringUtils.isBlank(importPersonnelInfoExcel.getCardNo())){
                throw new RuntimeException(String.format("第%s行【身份证号码】未填写", i + 2));
            }
            if(!IDCardVerifyUtil.isIdNum(importPersonnelInfoExcel.getCardNo())){
                throw new RuntimeException(String.format("第%s行【身份证号码】格式错误",i+2));
            }
            if (StringUtils.isBlank(importPersonnelInfoExcel.getSex())){
                throw new RuntimeException(String.format("第%s行【性别】未填写",i+2));
            }
            if (StringUtils.isBlank(importPersonnelInfoExcel.getNation())){
                throw new RuntimeException(String.format("第%s行【民族】未填写",i+2));
            }
            if (StringUtils.isBlank(importPersonnelInfoExcel.getPolitic())){
                throw new RuntimeException(String.format("第%s行【政治面貌】未填写",i+2));
            }
            if (StringUtils.isBlank(importPersonnelInfoExcel.getPosition())){
                throw new RuntimeException(String.format("第%s行【任职职位】未填写",i+2));
            }
            if (StringUtils.isBlank(importPersonnelInfoExcel.getPositionType())){
                throw new RuntimeException(String.format("第%s行【任职类型】未填写",i+2));
            }
            if (StringUtils.isBlank(importPersonnelInfoExcel.getPositionTime())){
                throw new RuntimeException(String.format("第%s行【任职时间】未填写",i+2));
            }
            if (StringUtils.isBlank(importPersonnelInfoExcel.getEducation())){
                throw new RuntimeException(String.format("第%s行【最高学历】未填写",i+2));
            }*/
            if (StringUtils.isBlank(importPersonnelInfoExcel.getMobile())){
                throw new RuntimeException(String.format("第%s行【手机号码】未填写", i + 2));
            }else {
                String reg = "^1[3|4|5|7|8][0-9]\\d{8}$";
                Pattern pattern = Pattern.compile(reg);
                Matcher matcher = pattern.matcher(importPersonnelInfoExcel.getMobile());
                if (!matcher.matches()){
                    throw new RuntimeException(String.format("第%s行【手机号码】格式不正确", i + 2));
                }
            }
            //数据重复
            Optional<ImportPersonnelInfo> optional = personnelInfos.stream().filter(e->importPersonnelInfoExcel.getMobile().equals(e.getMobile())).findFirst();
            //Optional<ImportPersonnelInfo> optional = personnelInfos.stream().filter(e->importPersonnelInfoExcel.getCardNo().equals(e.getCardNo())).findFirst();
            if (optional.isPresent()){
                ImportPersonnelInfo importPersonnelInfo = optional.get();
                importPersonnelInfo.setStatus(-1);
                editImportPersonnelInfos.add(importPersonnelInfo);
            }
            ImportPersonnelInfo importPersonnelInfo = new ImportPersonnelInfo();
            BeanUtils.copyProperties(importPersonnelInfoExcel,importPersonnelInfo);
            if (StringUtils.isNotBlank(importPersonnelInfoExcel.getNation())){
                nationList.stream().filter(e->importPersonnelInfoExcel.getNation().replaceAll(" ","").equals(e.getDicName())).findFirst()
                        .ifPresent(dictionary -> importPersonnelInfo.setNationId((int) dictionary.getId()));
            }
            if (StringUtils.isNotBlank(importPersonnelInfoExcel.getPolitic())){
                politicList.stream().filter(e->importPersonnelInfoExcel.getPolitic().replaceAll(" ","").equals(e.getDicName())).findFirst()
                        .ifPresent(dictionary -> importPersonnelInfo.setPoliticId((int) dictionary.getId()));
            }
            if (StringUtils.isNotBlank(importPersonnelInfoExcel.getPosition())){
                positionList.stream().filter(e->importPersonnelInfoExcel.getPosition().replaceAll(" ","").equals(e.getDicName())).findFirst()
                        .ifPresent(dictionary -> importPersonnelInfo.setPositionId((int) dictionary.getId()));
            }
            if (StringUtils.isNotBlank(importPersonnelInfoExcel.getEducation())){
                educationList.stream().filter(e->importPersonnelInfoExcel.getEducation().replaceAll(" ","").equals(e.getDicName())).findFirst()
                        .ifPresent(dictionary -> importPersonnelInfo.setEducationId((int) dictionary.getId()));
            }
            if (StringUtils.isNotBlank(importPersonnelInfoExcel.getPositionType())){
                positionTypeList.stream().filter(e->importPersonnelInfoExcel.getPositionType().replaceAll(" ","").equals(e.getDicName())).findFirst()
                        .ifPresent(dictionary -> importPersonnelInfo.setPositionTypeCode(dictionary.getDicCode()));
            }
            if (StringUtils.isNotBlank(importType) && "executive".equals(importType)){
                departmentList.stream().filter(e->"执委".equals(e.getDeptName().trim())).findFirst()
                        .ifPresent(department -> importPersonnelInfo.setDeptId(department.getDepartmentId()));
                importPersonnelInfo.setDeptName("执委");
            }
            if (StringUtils.isNotBlank(importType) && "person".equals(importType)){
                Optional<Department> optionalDepartment = departmentList.stream().filter(e->importPersonnelInfoExcel.getDeptName()!=null && importPersonnelInfoExcel.getDeptName().trim().equals(e.getDeptName().trim())).findFirst();
                if (optionalDepartment.isPresent()){
                    Department department = optionalDepartment.get();
                    importPersonnelInfo.setDeptId(department.getDepartmentId());
                    importPersonnelInfo.setDeptName(department.getDeptName());
                }else {
                    departmentList.stream().filter(e->e.getDeptName()!=null && "直属".equals(e.getDeptName().trim())).findFirst()
                            .ifPresent(department -> importPersonnelInfo.setDeptId(department.getDepartmentId()));
                    importPersonnelInfo.setDeptName("直属");
                }
            }
            importPersonnelInfo.setName(importPersonnelInfo.getName().replaceAll(" ",""));
            importPersonnelInfo.setOrgId(fileAdd.getOrgId());
            importPersonnelInfo.setOrgName(fileAdd.getOrgName());
            importPersonnelInfo.setBirthday(StringUtils.isNotBlank(importPersonnelInfoExcel.getBirthday())?DateUtils.stringToDate(importPersonnelInfoExcel.getBirthday(),"yyyy-MM-dd HH:mm:ss"):null);
            importPersonnelInfo.setPartyDate(StringUtils.isNotBlank(importPersonnelInfoExcel.getPartyDate())?DateUtils.stringToDate(importPersonnelInfoExcel.getPartyDate(),"yyyy-MM-dd HH:mm:ss"):null);
            importPersonnelInfo.setPositionTime(StringUtils.isNotBlank(importPersonnelInfoExcel.getPositionTime())?DateUtils.stringToDate(importPersonnelInfoExcel.getPositionTime(),"yyyy-MM-dd HH:mm:ss"):null);
            importPersonnelInfo.setGraduationTime(StringUtils.isNotBlank(importPersonnelInfoExcel.getGraduationTime())?DateUtils.stringToDate(importPersonnelInfoExcel.getGraduationTime(),"yyyy-MM-dd HH:mm:ss"):null);
            importPersonnelInfo.setServedTime(StringUtils.isNotBlank(importPersonnelInfoExcel.getServedTime())?DateUtils.stringToDate(importPersonnelInfoExcel.getServedTime(),"yyyy-MM-dd HH:mm:ss"):null);
            importPersonnelInfo.setChangeAccount(0);
            importPersonnelInfo.setImportType(importType);
            importPersonnelInfo.setCreateTime(new Date());
            importPersonnelInfo.setUpdateTime(new Date());
            importPersonnelInfo.setStatus(1);
            importPersonnelInfo.setRosterName(fileAdd.getRosterName());
            importPersonnelInfo.setAreaCode(fileAdd.getAreaCode());
            importPersonnelInfo.setAreaName(fileAdd.getAreaName());
            importPersonnelInfo.setUserId(fileAdd.getUploadUserId());
            importPersonnelInfo.setUserName(fileAdd.getUploadUserName());
            addImportPersonnelInfos.add(importPersonnelInfo);
        }

        importPersonnelInfoService.addInfo(fileAdd,editImportPersonnelInfos,addImportPersonnelInfos,size);

    }
}
