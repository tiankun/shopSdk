package com.redare.shop.unifyworkbench.service.impl;

import com.redare.devframework.common.pojo.CommonResult;
import com.redare.devframework.common.pojo.Page;
import com.redare.devframework.common.validation.ValidationUtils;
import com.redare.shop.unifyworkbench.sdk.AreaSdk;
import com.redare.shop.unifyworkbench.sdk.common.pojo.BaseLevelTreeQuery;
import com.redare.shop.unifyworkbench.sdk.pojo.Area;
import com.redare.shop.unifyworkbench.sdk.pojo.form.AreaForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.CommonForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.OrganizationForm;
import com.redare.shop.unifyworkbench.sdk.pojo.form.TreeNode;
import com.redare.shop.unifyworkbench.service.service.AreaService;
import com.redare.shop.unifyworkbench.service.service.OrganizationService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 行政区域编码表(Area)SdkImpl
 *
 * @author yanggr
 * @since 2020-10-21 15:05:55
 */
@Service
public class AreaSdkImpl implements AreaSdk {
    private static final Logger LOGGER = LoggerFactory.getLogger(AreaSdkImpl.class);
    public static final String ORG_ID_PREFIX = "orgId_";
    public static final String AREA_ID_PREFIX = "areaCode_";
    List<TreeNode> userTreeList;
    List<TreeNode> orgList;

    /**
     * 区域树结果缓存
     */
    Map<String, Map> areaTreeCache = new HashMap<>();
    /**
     * 区域List缓存
     */
    private Map<String, List<TreeNode>> areaListCache = new HashMap<>();
    /**
     * 区域加组织
     */
    Map<String, Object> areaAndOrgTreeCache;

    @Autowired
    AreaService areaService;
    @Autowired
    OrganizationService organizationService;
    private List<TreeNode> areaTreeList;

    @Override
    public CommonResult<Boolean> insertArea(Area form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        final long id = areaService.insertArea(form);
        return CommonResult.returnSuccessWrapper(id > 0);
    }

