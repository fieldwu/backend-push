package com.basic.backend.push.support.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期常用方法类
 * 
 * @author Field
 */
public class DateUtils {

	private static Logger LOG = LoggerFactory.getLogger(DateUtils.class);

	public static final String globalTimeFormater = "yyyyMMdd HH:mm:ss";

	public static Date parseGlobalTime(String globalTime) {
		if (StringUtils.isEmpty(globalTime)) {
			return null;
		}
		try {
			return (new SimpleDateFormat(globalTimeFormater)).parse(globalTime);
		} catch (ParseException e) {
			LOG.info("globalTime_error:" + globalTime);
			return null;
		}
	}

	public static String parseGlobalTime(Date globalTime) {
		if (null == globalTime) {
			return "";
		}
		SimpleDateFormat fullDate = new SimpleDateFormat(globalTimeFormater);
		return fullDate.format(globalTime);
	}

	/**
	 * String(yyyy-MM-dd) -> Date
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static Date parse10Date(String strDate) {
		if (StringUtils.isBlank(strDate)) {
			return null;
		}

		try {
			return (new SimpleDateFormat("yyyy-MM-dd")).parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + strDate + "解析为 " + "yyyy-MM-dd" + "格式的日期时发生异常:", e);
		}
	}

	public static Date parseFullCompactDate(String date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		try {
			return (new SimpleDateFormat("yyyyMMddHHmmssSSS")).parse(date);
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + date + "解析为 yyyy-MM-dd HH:mm:ss" + "格式的日期时发生异常:", e);
		}
	}

	/**
	 * String(yyyy-MM-dd HH:mm:ss) -> Date
	 * 
	 * @param dateTime 时间字符串(yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static Date parseFullDateTime(String dateTime) {
		if (StringUtils.isEmpty(dateTime)) {
			return null;
		}

		try {
			return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(dateTime);
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + dateTime + "解析为 yyyy-MM-dd HH:mm:ss" + "格式的日期时发生异常:", e);
		}
	}

	/**
	 * String(yyyy/MM/dd HH:mm:ss) -> Date
	 * 
	 * @param dateTime 时间字符串(yyyy/MM/dd HH:mm:ss)
	 * @return
	 */
	public static Date parseFullDateTime2(String dateTime) {
		if (StringUtils.isEmpty(dateTime)) {
			return null;
		}

		try {
			return (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).parse(dateTime);
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + dateTime + "解析为 yyyy/MM/dd HH:mm:ss" + "格式的日期时发生异常:", e);
		}
	}

	/**
	 * Date -> String(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param date
	 * @return
	 */
	public static String formatFullDate(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat fullDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return fullDate.format(date);
	}

	/**
	 * Date -> String(yyyy/MM/dd HH:mm:ss)
	 * 
	 * @param date
	 * @return
	 */
	public static String formatFullDate2(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat fullDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return fullDate.format(date);
	}

	/**
	 * 把日期，时间转化为格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getDateTime() {
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
	}

	/**
	 * 取得当前日期字符串; 日期格式:yyyyMMdd
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		return (new SimpleDateFormat("yyyyMMdd")).format(new Date());
	}

	/**
	 * 取得日期字符串; 日期格式:yyyyMMdd
	 * 
	 * @return
	 */
	public static String get8Date(Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	}

	/**
	 * 取得日期字符串; 日期格式:yyyyMMdd
	 *
	 * @return
	 */
	public static String get8DatePoint(Date date) {
		return (new SimpleDateFormat("yyyy.MM.dd")).format(date);
	}

	/**
	 * 取得日期字符串; 日期格式:yyyyMMdd
	 * 
	 * @return
	 */
	public static String get10Date(Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	}

	/**
	 * 取得日期字符串; 日期格式:yyyyMMdd
	 * 
	 * @return
	 */
	public static String get8Time(Date date) {
		return (new SimpleDateFormat("HH:mm:ss")).format(date);
	}

	/**
	 * 取得当前日期字符串; 日期格式:yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getCurrentPageDate() {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
	}

	/**
	 * 取得当前日期字符串; 日期格式:yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getCurrentPageDate(Date date) {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	}

	/**
	 * Date -->> yyyy年MM月dd HH:mm:ss
	 * 
	 * @param date
	 */
	public static String formatLocalDate(Date date) {
		return (new SimpleDateFormat("yyyy年MM月dd HH:mm:ss")).format(date);
	}

	/**
	 * Date -->> yyyy-MM-dd HH:mm:ss:SSS
	 * 
	 * @param date
	 */
	public static String formatFullCompactDate(Date date) {
		return (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(date);
	}

	public static String getCompactCurrentTime() {
		return (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
	}

	public static Date getCompactCurrentTime(String strDate) {
		if (strDate == null) {
			return null;
		}

		try {
			return (new SimpleDateFormat("yyyyMMddHHmmss")).parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + strDate + "解析为 " + "yyyy-MM-dd" + "格式的日期时发生异常:", e);
		}
	}

	/**
	 * HH:mm:ss ->> HHmmss
	 * 
	 * @param pageTime
	 * @return
	 */
	public static String pageTimeToDbTime(String pageTime) {
		return pageTime.replaceAll(":", "");
	}

	/**
	 * 将日期转换为指定格式
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formateDate2Str(Date date, String pattern) {
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		return s.format(date);
	}

	/**
	 * @Title formateStr2Date
	 * @Description 指定格式字符串转换为日期
	 * @author liguopeng
	 * @param data
	 * @param pattern
	 * @return
	 */
	public static Date formateStr2Date(String data, String pattern) {
		SimpleDateFormat s = new SimpleDateFormat(pattern);
		try {
			return s.parse(data);
		} catch (Exception e) {
			throw new RuntimeException("时间转换失败，字符串:" + data + "，格式" + pattern, e);
		}
	}

	/**
	 * 将日期中的2007-1-1转化为20070101格式
	 * 
	 * @param datestr
	 * @return
	 */
	public static String dateStringFormat(String datestr) {
		if (datestr == null || datestr.equals(""))
			return null;
		String[] str1 = datestr.split("-");
		if (str1.length == 3) {
			if (str1[1].length() == 1) {
				str1[1] = "0" + str1[1];
			}
			if (str1[2].length() == 1) {
				str1[2] = "0" + str1[2];
			}
		} else
			return datestr;
		datestr = str1[0] + str1[1] + str1[2];
		return datestr;
	}

	public static Date addDay(Date oriDate, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(oriDate);
		cal.add(Calendar.DAY_OF_MONTH, amount);
		return cal.getTime();
	}

	/**
	 * 取得指定格式的当前时间
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getTime(String pattern) {
		return new SimpleDateFormat(pattern).format(new Date());
	}

	/**
	 * 取得指定时间的偏移时间
	 * 
	 * @param transferTime 原始时间（yyyy-MM-dd HH:ss:mm）
	 * @param calendarType 偏移单位（Calendar的常量）
	 * @param i            偏移量
	 * @return
	 */
	public static String getExcursionTime(String transferTime, int calendarType, int i) {
		Date parseFullDateTime = parseFullDateTime(transferTime);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(parseFullDateTime);
		calendar.add(calendarType, i);
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar.getTime());
	}

	/**
	 * 取得当前时间的偏移时间
	 * 
	 * @param              calendarType（yyyy-MM-dd HH:ss:mm）
	 * @param calendarType 偏移单位（Calendar的常量）
	 * @param i            偏移量
	 * @return
	 */
	public static String getExcursionTime(int calendarType, int i) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(calendarType, i);
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(calendar.getTime());
	}

	/**
	 * 取得指定时间的偏移时间
	 * 
	 * @param calendarType 偏移单位（Calendar的常量）
	 * @param i            偏移量
	 * @param 日期格式
	 * @return
	 */
	public static String getExcursionTime(String transferTime, int calendarType, int i, String pattern) {
		try {
			SimpleDateFormat f = new SimpleDateFormat(pattern);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(f.parse(transferTime));
			calendar.add(calendarType, i);
			return new SimpleDateFormat(pattern).format(calendar.getTime());
		} catch (Exception e) {
			throw new RuntimeException("将字符串" + transferTime + "按照 " + pattern + "格式进行转换和计算时发生异常:", e);
		}
	}

	/**
	 * 取得指定时间的偏移时间
	 * 
	 * @param calendarType 偏移单位（Calendar的常量）
	 * @param i            偏移量
	 * @param 日期格式
	 * @return
	 */
	public static String getExcursionTime(int calendarType, int i, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(calendarType, i);
		return new SimpleDateFormat(pattern).format(calendar.getTime());
	}

	/**
	 * 取得当前时间的偏移时间 格式为（yyyyMMdd）+1为往后一天，-1为向前一天，0为当天
	 */
	public static String getAboutDate(int i) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_MONTH, i);
		String mDateTime = (new SimpleDateFormat("yyyyMMdd")).format(rightNow.getTime());
		return mDateTime;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss转换成毫秒数
	 * 
	 * @param new_date_f
	 * @return
	 */
	public static long conversion(String new_date_f) {
		try {
			long millisecond = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(new_date_f).getTime();
			return millisecond;
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + new_date_f + "按照 yyyy-MM-dd HH:mm:ss" + "格式进行转换毫秒时发生异常:", e);
		}
	}

	/**
	 * 当月第一天
	 * 
	 * @return
	 */
	public static String monthStart() {
		Calendar curCal = Calendar.getInstance();
		curCal.set(Calendar.DAY_OF_MONTH, 1);
		Date beginTime = curCal.getTime();
		String sTime = (new SimpleDateFormat("yyyy-MM-dd")).format(beginTime) + " 00:00:00";
		return sTime;
	}

	/**
	 * 当月最后一天
	 * 
	 * @return
	 */
	public static String monthEnd() {
		Calendar curCal = Calendar.getInstance();
		curCal.set(Calendar.DATE, 1);
		curCal.roll(Calendar.DATE, -1);
		Date endTime = curCal.getTime();
		String eTime = (new SimpleDateFormat("yyyy-MM-dd")).format(endTime) + " 23:59:59";
		return eTime;
	}

	/**
	 * 
	 * @param protoDate
	 * @param dayOffset
	 * @return
	 */
	public static Date getOffsetDate(Date protoDate, int dayOffset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(protoDate);
		cal.add(Calendar.DATE, -dayOffset);
		return cal.getTime();
	}

	/**
	 *
	 * @param date        YYYY-MM-DD
	 * @param monthOffset
	 * @return
	 */
	public static String getMonthDate(String date, int monthOffset) {
		Date beginDate = get8Date(date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.add(Calendar.MONTH, monthOffset);
		Date nextDate = cal.getTime();
		String next = get10Date(nextDate);
		return next;
	}

	/**
	 *
	 * @param date        YYYY-MM-DD
	 * @param monthOffset
	 * @return Date
	 */
	public static Date getMonthDate2Date(String date, int monthOffset) {
		Date beginDate = get8Date(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginDate);
		cal.add(Calendar.MONTH, monthOffset);
		Date nextDate = cal.getTime();
		return nextDate;
	}

	/**
	 * 取得日期字符串; 日期格式:yyyy-MM-dd
	 *
	 * @return
	 */
	public static Date get8Date(String date) {
		try {
			return (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				return (new SimpleDateFormat("yyyy-MM-dd")).parse("2016-10-25");
			} catch (Exception e1) {
				return null;
			}
		}
	}

	/**
	 * 
	 * @param protoDate
	 * @param dayOffset
	 * @return
	 */
	public static Date getAddsetHour(Date protoDate, int dayOffset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(protoDate);
		cal.add(Calendar.HOUR, dayOffset);
		return cal.getTime();
	}

	public static Date[] getBeginTimeAndEndTime(Date date) {
		return getBeginTimeAndEndTime(date, 1);
	}

	/**
	 * 从date的0时，到interval天后的0时
	 * 
	 * @param date
	 * @param interval
	 * @return
	 */
	public static Date[] getBeginTimeAndEndTime(Date date, int interval) {
		if (null == date) {
			date = new Date();
		}
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.set(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl.get(Calendar.DATE), 0, 0, 0);
		Date beginTime = cl.getTime();

		Calendar cl1 = Calendar.getInstance();
		cl1.setTime(date);
		cl1.add(Calendar.DATE, interval);
		cl1.set(cl1.get(Calendar.YEAR), cl1.get(Calendar.MONTH), cl1.get(Calendar.DATE), 0, 0, 0);
		Date endTime = cl1.getTime();
		Date[] dates = new Date[2];
		dates[0] = beginTime;
		dates[1] = endTime;
		return dates;
	}

	/**
	 * 
	 * 输入时间 2013-11-11 12:12:12 ;interval =5 返回2013-11-11 12:12:00:00 | 2013-11-11
	 * 17:00:00
	 * 
	 * @return
	 */
	public static Date[] getBeginHourAndEndHour(int type, int before, int interval) {
		Calendar cl = Calendar.getInstance();
		cl.add(type, before);
		cl.set(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH), cl.get(Calendar.DATE), cl.get(Calendar.HOUR_OF_DAY), 0,
				0);
		Date endTime = cl.getTime();

		Calendar cl1 = Calendar.getInstance();
		cl1.add(type, before - interval);
		cl1.set(cl1.get(Calendar.YEAR), cl1.get(Calendar.MONTH), cl1.get(Calendar.DATE), cl1.get(Calendar.HOUR_OF_DAY),
				0, 0);
		Date beginTime = cl1.getTime();

		Date[] dates = new Date[2];
		dates[1] = endTime;
		dates[0] = beginTime;
		return dates;
	}

	/**
	 * 返回指定两个时间间隔的分钟数，误差小于1分钟</br>
	 * 采用进位算法，如果不满1分钟以1分钟来计算.
	 * 
	 * @param startDate 开始时间
	 * @param endDate   结束时间
	 * @return
	 */
	public static int getIntervalMinutes(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return -1;
		}
		int minute = 1000 * 60;
		long im = endDate.getTime() - startDate.getTime();
		return (int) (im % minute == 0 ? im / minute : (im / minute + 1));
	}

	/***
	 * 比较是不是同一天
	 * 
	 * @param workDay
	 * @param currTime
	 * @return
	 */
	public static boolean compWorkAndCurrByDate(Date workDay, Date currTime) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(workDay);
		c2.setTime(currTime);
		if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
				&& c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 移动月份
	 * 
	 * @param date
	 * @param monthOffset
	 * @return
	 */
	public static Date getMonthOffsetDate(Date date, int monthOffset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, monthOffset);
		return cal.getTime();
	}

	/**
	 * 设置日期中的日
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date setDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}

	/**
	 * 
	 * <div/>输入2014-08-28 17:00:29 和 0 的到 2014-08-28 00:00:00 <div/>输入2014-08-28
	 * 17:00:29 和 1 的到 2014-08-29 00:00:00 <div/>输入2014-08-28 17:00:29 和 -1 的到
	 * 2014-08-27 00:00:00
	 * 
	 * @param curDate 时间
	 * @param offset  偏移日期
	 * @return
	 */
	public static Date getBeginTimeByOffsetDate(Date curDate, int offset) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(curDate);
		c1.add(Calendar.DATE, offset);
		c2.set(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DATE), 0, 0, 0);
		return c2.getTime();
	}

	/*
	 * 计算两个日期几件间隔的天数
	 */
	public static int daysBetween(String startDateStr, Date endDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = sdf.parse(startDateStr);
			endDate = sdf.parse(sdf.format(endDate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(endDate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/*
	 * 计算两个日期几件间隔的天数
	 */
	public static int daysBetween(String startDateStr, String startDateEnd) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = sdf.parse(startDateStr);
			Date endDate = sdf.parse(startDateEnd);

			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(endDate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(DateUtils.daysBetween("2014-10-09", new Date()));
	}

	/**
	 * @Title daysBetween
	 * @Description 计算两个时间相隔天数
	 * @author liguopeng
	 * @param smdate
	 * @param bdate
	 * @param pattern
	 * @return
	 */
	public static int daysBetween(String smdate, String bdate, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(smdate));
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + smdate + "解析为" + pattern + "格式的日期时发生异常:", e);
		}
		long time1 = cal.getTimeInMillis();
		try {
			cal.setTime(sdf.parse(bdate));
		} catch (ParseException e) {
			throw new RuntimeException("将字符串" + smdate + "解析为" + pattern + "格式的日期时发生异常:", e);
		}
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	public static Date dayEnd(Date date) {
		String endDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(date) + " 23:59:59";

		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static Date dayStart(Date date) {
		String endDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(date) + " 00:00:00";

		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;

	}
}