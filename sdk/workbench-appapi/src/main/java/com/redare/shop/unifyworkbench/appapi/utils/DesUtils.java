package com.redare.shop.unifyworkbench.appapi.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * 加密解密工具类
 * @Author yj
 * @email yangj@redare.cn
 * @Date 2020/7/5 14:50
 *
 **/
public class DesUtils {
	private static Key key;
	private static String KEY_STR = "@web_app_ztkt_key!_2020@redare.cn";
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY_STR.getBytes());
			generator.init(secureRandom);
			key = generator.generateKey();
			//generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对字符串进行加密，返回BASE64的加密字符串 <功能详细描述>
	 * 
	 * @param str
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String encode(String str) throws Exception{
		byte[] strBytes = str.getBytes("UTF-8");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptStrBytes = cipher.doFinal(strBytes);
		return Base64.encode(encryptStrBytes);
	}

	/**
	 * 对BASE64加密字符串进行解密 <功能详细描述>
	 * 
	 * @param str
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	public static String decode(String str) throws Exception{
		byte[] strBytes = Base64.decode(str);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] encryptStrBytes = cipher.doFinal(strBytes);
		return new String(encryptStrBytes, "UTF-8");
	}

	public static void main(String[] args) throws Exception{
		String name = "0";
		String encryname = encode(name);
		System.out.println(encryname);
		System.out.println(decode(encryname));

	}
}