    @Override
    public CommonResult<Boolean> updateArea(Area form) {
        if (form.getId() == null) {
            return CommonResult.returnFailsWrapper("主键不能为空");
        }
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = areaService.updateArea(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Boolean> deleteArea(CommonForm.Del form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }

        int row = areaService.deleteArea(form);
        return CommonResult.returnSuccessWrapper(row > 0);
    }


    @Override
    public CommonResult<Boolean> updateAreaStatus(AreaForm.Edit form) {
        CommonResult commonResult = ValidationUtils.simpleValidate(form);
        if (commonResult.isNotSuccess()) {
            return CommonResult.returnFailsWrapper(commonResult.getMessage());
        }
        final Area targetForm = new Area();
        try {
            BeanUtils.copyProperties(form, targetForm);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return CommonResult.returnFailsWrapper(e.getMessage());
        }
        int row = areaService.updateArea(targetForm);
        return CommonResult.returnSuccessWrapper(row > 0);
    }

    @Override
    public CommonResult<Page<Area>> queryForPageArea(AreaForm.Search form, int curPage, int pageSize) {
        Page<Area> data = areaService.queryForPageArea(form, curPage, pageSize);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<List<Area>> queryForListArea(AreaForm.Search form) {
        List<Area> data = areaService.queryForListArea(form);
        return CommonResult.returnSuccessWrapper(data);
    }

    @Override
    public CommonResult<Area> queryArea(AreaForm.Search form) {
        List<Area> data = areaService.queryForListArea(form);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    @Override
    public CommonResult<Boolean> batchDelArea(CommonForm.BatchDel form) {
        if (form == null) {
            return CommonResult.returnFailsWrapper("请传入参数");
        }
        if (form.getIds() == null || form.getIds().size() <= 0) {
            return CommonResult.returnFailsWrapper("请传入主键id");
        }
        Boolean bool = areaService.batchDelArea(form);

        return CommonResult.returnBoolWrapper(bool, "批量删除失败");
    }

    @Override
    public CommonResult<Map<String, List<TreeNode>>> queryAreaTree(BaseLevelTreeQuery form) {
        CommonResult<Map<String, List<TreeNode>>> validateResult = validateParams(form);
        if (validateResult != null){
            return validateResult;
        }
        String cacheKey = new StringBuilder().append((String) form.getLevelId()).append(form.getRootId()).append(form.getLevelNum()).append(form.isIncSelf()).append(form.getIncludeRoot()).append(form.isUp()).append(form.isLevelNumOnly()).toString();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("区域树cacheKey:{}",cacheKey);
        }
        //从缓存中取值
        if (areaTreeCache.containsKey(cacheKey)) {
            return CommonResult.returnSuccessWrapper(areaTreeCache.get(cacheKey));
        }
        final List<TreeNode> areaList = areaService.queryAreaTreeNode(form);
        //加入缓存
        areaListCache.put(cacheKey, areaList);

        //新包装Tree的返回值
        List<TreeNode> resultTree = new ArrayList<>();
        //新包装Array的返回值
        List<TreeNode> resultList = new ArrayList<>();

        TreeNode treeNode = new TreeNode();
        treeNode.setKey(ORG_ID_PREFIX + "-1");
        treeNode.setTitle("全部");
        treeNode.setChildren(getChilds(form.getRootId(), depCopy(areaList),false));

        resultTree.add(treeNode);
        //不包含root节点
        if (!form.getIncludeRoot()) {
            resultTree =treeNode.getChildren();
        }

        resultList.addAll(areaList);

        final Map<String, List<TreeNode>> map = new HashMap<>();
        map.put("resultTree", resultTree);
//        map.put("resultList", resultList);

        //加入缓存
        areaTreeCache.put(cacheKey,map);
        return CommonResult.returnSuccessWrapper(map);
    }

    @Override
    public CommonResult<List<TreeNode>> queryAreaList(BaseLevelTreeQuery form) {
        if (form.getLevelNum() > 4 || form.getLevelNum() < 1) {
            return CommonResult.returnFailsWrapper("层级超过范围1-4");
        }
        if (StringUtils.isBlank((String) form.getLevelId())) {
            return CommonResult.returnFailsWrapper("levelId 不能为空");
        }
        String cacheKey = new StringBuilder().append((String) form.getLevelId()).append(form.getRootId()).append(form.getLevelNum()).append(form.isIncSelf()).append(form.getIncludeRoot()).append(form.isUp()).append(form.isLevelNumOnly()).toString();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("区域树cacheKey:{}",cacheKey);
        }
        //从缓存中取值
        if (areaListCache.containsKey(cacheKey)) {
            return CommonResult.returnSuccessWrapper(areaListCache.get(cacheKey));
        }
        final List<TreeNode> areaList = areaService.queryAreaTreeNode(form);
        //加入缓存
        areaListCache.put(cacheKey, areaList);

        return CommonResult.returnSuccessWrapper(areaListCache.get(areaList));
    }

    private CommonResult<Map<String, List<TreeNode>>> validateParams(BaseLevelTreeQuery form) {
        if (form.getLevelNum() > 4 || form.getLevelNum() < 1) {
            return CommonResult.returnFailsWrapper("层级超过范围1-4");
        }
        if (StringUtils.isBlank((String) form.getLevelId())) {
            return CommonResult.returnFailsWrapper("levelId 不能为空");
        }
        return null;
    }

    @Override
    public CommonResult<Map<String, List<TreeNode>>> queryAreaAndOrgTree(BaseLevelTreeQuery form) {
        CommonResult<Map<String, List<TreeNode>>> validateResult = validateParams(form);
        if (validateResult != null){
            return validateResult;
        }
        String cacheKey = new StringBuilder().append((String) form.getLevelId()).append(form.getRootId()).append(form.getLevelNum()).append(form.isIncSelf()).append(form.getIncludeRoot()).append(form.isUp()).append(form.isLevelNumOnly()).toString();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("区域树cacheKey:{}",cacheKey);
        }
        List<TreeNode> areaList;

        //从缓存中取值
        if (areaListCache.containsKey(cacheKey)) {
            areaList = areaListCache.get(cacheKey);
        }else {
            areaList = areaService.queryAreaTreeNode(form);
            //加入缓存
            areaListCache.put(cacheKey, areaList);
        }

        OrganizationForm orgForm = new OrganizationForm();
        List<TreeNode> orgList = organizationService.queryOrgTreeNode(orgForm);
        this.orgList = orgList;

        //新包装Tree的返回值
        List<TreeNode> resultTree = new ArrayList<>();
        //新包装Array的返回值
        List<TreeNode> resultList = new ArrayList<>();

        TreeNode treeNode = new TreeNode();
        treeNode.setKey(AREA_ID_PREFIX + "-1");
        treeNode.setTitle("全部");
        treeNode.setChildren(getChilds(form.getRootId(), depCopy(areaList), true));

        resultTree.add(treeNode);

        //不包含root节点
        if (!form.getIncludeRoot()) {
            resultTree =treeNode.getChildren();
        }

        resultList.addAll(areaList);
        resultList.addAll(orgList);

        final Map<String, List<TreeNode>> map = new HashMap<>();
        map.put("resultTree", resultTree);
//        map.put("resultList", resultList);

        return CommonResult.returnSuccessWrapper(map);
    }

