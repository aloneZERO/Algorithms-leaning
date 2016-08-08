package com.leo.api;

/**
 * 字符串工具类
 * 
 * Update 2016-8-7
 * @author leo
 *
 */
public class StringUtils {
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(StringUtils.isPalindrome("abbbc"));
		System.out.println(StringUtils.isPalindrome("abcba"));
	}
	
	/**
	 * 构造方法私有化
	 */
	private StringUtils() {
		// do nothing...
	}
	
	/**
	 * 判断两个字符串是否互为回环变位
	 * 
	 * 测试结果：
	 *  isLoopModification("CCABC", "CCEAB") false
	 *  isLoopModification("CCABC", "CCCAB") true
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isLoopModification(String s, String t) {
		return (s.length()==t.length())&&((t+t).contains(s));
	}
	
	/**
	 * 判断字符串是否是回文串
	 * 
	 * 测试结果：
	 *  isPalindrome("abbbc") false
	 *  isPalindrome("abcba") true
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		int N = s.length();
		for(int i=0; i< N/2; i++) {
			if(s.charAt(i) != s.charAt(N-1-i))
				return false;
		}
		return true;
	}
	
	/**
	 * 判断字符串是否为空
	 * 注意：忽略空格
	 * 
	 * 测试结果：
	 *  isEmpty("") true
	 *  isEmpty(null) true
	 *  isEmpty("  ") true
	 *  isEmpty("null") false
	 *  isEmpty("string") false
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return (s==null||"".equals(s.trim()));
	}
	/**
	 * 判断是否不为空
	 * 注意：忽略空格
	 * @param s
	 * @return
	 */
	public static boolean isNotEmpty(String s) {
		return (s!=null&&!"".equals(s.trim()));
	}
}
