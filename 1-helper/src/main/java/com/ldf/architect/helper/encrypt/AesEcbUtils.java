package com.ldf.architect.helper.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class AesEcbUtils {

	public static final String sKey = "Peo#^psofttr2018";

	/***
	 * 加密
 	 */
	public static String encrypt(String sSrc, String sKey) throws Exception {
		if (sKey == null) {
			return "Key为空null";
		}
		// 判断Key是否为16位
		if (sKey.length() != 16) {
			return "Key长度不是16位";
		}
		byte[] raw = sKey.getBytes("utf-8");
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		// "算法/模式/补码方式"
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
		// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
		return new BASE64Encoder().encode(encrypted);
	}

	/***
	 * 解密
	 */
	public static String decrypt(String sSrc, String sKey){
		try {
			// 判断Key是否正确
			if (sKey == null) {
				System.out.print("Key为空null");
				return null;
			}
			// 判断Key是否为16位
			if (sKey.length() != 16) {
				System.out.print("Key长度不是16位");
				return null;
			}
			byte[] raw = sKey.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			// 先用base64解密
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original, "utf-8");
				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		/*
		 * 此处使用AES-128-ECB加密模式，key需要为16位。
		 */
		String cKey = "Peo#^psofttr2018";
		// 需要加密的字串
		String cSrc = "310214199310010124";
		// 加密
		String enString = encrypt(cSrc, cKey);
		System.out.println("加密后的字串是：" + enString);

		// 解密
		String decrypt = decrypt(enString, cKey);

		System.out.println("解密后的字串是：" + decrypt);
		assert cSrc.equals(decrypt);
	}
}
