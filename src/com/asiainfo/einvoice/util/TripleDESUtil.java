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
 * DES�����㷨
 */
public class TripleDESUtil {
	
	private static transient Log log = LogFactory.getLog(TripleDESUtil.class);
	
	private static final String Algorithm = "DESede"; //���� �����㷨,���� DES,DESede,Blowfish    
	/**
	 * �����㷨
	 * passwordΪ������Կ������Ϊ24�ֽ�
	 * srcΪ�����ܵ����ݻ�������Դ��
	 */
	public static byte[] encryptMode(byte[] password, byte[] src) {
		try {
			// ������Կ
			SecretKey deskey = new SecretKeySpec(password, Algorithm);
			// ����
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
	 * �����㷨 keybyteΪ������Կ������Ϊ24�ֽ� 
	 * srcΪ�����ܵ����ݻ�������Դ��
	 */
	public static byte[] decryptMode(byte[] password, byte[] src) {
		try {
			// ������Կ
			SecretKey deskey = new SecretKeySpec(password, Algorithm);
			// ����
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

	// ת����ʮ�������ַ���
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
     * ���ݼ��ܣ��㷨��DES��
     * @param data Ҫ���ܵ��ַ���
     * @param PASSWORD DES�㷨��Կ
     * by quanly
     * @return ���ܴ�
     */
    public static String encryptBasedDes(String data, String PASSWORD) {
        String encryptedData = null;
        try {
            // DES�㷨Ҫ����һ�������ε������Դ
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(PASSWORD.getBytes());
            // ����һ���ܳ׹�����Ȼ��������DESKeySpecת����һ��SecretKey����
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // ���ܶ���
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            // ���ܣ������ֽ����������ַ���
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("���ܴ��󣬴�����Ϣ��", e);
        }
        return encryptedData;
    }
    
    /**
     * ���ݽ��ܣ��㷨��DES�� 
     * @param cryptData Ҫ���ܵ��ַ���
     * @pram PASSWORD DES�㷨��Կ
     * by quanly
     * @return ���ܴ�
     */
    public static String decryptBasedDes(String cryptData, String PASSWORD) {
        String decryptedData = null;
        try {
            // DES�㷨Ҫ����һ�������ε������Դ
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(PASSWORD.getBytes());
            // ����һ���ܳ׹�����Ȼ��������DESKeySpecת����һ��SecretKey����
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // ���ܶ��� 
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
            // ���ַ�������Ϊ�ֽ����飬������
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
        } catch (Exception e) {
            throw new RuntimeException("���ܴ��󣬴�����Ϣ��", e);
        }
        return decryptedData;
    }
}
