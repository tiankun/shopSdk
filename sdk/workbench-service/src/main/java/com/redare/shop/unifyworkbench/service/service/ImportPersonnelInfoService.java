package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportFileInfoForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportPersonnelInfoForm;
import com.redare.shop.unifyworkbench.service.dao.ImportFileInfoDao;
import com.redare.shop.unifyworkbench.service.dao.ImportPersonnelInfoDao;
import com.redare.shop.unifyworkbench.service.util.UUIDutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zlx
 * @date: Created in 2020/11/19 18:31
 * @version:
 */
@Service
public class ImportPersonnelInfoService {

    @Autowired
    ImportPersonnelInfoDao importPersonnelInfoDao;

    @Autowired
    ImportFileInfoDao importFileInfoDao;

    /**
     * @description 分页查询
     * @author zlx
     * @date 2020/11/19 18:36
     * @param form
     * @param curPage
     * @param pageSize
     * @return com.redare.devframework.common.pojo.Page<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>
     */
    public Page<ImportPersonnelInfo> findImportPersonnelInfoPage(ImportPersonnelInfoForm.Search form,int curPage,int pageSize){
        return importPersonnelInfoDao.findImportPersonnelInfoPage(form,curPage,pageSize,true,false);
    }

    /**
     * @description 分页查询数据
     * @author zlx
     * @date 2020/11/19 18:37
     * @param form
     * @param curPage
     * @param pageSize
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>
     */
    public List<ImportPersonnelInfo> findImportPersonnelInfoPageList(ImportPersonnelInfoForm.Search form, int curPage, int pageSize){
        return importPersonnelInfoDao.findImportPersonnelInfoPage(form,curPage,pageSize,false,false).getResult();
    }

    /**
     * @description 查询所有数据
     * @author zlx
     * @date 2020/11/19 18:37
     * @param form
     * @return java.util.List<com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo>
     */
    public List<ImportPersonnelInfo> findImportPersonnelInfoList(ImportPersonnelInfoForm.Search form){
        return importPersonnelInfoDao.findImportPersonnelInfoPage(form,0,0,false,true).getResult();
    }

    /**
     * @description 根据主键id查询数据
     * @author zlx
     * @date 2020/11/19 18:38
     * @param form
     * @return com.redare.shop.unifyworkbench.sdk.pojo.ImportPersonnelInfo
     */
    public ImportPersonnelInfo findImportPersonnelInfo(ImportPersonnelInfoForm.Get form){
        return importPersonnelInfoDao.findImportPersonnelInfo(form);
    }

    /**
     * @description 添加数据
     * @author zlx
     * @date 2020/11/19 18:40
     * @param form
     * @return java.lang.Long
     */
    public Long addImportPersonnelInfo(ImportPersonnelInfoForm.Add form){
        return importPersonnelInfoDao.addImportPersonnelInfo(form);
    }

    /**
     * 查询执行委员名单
     * @param form
     * @return
     */
    public List<ImportPersonnelInfo> findRosterList(ImportPersonnelInfoForm.Search form){
        return importPersonnelInfoDao.findRosterList(form);
    }

    /**
     * @description 编辑数据
     * @author zlx
     * @date 2020/11/19 18:40
     * @param form
     * @return boolean
     */
    public boolean editImportPersonnelInfo(ImportPersonnelInfoForm.Edit form){
        return importPersonnelInfoDao.editImportPersonnelInfo(form);
    }

    /**
     * @description 删除数据
     * @author zlx
     * @date 2020/11/19 18:41
     * @param form
     * @return boolean
     */
    public boolean delImportPersonnelInfo(ImportPersonnelInfoForm.Del form){
        return importPersonnelInfoDao.delImportPersonnelInfo(form);
    }

    /**
     * 删除执委名单
     * @param form
     * @return
     */
    public int delByRosterId(ImportPersonnelInfoForm.BatchDel form){
        return importPersonnelInfoDao.delByRosterId(form);
    }


    /**
     * @description 批量添加数据
     * @author zlx
     * @date 2020/11/20 15:35
     * @param list
     * @return int[]
     */
    public int[] batchAdd(List<ImportPersonnelInfo> list,Long recordId){
        return importPersonnelInfoDao.batchAdd(list,recordId);
    }

    /**
     * @description 批量修改状态
     * @author zlx
     * @date 2020/11/20 15:39
     * @param list
     * @return int
     */
    public int batchEditStatus(List<Long> list){
        return importPersonnelInfoDao.batchEditStatus(list);
    }


    @Transactional
    public void addInfo(ImportFileInfoForm.Add fileAdd, List<ImportPersonnelInfo> editImportPersonnelInfos, List<ImportPersonnelInfo> addImportPersonnelInfos, int size){
        try {
            Long recordId = importFileInfoDao.addImportFileInfo(fileAdd);
            String rosterId = UUIDutils.get32UUID();
            if (editImportPersonnelInfos.size() > 0){
                List<Long> idList = editImportPersonnelInfos.stream().map(ImportPersonnelInfo::getId).collect(Collectors.toList());
                importPersonnelInfoDao.batchEditStatus(idList);
            }
            if (addImportPersonnelInfos.size()>0){
                importPersonnelInfoDao.batchAdd(addImportPersonnelInfos,recordId,rosterId);
            }
            importFileInfoDao.editImportCount(size,recordId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