    @Override
    public CommonResult<Area> getParentAreaZxOrg(AreaForm.Search form) {
        List<Area> data = areaService.queryAreaOrgList(form);
        if (data.size() == 1) {
            return CommonResult.returnSuccessWrapper(data.get(0));
        }
        return CommonResult.returnFailsWrapper("无效的查询条件");
    }

    /**
     * 区域树递归
     * @param pId 父ID
     * @param list
     * @param appendOrg  是否追加组织
     * @return
     */
    private List<TreeNode> getChilds(String pId, List<TreeNode> list, boolean appendOrg) {
        List<TreeNode> result = new ArrayList<>();

        final Iterator<TreeNode> iterator = list.iterator();
        while (iterator.hasNext()) {
            final TreeNode treeNode = iterator.next();
            //如果是子节点
            if (treeNode.isLeaf()) {
                continue;
            }
            //id
            final String key = AREA_ID_PREFIX + treeNode.getKey();
            if (StringUtils.isBlank(pId)) {
                if (StringUtils.isBlank(treeNode.getParentId())) {

                    List<TreeNode> orgChildren = new ArrayList<>();
                    if (appendOrg){
                        //如果有叶子节点机构 默认加入用户
                        if (treeNode.getChildren() == null) {
                            orgChildren.addAll(getOrgTree(treeNode.getKey()));
                        }
                    }
                    orgChildren.addAll(getChilds(treeNode.getKey(), list, appendOrg));
                    treeNode.setChildren(orgChildren);
                    if (appendOrg) {
                        treeNode.setSelectable(false);
                        treeNode.setDisabled(true);
                        if (!treeNode.getKey().contains(AREA_ID_PREFIX)){
                            treeNode.setKey(key);
                            treeNode.setValue(key);
                        }else {
                            treeNode.setValue(treeNode.getKey());
                        }
                    }
                    result.add(treeNode);
                }
            } else if (treeNode.getParentId() != null && pId.equals(treeNode.getParentId())) {
                List<TreeNode> orgChildren = new ArrayList<>();
                if (appendOrg){
                    //如果有叶子节点机构 默认加入用户
                    if (treeNode.getChildren() == null) {
                        orgChildren.addAll(getOrgTree(treeNode.getKey()));
                    }
                }
                orgChildren.addAll(getChilds(treeNode.getKey(), list, appendOrg));
                treeNode.setChildren(orgChildren);
                if (appendOrg) {
                    treeNode.setSelectable(false);
                    treeNode.setDisabled(true);
                    if (!treeNode.getKey().startsWith(AREA_ID_PREFIX)){
                        treeNode.setKey(key);
                        treeNode.setValue(key);
                    }else {
                        treeNode.setValue(treeNode.getKey());
                    }
                }
                result.add(treeNode);
            }
        }
        return result;
    }

    /**
     * 获取匹配的组织List
     * @param key
     * @return
     */
    private Collection<? extends TreeNode> getOrgTree(String key) {
        final List<TreeNode> list = getOrgList().stream().filter(e -> e.getParentId() != null && e.getParentId().equals(key)).collect(Collectors.toList());
//        final Iterator<TreeNode> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            final TreeNode next = iterator.next();
////            next.setKey(ORG_ID_PREFIX+ next.getKey());
//        }
        return list;
    }

    private Collection<? extends TreeNode> getUserTree(String key) {
        return getUserTreeList().stream().filter(e -> e.getParentId() != null && e.getParentId().equals(key)).collect(Collectors.toList());
    }

    public List<TreeNode> getUserTreeList() {
        return userTreeList;
    }

    public List<TreeNode> getOrgList() {
        return orgList;
    }




    /***
     * 方法一对集合进行深拷贝 注意需要对泛型类进行序列化(实现Serializable)
     *
     * @param srcList
     * @param <T>
     * @return
     */
    public static <T> List<T> depCopy(List<T> srcList) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try {
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(srcList);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream inStream = new ObjectInputStream(byteIn);
            List<T> destList = (List<T>) inStream.readObject();
            return destList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
