package com.redare.shop.unifyworkbench.service.util;

import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * UUID工具类
 * @Author: guangrongyang
 * @Date: 2020/10/13 15:44
 */

public class UUIDutils {

    /**
     * 返回32位长度的UUID
     * UUID转成32位长度的MD5消息摘要
     * @return
     */
    public static String md5UUID(){
        return DigestUtils.md5DigestAsHex(UUID.randomUUID().toString().getBytes());
    }

    /**
     * 返回32位长度的UUID
     * @return
     */
    public static String get32UUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    public static void main(String[] args) throws InterruptedException {
        while (true){
            final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//            if (uuid.length() != 32){
                System.out.println(uuid);
//            }
        }

    }
}
