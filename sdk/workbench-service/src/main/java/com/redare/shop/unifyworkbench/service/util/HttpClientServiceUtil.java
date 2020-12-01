package com.redare.shop.unifyworkbench.service.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpClientServiceUtil
 *
 * @Author zlx
 * @Date 2020/5/20 14:08
 */
public class HttpClientServiceUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientServiceUtil.class);

    private static final String CONTENTTYPE = "application/x-www-form-urlencoded";
    /**
     * 返回成功状态码
     */
    private static final int SUCCESS_CODE = 200;

    /**
     *
     * @author zlx
     * @date 2020/5/20 14:57
     * @param url 请求地址
     * @param param 请求参数 json格式
     * @param contentType 消息头类型
     * @param nameValuePairList form表单请求参数
     * @return java.lang.Object
     */
    public static Map<String, Object> sendPost(String url, String param, String contentType, List<NameValuePair> nameValuePairList){
        JSONObject jsonObject = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            if (CONTENTTYPE.equals(contentType)){
                StringEntity entity = new UrlEncodedFormEntity(nameValuePairList, "UTF-8");
                post.setEntity(entity);
                post.setHeader(new BasicHeader("Content-Type",
                        "application/x-www-form-urlencoded; charset=utf-8"));
                post.setHeader(new BasicHeader("Accept",
                        "text/plain;charset=utf-8"));
            }else {
                StringEntity entity = new StringEntity(param, "UTF-8");
                post.setEntity(entity);
                post.setHeader(new BasicHeader("Content-Type", "application/json; charset=utf-8"));
                post.setHeader(new BasicHeader("Accept", "application/json;charset=utf-8"));
            }
            response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            if (SUCCESS_CODE == statusCode){
                String result = EntityUtils.toString(response.getEntity(),"UTF-8");
                jsonObject = JSONObject.parseObject(result);
                return (Map<String, Object>) jsonObject;
            }else {
                LOGGER.error("HttpClientService-line: {}, errorMsg：{}", 146, "POST请求失败！");
            }
        }catch (Exception e){
            LOGGER.error("HttpClientService-line: {}, Exception：{}", 149, e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * form表单提交组装参数
     * @author zlx
     * @date 2020/5/20 14:56
     * @param params
     * @param values
     * @return java.util.List<org.apache.http.NameValuePair>
     */
    public static List<NameValuePair> getParams(Object[] params, Object[] values) {
        boolean flag = params.length > 0 && values.length > 0 && params.length == values.length;
        if (flag) {
            List<NameValuePair> nameValuePairList = new ArrayList<>();
            for (int i = 0; i < params.length; i++) {
                nameValuePairList.add(new BasicNameValuePair(params[i].toString(), values[i].toString()));
            }
            return nameValuePairList;
        } else {
            LOGGER.error("HttpClientService-line: {}, errorMsg：{}", 197,"请求参数为空且参数长度不一致");
        }
        return null;
    }
}
