package com.asiainfo.einvoice.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * DES加密算法
 */
public class TripleDESUtil {
	
	private static transient Log log = LogFactory.getLog(TripleDESUtil.class);
	
	private static final String Algorithm = "DESede"; //定义 加密算法,可用 DES,DESede,Blowfish    
	/**
	 * 加密算法
	 * password为加密密钥，长度为24字节
	 * src为被加密的数据缓冲区（源）
	 */
	public static byte[] encryptMode(byte[] password, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(password, Algorithm);
			// 加密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.ENCRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			log.error(e1.getMessage());
		} catch (javax.crypto.NoSuchPaddingException e2) {
			log.error(e2.getMessage());
		} catch (Exception e3) {
			log.error(e3.getMessage());
		}
		return null;
	}
	
	/**
	 * 解密算法 keybyte为加密密钥，长度为24字节 
	 * src为被加密的数据缓冲区（源）
	 */
	public static byte[] decryptMode(byte[] password, byte[] src) {
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(password, Algorithm);
			// 解密
			Cipher c1 = Cipher.getInstance(Algorithm);
			c1.init(Cipher.DECRYPT_MODE, deskey);
			return c1.doFinal(src);
		} catch (java.security.NoSuchAlgorithmException e1) {
			log.error(e1.getMessage());
		} catch (javax.crypto.NoSuchPaddingException e2) {
			log.error(e2.getMessage());
		} catch (Exception e3) {
			log.error(e3.getMessage());
		}
		return null;
	}

	// 转换成十六进制字符串
	public static String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer("");
		String stmp = "";

		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
			if (n < b.length - 1)
				hs.append(":");
		}
		return hs.toString().toUpperCase();
	}
	
	/**
     * 数据加密，算法（DES）
     * @param data 要加密的字符串
     * @param PASSWORD DES算法密钥
     * by quanly
     * @return 加密串
     */
    public static String encryptBasedDes(String data, String PASSWORD) {
        String encryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(PASSWORD.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 加密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            // 加密，并把字节数组编码成字符串
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("加密错误，错误信息：", e);
        }
        return encryptedData;
    }
    
    /**
     * 数据解密，算法（DES） 
     * @param cryptData 要解密的字符串
     * @pram PASSWORD DES算法密钥
     * by quanly
     * @return 解密串
     */
    public static String decryptBasedDes(String cryptData, String PASSWORD) {
        String decryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(PASSWORD.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 解密对象 
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
            // 把字符串解码为字节数组，并解密
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
        } catch (Exception e) {
            throw new RuntimeException("解密错误，错误信息：", e);
        }
        return decryptedData;
    }
}
