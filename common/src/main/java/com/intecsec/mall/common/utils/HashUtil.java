package com.intecsec.mall.common.utils;

import com.google.common.hash.Hashing;

/**
 * @author Peter.Peng
 * @date 2021/4/28
 */
public class HashUtil {

	/*
	public static String md5(String str) {
		Hasher hasher = Hashing.md5().newHasher();
		String md5String = hasher.putString(str, Charsets.UTF_8).hash().toString();
		return md5String;
	}
	*/

	public static String md5(String str) {
		return Hashing.md5().hashBytes(str.getBytes()).toString();
	}

	public static String sha256(String str) {
		return Hashing.sha256().hashBytes(str.getBytes()).toString();
	}

	public static String sha512(String str) {
		return Hashing.sha512().hashBytes(str.getBytes()).toString();
	}

	public static String crc32(String str) {
		return Hashing.crc32().hashBytes(str.getBytes()).toString();
	}

	public static void main(String[] args) {
		System.out.println(md5("abc"));
		System.out.println(sha256("abc"));
		System.out.println(sha512("abc"));
		System.out.println(crc32("abc"));
	}
}
