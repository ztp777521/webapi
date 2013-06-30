package org.webapi.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类
 * 
 * @author liu
 * 
 */
public class DateUtil {

	private static final String G_REGEX = "yyyy-MM-dd";

	public static Date convertToLoacl(Date date) throws ParseException {
		DateFormat d = getDateFormat();
		return d.parse(getDateFormat().format(date));
	}

	public static DateFormat getDateFormat() {
		return new SimpleDateFormat(G_REGEX);
	}

	public static String toLocal(Date date) {
		return getDateFormat().format(date);
	}

	public static Date addYear(Date date, int year) {
		Calendar l_calender = getCalendar();
		l_calender.setTime(date);
		l_calender.set(Calendar.YEAR, l_calender.get(Calendar.YEAR) + year);
		return l_calender.getTime();
	}

	public static Date diffMin(Date date, int min) {
		Calendar l_calender = getCalendar();
		l_calender.setTime(date);
		l_calender.set(Calendar.MINUTE, l_calender.get(Calendar.MINUTE) - min);
		return l_calender.getTime();
	}

	public static Calendar getCalendar() {
		Calendar calender = new GregorianCalendar();
		return calender;
	}

	public static String fomartString(String tags) {
		if (tags != null) {
			tags = tags.replaceAll(" ", "");
			tags = tags.replaceAll("，", ",").trim();
			if (!tags.startsWith(",")) {
				tags = "," + tags;
			}
			if (!tags.endsWith(",")) {
				tags = tags + ",";
			}
		}
		return tags;
	}

	public static String setHTTP(String url) {
		if (url != null
				&& !"".equals(url)
				&& (!url.toLowerCase().startsWith("http://") && !url
						.toLowerCase().startsWith("https://"))) {
			url = "http://" + url;
		}
		return url;
	}

	public static void main(String[] args) throws Exception {

		// System.out.println(DateUtil.addYear(
		// new Date(System.currentTimeMillis()), 2));
		System.out.println(DateUtil.setHTTP(""));
		// System.out.println(DateUtil.fomartString("地板"));
	}

}
