package com.redare.shop.unifyworkbench.service.util;

import org.apache.commons.lang3.StringUtils;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 思源财务共享密码加密方法
 * @Author yj
 * @Date 2020/6/11 10:52
 */
public class CwgxEncrypt {

    public static String encryptECB(String message, String descKey) throws Exception {
        if(StringUtils.isEmpty(descKey)){
            throw  new Exception("秘钥不能为空");
        }
        String key = descKey;
        if(descKey.length() > 8){
            key = descKey.substring(0,8);
        }
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        //IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] data = cipher.doFinal(message.getBytes("UTF-8"));
        return toECBString(data);
    }

    public  static  String  toECBString(byte  b[])  {
        StringBuffer  hexString  =  new  StringBuffer();
        for  (int  i  =  0;  i  <  b.length;  i++)  {
            int  d  =  (0xff  &  b[i]);
            hexString.append(d).append("_");
        }
        hexString.deleteCharAt(hexString.length()-1);

        return  hexString.toString();
    }

    public static void main(String[] args) {
        String key="sask123dfj@2383*ifKJ";
        String pwd="A123456&";
        try {
            System.out.println("------------------------");
            System.out.println(encryptECB(pwd,key));
            System.out.println("------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //对应c#的方法
//    public static string Encrypt(this string Text, string sKey)
//    {
//        DESCryptoServiceProvider des = new DESCryptoServiceProvider();
//        byte[] inputByteArray;
//        inputByteArray = Encoding.Default.GetBytes(Text);
//        des.Key = ASCIIEncoding.ASCII.GetBytes(System.Web.Security.FormsAuthentication.HashPasswordForStoringInConfigFile(sKey, "md5").Substring(0, 8));
//        des.IV = ASCIIEncoding.ASCII.GetBytes(System.Web.Security.FormsAuthentication.HashPasswordForStoringInConfigFile(sKey, "md5").Substring(0, 8));
//        System.IO.MemoryStream ms = new System.IO.MemoryStream();
//        CryptoStream cs = new CryptoStream(ms, des.CreateEncryptor(), CryptoStreamMode.Write);
//        cs.Write(inputByteArray, 0, inputByteArray.Length);
//        cs.FlushFinalBlock();
//        StringBuilder ret = new StringBuilder();
//        foreach (byte b in ms.ToArray())
//        {
//            ret.AppendFormat("{0:X2}", b);
//        }
//        return ret.ToString();
//    }
}
