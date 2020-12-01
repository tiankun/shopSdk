package com.redare.shop.unifyworkbench.service.service;

import com.redare.shop.unifyworkbench.sdk.OrganizationSdk;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseUserInfo;
import com.redare.shop.unifyworkbench.sdk.pojo.Area;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AreaForm;
import com.redare.shop.unifyworkbench.service.dao.AreaDao;
import com.redare.shop.unifyworkbench.service.dao.BaseUserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: guangrongyang
 * @Date: 2020/10/20 14:16
 */
@Service
@PropertySource("classpath:config.properties")
public class BaseUserInfoService {
    /**
     * 是否开启强制修改密码
     */
    @Value("${change.password.switch}")
    private String changePasswordSwitch = "no";

    @Autowired
    BaseUserInfoDao baseUserInfoDao;
    @Autowired
    AreaDao areaDao;

    public BaseUserInfo queryBaseUserInfo(BaseUserInfo form) {
        List<BaseUserInfo> list = baseUserInfoDao.queryBaseUserInfo(form);
        if (list.size() == 1) {
            final BaseUserInfo baseUserInfo = list.get(0);
            //默认密码需要修改
            if (baseUserInfo.getPwd().equals("0659c7992e268962384eb17fafe88364")){
                baseUserInfo.setChangePasswordSwitch(changePasswordSwitch);
            }
            baseUserInfo.setPwd(null);
            //根据areaCode,查询上级组织
            Area area = areaDao.queryArea(new AreaForm.Get().setAreaCode(baseUserInfo.getAreaCode()));
            //上级区域纵向组织
            List<Area> areaList = areaDao.queryAreaOrgList(new AreaForm.Search().setAreaCode(area.getParentCode()).setOrgClassify(OrganizationSdk.ORG_CLASSIFY_ZX));
            //当前区域纵向组织
            List<Area> arealist = areaDao.queryAreaOrgList(new AreaForm.Search().setAreaCode(area.getAreaCode()).setOrgClassify(OrganizationSdk.ORG_CLASSIFY_ZX));
            if (areaList.size() ==1){
                baseUserInfo.setOrgParentId(areaList.get(0).getOrgId());
                baseUserInfo.setOrgParentName(areaList.get(0).getOrgName());
            }
            //根据当前用户的组织分类（横向/纵向），设置接收组织
            if(OrganizationSdk.ORG_CLASSIFY_ZX.equals(baseUserInfo.getOrgClassify())){
                if (areaList.size() ==1) {
                    baseUserInfo.setReceiveOrgId(areaList.get(0).getOrgId());
                    baseUserInfo.setReceiveOrgName(areaList.get(0).getOrgName());
                }
            }else{
                if(arealist.size() == 1){
                    baseUserInfo.setReceiveOrgId(arealist.get(0).getOrgId());
                    baseUserInfo.setReceiveOrgName(arealist.get(0).getOrgName());
                }
            }
            return baseUserInfo;
        } else {
            return null;
        }
    }

    public List<BaseUserInfo> queryBaseUserInfoList(BaseUserInfo form) {
        return baseUserInfoDao.queryBaseUserInfo(form);
    }
}
