package com.gome.sermanage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	/**
	 * 描述：日期转化为字符串
	 * @param format
	 * @return
	 */
	public static String dateToString(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(new Date());
		return str;
	}
}
