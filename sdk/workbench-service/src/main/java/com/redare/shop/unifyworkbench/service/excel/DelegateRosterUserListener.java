package com.redare.shop.unifyworkbench.service.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.redare.devframework.webplatform.sdk.common.pojo.Dictionary;
import com.redare.shop.unifyworkbench.sdk.pojo.form.DelegateRosterUserForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;
import com.redare.shop.unifyworkbench.service.impl.DelegateRosterUserSdkImpl;
import com.redare.shop.unifyworkbench.service.service.DelegateRosterUserService;
import com.redare.shop.unifyworkbench.service.util.IDCardVerifyUtil;
import com.redare.shop.unifyworkbench.service.util.PhoneFormatCheckUtils;
import net.sf.ehcache.util.NamedThreadFactory;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class DelegateRosterUserListener extends AnalysisEventListener<DelegateRosterUserModel> {
    /**
     * 代表名册人员导入异步线程池
     */
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(500), new NamedThreadFactory("代表名册人员导入异步线程池"));

    private static final Logger LOGGER = LoggerFactory.getLogger(DelegateRosterUserListener.class);

    /**
     * 每隔3000条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 3000;
    List<DelegateRosterUserModel> list = new ArrayList<>();

    private Map<String,Object> map;

    private DelegateRosterUserService delegateRosterUserService;

    private ImportFileInfoForm.Add form;

    private String type;


    public DelegateRosterUserListener(Map<String,Object> map, DelegateRosterUserService delegateRosterUserService, ImportFileInfoForm.Add form,String type){
        this.map = map;
        this.delegateRosterUserService = delegateRosterUserService;
        this.form = form;
        this.type = type;
    }

    @Override
    public void invoke(DelegateRosterUserModel model, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", model);
        list.add(model);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成，都会来调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() throws RuntimeException {
        final int size = list.size();
        LOGGER.info("{}条数据，开始检验合法性！", size);
        Runnable runnable = null;
        form.setType(type);
        List<DelegateRosterUserForm.Add> importList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (int j = 0; j < list.size(); j++) {
                DelegateRosterUserModel excelModel = list.get(j);
                if (StringUtils.isBlank(excelModel.getName())) {
                    throw new RuntimeException(String.format("第%s行[姓名]未填写完整 或 格式不对", j + 1));
                }
                if(StringUtils.isBlank(excelModel.getWorkUnit())){
                    throw new RuntimeException(String.format("第%s行[工作单位及职务]未填写",j+1));
                }
                if(StringUtils.isBlank(excelModel.getNation())){
                    throw new RuntimeException(String.format("第%s行[民族]未填写",j+1));
                }
                if(StringUtils.isBlank(excelModel.getNativePlace())){
                    throw new RuntimeException(String.format("第%s行[籍贯]未填写",j+1));
                }
                if(excelModel.getBirthday()==null){
                    throw new RuntimeException(String.format("第%s行[出生日期]未填写",j+1));
                }
                if(StringUtils.isBlank(excelModel.getIdCardNo())){
                    throw new RuntimeException(String.format("第%s行[身份证号码]未填写",j+1));
                }
                if(!IDCardVerifyUtil.isIdNum(excelModel.getIdCardNo())){
                    throw new RuntimeException(String.format("第%s行[身份证号码]格式错误或不存在",j+1));
                }
                if(StringUtils.isBlank(excelModel.getEducation())){
                    throw new RuntimeException(String.format("第%s行[学历]未填写",j+1));
                }
                if(StringUtils.isBlank(excelModel.getMobile())){
                    throw new RuntimeException(String.format("第%s行[手机号]码未填写",j+1));
                }
                if(!PhoneFormatCheckUtils.isChinaPhoneLegal(excelModel.getMobile())){
                    throw new RuntimeException(String.format("第%s行[手机号]码格式不正确",j+1));
                }
                DelegateRosterUserForm.Add addForm = new DelegateRosterUserForm.Add();
                BeanUtils.copyProperties(excelModel,addForm);
                addForm.setRosterId(form.getRosterId());
                addForm.setAreaCode(form.getAreaCode());
                addForm.setAreaName(form.getAreaName());
                addForm.setOrgId(form.getOrgId());
                addForm.setOrgName(form.getOrgName());
                addForm.setUserId(form.getUploadUserId());
                addForm.setUserName(form.getUploadUserName());
                if(map.get(DelegateRosterUserSdkImpl.NATION_DICT)!=null){
                    List<Dictionary> nationList = (List<Dictionary>) map.get(DelegateRosterUserSdkImpl.NATION_DICT);
                    List<Dictionary> list = nationList.stream().filter(e->e.getDicName().equals(addForm.getNation())).collect(Collectors.toList());
                    if(CollectionUtils.isNotEmpty(list)){
                        addForm.setNationDictId(list.get(0).getId());
                    }
                }
                if(map.get(DelegateRosterUserSdkImpl.EDUCATION_DICT)!=null){
                    List<Dictionary> educationList = (List<Dictionary>) map.get(DelegateRosterUserSdkImpl.EDUCATION_DICT);
                    List<Dictionary> list = educationList.stream().filter(e->e.getDicName().equals(addForm.getEducation())).collect(Collectors.toList());
                    if(CollectionUtils.isNotEmpty(list)){
                        addForm.setEducationDictId(list.get(0).getId());
                    }
                }
                if(map.get(DelegateRosterUserSdkImpl.PARTIES_DICT)!=null){
                    List<Dictionary> partiesList = (List<Dictionary>) map.get(DelegateRosterUserSdkImpl.PARTIES_DICT);
                    List<Dictionary> list = partiesList.stream().filter(e->e.getDicName().equals(addForm.getParties())).collect(Collectors.toList());
                    if(CollectionUtils.isNotEmpty(list)){
                        addForm.setPartiesDictId(list.get(0).getId());
                    }
                }
                importList.add(addForm);
            }
            runnable = () -> {
                LOGGER.info("导入的代表名册人员数据{}条，开始存储数据库！", size);
                delegateRosterUserService.addDelegateRosterUser(form,importList);
            };

            LOGGER.info("导入的代表名册合法性校验完成，共计{}条", size);
            threadPoolExecutor.submit(runnable);
        }else{
            throw new RuntimeException(String.format("导入的Excel中没有数据，请检查文档数据！"));
        }
    }
}
