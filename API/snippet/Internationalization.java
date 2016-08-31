package com.leo.api.snippet;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化
 * @author leo
 *
 */
public class Internationalization {
	
	/**
	 * 根据传入的语言标记载入相应的语言包，
	 * 主要为了熟悉 ResourceBundle 类的使用。
	 * @param langName
	 */
	@SuppressWarnings("unused")
	private void loadLangPack(String langName) {
		// 资源包基名(包名+lang)
        String basename = "language.lang";
        Locale locale = null;
        ResourceBundle bsb = null;
		if("CN".equals(langName)) {
			locale = Locale.CHINA; // 设置语言环境
			// 根据基名和语言环境加载对应的语言资源文件
			bsb = ResourceBundle.getBundle(basename, locale);
			String value = bsb.getString("key");
		}else if("EN".equals(langName)){
			locale = Locale.US;
			bsb = ResourceBundle.getBundle(basename, locale);
			String value = bsb.getString("key");
		}
	}
}
