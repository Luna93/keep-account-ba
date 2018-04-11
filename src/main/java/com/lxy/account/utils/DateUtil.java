package com.lxy.account.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final String YYYYMMDD = "yyyyMMdd";
	
	public static final String YYYY = "yyyy";
	
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	/**
	 * date日期是星期几
	 *
	 * @param date
	 * @return
	 */
	public static String getDayWeek(String dateString) {
		Date date = parseDate(dateString);
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}
	
	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static Date parseDate(String date) {
		return parse(date,"yyyy-MM-dd");
	}
	
	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static Date parse(String date, String pattern) {
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(date);
	}
	
	public static String formatDate(Date date) {
		return formatDate(date, YYYY_MM_DD_HH_MM_SS);
	}

	public static void main(String[] args) {
		System.out.println(getDayWeek("2018-04-30"));
		System.out.println("2018-04-01".substring("2018-04-30".length()-2));
		System.out.println(formatDate(new Date()));
	}

}
