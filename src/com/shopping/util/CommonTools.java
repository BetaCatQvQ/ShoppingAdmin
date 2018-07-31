package com.shopping.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonTools {
	public static Date getDateFromString(String str,String formatType) {
		if (str == null || str.equals("")  || formatType == null || formatType.equals("")) {
			return null;
		}
		System.out.println(str);
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		String dateTest = sdf.format(date);
		System.out.println(dateTest);
		return date;
	}
}
