package com.redare.shop.unifyworkbench.service.excel;

import com.alibaba.fastjson.JSON;
import com.redare.shop.unifyworkbench.sdk.pojo.form.ActivitySignForm;
import com.redare.shop.unifyworkbench.service.service.ActivitySignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.beans.BeanUtils;


public class SignExcelListener extends AnalysisEventListener<SignExcelModel> {
        private static final Logger LOGGER = LoggerFactory.getLogger(SignExcelListener.class);
        /**
         * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
         */
        private static final int BATCH_COUNT = 5;
        List<SignExcelModel> list = new ArrayList<SignExcelModel>();
        /**
         * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
         */
        private ActivitySignService activitySignService;
        private ActivitySignForm.ImportForm importForm;
        public SignExcelListener( ActivitySignService activitySignService,ActivitySignForm.ImportForm form) {
            // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
            this.activitySignService = activitySignService;
            this.importForm=form;
        }

        /**
         * 这个每一条数据解析都会来调用
         *
         * @param signExcelModel
         *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
         * @param analysisContext
         */


    @Override
    public void invoke(SignExcelModel signExcelModel, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(signExcelModel));
        list.add(signExcelModel);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
         * 所有数据解析完成了 都会来调用
         *
         * @param context
         */
        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            // 这里也要保存数据，确保最后遗留的数据也存储到数据库
            saveData();
            LOGGER.info("所有数据解析完成！");
        }
        /**
         * 加上存储数据库
         */
        private void saveData() {
            LOGGER.info("{}条数据，开始存储数据库！", list.size());

            ActivitySignForm.BatchAdd  batchAdd = new ActivitySignForm.BatchAdd();
            List<ActivitySignForm.Add> signImportList=new ArrayList<>();
            for (SignExcelModel signExcelModel : list) {
                ActivitySignForm.Add signImport = new ActivitySignForm.Add();
                BeanUtils.copyProperties(signExcelModel, signImport);
                signImport.setActivityId(importForm.getActivityId());
                signImport.setType(importForm.getType());
                signImportList.add(signImport);
            }
            batchAdd.setAddList(signImportList);
            activitySignService.batchAddSignInfo(batchAdd);
            LOGGER.info("存储数据库成功！");
        }
    }

