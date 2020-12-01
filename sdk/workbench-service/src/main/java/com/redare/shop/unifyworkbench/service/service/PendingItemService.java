package com.redare.shop.unifyworkbench.service.service;

import com.redare.devframework.common.pojo.Page;
import com.redare.shop.unifyworkbench.sdk.pojo.PendingItem;
import com.redare.shop.unifyworkbench.sdk.pojo.UserMessage;
import com.redare.shop.unifyworkbench.sdk.pojo.form.UserMessageForm;
import com.redare.shop.unifyworkbench.service.dao.PendingItemDao;
import com.redare.shop.unifyworkbench.service.dao.UserMessageDao;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PendingItemService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PendingItemService.class);
    @Autowired
    private PendingItemDao pendingItemDao;
    @Autowired
    UserMessageDao userMessageDao;

    /**
     * 分页查询待办列表
     * @param form
     * @param curPage
     * @param pageSize
     * @return
     */
    public Page<PendingItem> queryPendingItemPage(PendingItem form, int curPage, int pageSize){
        Page<PendingItem> page = pendingItemDao.queryPendingItemPage(form,curPage,pageSize,true,false);
        List<PendingItem> list = page.getResult();
        List<PendingItem> newList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for(PendingItem item:list){
                UserMessageForm.Search search = new UserMessageForm.Search();
                search.setBizId(item.getId().toString());
                if("report".equals(item.getType())){
                    search.setBizTable("t_report");
                }else{
                    search.setBizTable("t_assign");
                }
                search.setReaded(1);
                List<UserMessage> userMessageList = userMessageDao.queryForPageMessageByBizId(search,0,0,false,true).getResult();
                item.setUserMessageList(userMessageList);
                newList.add(item);
            }
        }
        page.setResult(newList);
        return page;
    }

    public List<PendingItem> queryPendingItemList(PendingItem form, int curPage, int pageSize){
        List<PendingItem> list = pendingItemDao.queryPendingItemPage(form,curPage,pageSize,false,false).getResult();
        List<PendingItem> newList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for(PendingItem item:list){
                UserMessageForm.Search search = new UserMessageForm.Search();
                search.setBizId(item.getId().toString());
                if("report".equals(item.getType())){
                    search.setBizTable("t_report");
                }else{
                    search.setBizTable("t_assign");
                }
                search.setReaded(1);
                List<UserMessage> userMessageList = userMessageDao.queryForPageMessageByBizId(search,0,0,false,true).getResult();
                item.setUserMessageList(userMessageList);
                newList.add(item);
            }
        }
        return newList;
    }

    public List<PendingItem> queryPendingItemList(PendingItem form){
        List<PendingItem> list = pendingItemDao.queryPendingItemPage(form,0,0,false,true).getResult();
        List<PendingItem> newList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for(PendingItem item:list){
                UserMessageForm.Search search = new UserMessageForm.Search();
                search.setBizId(item.getId().toString());
                if("report".equals(item.getType())){
                    search.setBizTable("t_report");
                }else{
                    search.setBizTable("t_assign");
                }
                search.setReaded(1);
                List<UserMessage> userMessageList = userMessageDao.queryForPageMessageByBizId(search,0,0,false,true).getResult();
                item.setUserMessageList(userMessageList);
                newList.add(item);
            }
        }
        return newList;
    }

    public Page<PendingItem> queryHandledItemPage(PendingItem form,int curPage, int pageSize){
        return pendingItemDao.queryHandledItemPage(form,curPage,pageSize,true,false);
    }

    public List<PendingItem> queryHandledItemList(PendingItem form,int curPage, int pageSize){
        return pendingItemDao.queryHandledItemPage(form,curPage,pageSize,false,false).getResult();
    }

    public List<PendingItem> queryHandledItemList(PendingItem form){
        return pendingItemDao.queryHandledItemPage(form,0,0,false,true).getResult();
    }

    public PendingItem queryItemCount(PendingItem form){
        return pendingItemDao.queryItemCount(form);
    }
}
