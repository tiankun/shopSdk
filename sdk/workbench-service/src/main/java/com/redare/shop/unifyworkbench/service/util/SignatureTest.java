package com.redare.shop.unifyworkbench.service.util;

import com.redare.devframework.common.utils.ObjectId;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author yj
 * @Date 2020/6/11 17:08
 */
public class SignatureTest {
    public static void main(String[] args) {
        //String urlKey="1FFBC5BC193086D0F32B02C23272BC33";//urlKey
        String urlKey="abc";//urlKey
        String timestamp=String.valueOf(new Date().getTime());//距离1970年的时间戳
        String nonce=new ObjectId().toString(); //随机数
        List<String> tmpList = new ArrayList<>(); //三个参数加入list中
        tmpList.add(urlKey);
        tmpList.add(timestamp);
        tmpList.add(nonce);
        Collections.sort(tmpList);  //三个参数按照字典排序
        //待签名字符串
        String tmpStr = StringUtils.join(tmpList.toArray()); //排序后list的三个参数join成字符串
        String signature="";
        try {
            //以SHA1的算法对tmpStr(代签名字符串)进行签名，得到签名(signature)
            signature= Hex.encodeHexString(
                    MessageDigest.getInstance("SHA-1")
                            .digest(tmpStr.getBytes("UTF-8"))
            );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /**此时得到三个参数
         * timestamp 距离1970年的时间戳
         * nonce 随机数
         * signature 签名
         **/
        System.out.println("_timestamp="+timestamp);
        System.out.println("_nonce="+nonce);
        System.out.println("_signature="+signature);
        String url=String.format("?_timestamp=%s&_nonce=%s&_signature=%s",timestamp,nonce,signature);
        System.out.println(url);
        //将这三个参数通过url参数的方式传入
        //url?_timestamp=xxx&_nonce=xxx&_signature=xxx
    }

    public static String getSignature(){
        String urlKey="abc";//urlKey
        String timestamp=String.valueOf(new Date().getTime());//距离1970年的时间戳
        String nonce=new ObjectId().toString(); //随机数
        List<String> tmpList = new ArrayList<>(); //三个参数加入list中
        tmpList.add(urlKey);
        tmpList.add(timestamp);
        tmpList.add(nonce);
        Collections.sort(tmpList);  //三个参数按照字典排序
        //待签名字符串
        String tmpStr = StringUtils.join(tmpList.toArray()); //排序后list的三个参数join成字符串
        String signature="";
        try {
            //以SHA1的算法对tmpStr(代签名字符串)进行签名，得到签名(signature)
            signature= Hex.encodeHexString(
                    MessageDigest.getInstance("SHA-1")
                            .digest(tmpStr.getBytes("UTF-8"))
            );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /**此时得到三个参数
         * timestamp 距离1970年的时间戳
         * nonce 随机数
         * signature 签名
         **/
        String url=String.format("?_timestamp=%s&_nonce=%s&_signature=%s",timestamp,nonce,signature);
        System.out.println(url);
        return url;
    }
}
