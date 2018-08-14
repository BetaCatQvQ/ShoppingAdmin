package com.shopping.util;

import java.io.File;
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
	
	public static boolean ArrayDetectNull(Object[] array) {
		for (Object obj : array) {
			if (obj == null) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
