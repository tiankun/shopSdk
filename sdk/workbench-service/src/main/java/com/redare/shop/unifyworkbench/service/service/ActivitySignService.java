package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.ActivitySign;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivitySignForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.service.dao.ActivitySignDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (ActivitySign)表服务接口
 *
 * @author dengchj
 * @since 2020-10-20 17:34:46
 */
@Service
public class ActivitySignService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySignService.class);
    @Autowired
    ActivitySignDao activitySignDao;

    public long insertActivitySign(ActivitySignForm.Add form) {
        return activitySignDao.insertActivitySign(form);
    }

    public int updateActivitySign(ActivitySign form) {
        return activitySignDao.updateActivitySign(form);
    }

    public Page<ActivitySign> queryForPageActivitySign(ActivitySignForm.Search form, int curPage, int pageSize) {
        return activitySignDao.queryForPageActivitySign(form, curPage, pageSize, true, false);
    }

    public List<ActivitySign> queryForListActivitySign(ActivitySignForm.Search form) {
        return activitySignDao.queryForListActivitySign(form);
    }

    public ActivitySign queryForActivitySign(ActivitySignForm.Search form) {
        final List<ActivitySign> list = activitySignDao.queryForListActivitySign(form);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public int deleteActivitySign(CommonForm.Del form) {
        return activitySignDao.deleteActivitySign(form);
    }

    public Boolean batchDelActivitySign(CommonForm.BatchDel form) {
        return activitySignDao.batchDelActivitySign(form) > 0;
    }

   public List<ActivitySign> signCount(ActivitySignForm.Get form){
        return activitySignDao.signCount(form);
    }

    public int[] batchAddSignInfo(ActivitySignForm.BatchAdd form) {
        ActivitySignForm.DelByActivityIdAndType delByActivityIdAndType=new ActivitySignForm.DelByActivityIdAndType();
        for(ActivitySignForm.Add add:form.getAddList()){
         delByActivityIdAndType.setActivityId(add.getActivityId());
          delByActivityIdAndType.setType(add.getType());
        }
        activitySignDao.deleteSignByActivityIdAndType(delByActivityIdAndType);
        return  activitySignDao.batchAddSignInfo(form);
    }
    public boolean existSign(ActivitySignForm.Search form){
        return  activitySignDao.existSign(form);

    }

    public boolean existNeiBuSign(ActivitySignForm.Search form){
        return  activitySignDao.existNeiBuSign(form);
    }

    public int deleteActivitySignByActivityId(ActivitySignForm.DelByActivityId form){
        return  activitySignDao.deleteActivitySignByActivityId(form);
    }

    public int batchDeleteActivitySignByActivityId(ActivitySignForm.BatchDelByActivityId form){
        return activitySignDao.batchDeleteActivitySignByActivityId(form);
    }
}