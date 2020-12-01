package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;

import com.redare.shop.unifyworkbench.sdk.pojo.Importemplate;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ImportemplateForm;
import com.redare.shop.unifyworkbench.service.dao.ImportemplateDao;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Excel导入模板表：ImportemplateService
 *
 * @author yj
 * @email yangj@redare.cn
 * @date 2020-03-17
 */
@Service
public class ImportemplateService {
    @Autowired
    ImportemplateDao importemplateDao;
    public Page<Importemplate> findImportemplatePage(ImportemplateForm.Search form, int curPage, int pageSize){
        return importemplateDao.findImportemplatePage(form, curPage, pageSize, true, false);
    }
    public List<Importemplate> findImportemplateList(ImportemplateForm.Search form, int curPage, int pageSize){
        return  importemplateDao.findImportemplatePage(form, curPage, pageSize, false, false).getResult();
    }
    public List<Importemplate> findImportemplateList(ImportemplateForm.Search form){
        return  importemplateDao.findImportemplatePage(form, 0, 0, false, true).getResult();
    }
    public Importemplate getImportemplate(ImportemplateForm.Get form){
        return importemplateDao.getImportemplate(form);
    }
    @Transactional
    public Boolean addImportemplate(ImportemplateForm.Add form){
        ImportemplateForm.Search search = new ImportemplateForm.Search();
        search.setType(form.getType());
        List<Importemplate> list = importemplateDao.findImportemplatePage(search,0,0,false,true).getResult();
        if(CollectionUtils.isNotEmpty(list)){
            for(Importemplate template:list){
                ImportemplateForm.Edit editForm = new ImportemplateForm.Edit();
                editForm.setId(template.getId());
                editForm.setStatus(-1);
                importemplateDao.editImportemplate(editForm);
            }
        }
        return importemplateDao.addImportemplate(form);
    }
    public Boolean editImportemplate(ImportemplateForm.Edit form){
        return importemplateDao.editImportemplate(form);
    }
    public Boolean deleteImportemplate(ImportemplateForm.Del form){
        return importemplateDao.deleteImportemplate(form);
    }

    /**
     * @description 根据类型查询模板
     * @author zlx
     * @date 2020/11/21 10:57
     * @param type
     * @return com.redare.shop.unifyworkbench.sdk.pojo.Importemplate
     */
    public Importemplate findImportemplateByType(String type){
        return importemplateDao.findImportemplateByType(type);
    }
}
