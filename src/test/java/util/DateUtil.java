package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * <p>日期操作工具</p>
 * @author 张刚学 
 * 2016年10月23日 下午9:44:46  
 */
public final class DateUtil {

	/** 
	 * 时间格式化模式  
	 */ 
	public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

	/** 
	 * <p>将"yyyy-MM-dd HH:mm:ss"格式的 时间字符串转化为日期类型</p>
	 * @param dateTime "yyyy-MM-dd HH:mm:ss"格式的时间
	 * @return Date:Date型日期
	 */
	public static Date convertStringDateAndTime(String dateTime) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = null;
		try {
			d = (Date) df.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	public static Date convertStringDateAndTime(String dateTime, String pattern) {
		DateFormat df = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = (Date) df.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/** 
	 * <p>获取当前时间的秒数</p>
	 * @return: long:当前时间的秒数
	 */
	public static long  getCurrentMillSecond(){
		return System.currentTimeMillis()/1000;
	}

	/** 
	 * <p>获取当前时间，并转化为指定格式</p>
	 * @param pattern 数据的格式化模式(例如"yyyy-MM-dd HH:mm:ss)
	 * @return String:指定格式的字符串型时间
	 */
	public static final String getCurrentTime(String pattern) {
		SimpleDateFormat fam = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		String currentTime = fam.format(calendar.getTime());
		return currentTime;
	}
	public static final String getNextNdayTime(String pattern, Integer n) {
		SimpleDateFormat fam = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, n);
		String currentTime = fam.format(calendar.getTime());
		return currentTime;
	}
	
	/** 
	 * <p>获取当前时间，并按"yyyy-MM-dd"格式输出</p>
	 * @return String:"yyyy-MM-dd"格式的字符串型时间
	 */
	public static final String getCurrentTime() {
		SimpleDateFormat fam = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		String currentTime = fam.format(calendar.getTime());
		return currentTime;
	}

	/** 
	 * <p>格式转换，将"yyyy-MM-dd*"格式的字符串型时间转化成"yyyyMMdd"格式</p>
	 * @param date "yyyy-MM-dd*"格式的字符串型时间
	 * @return String:"yyyyMMdd"格式的字符串型时间
	 */
	public static final String getFormatDate(String date) {
		if (date == null || date.length() == 0) {
			return date;
		}
		String year = date.substring(0, 4);
		int firstIndex = date.indexOf("-");
		int lastIndex = date.lastIndexOf("-");
		String month = date.substring(firstIndex + 1, lastIndex);
		String day = date.substring(lastIndex + 1);
		if (month.length() == 1) {
			month = "0" + month;
		}
		if (day.length() == 1) {
			day = "0" + day;
		}
		return year + month + day;
	}

	/** 
	 * <p>获取当月的第一天</p>
	 * @return String:"yyyy-MM-01"格式的字符串，表示当月的第一天
	 */
	public static String getFirstDayOfMonth() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-01");
		Date firstDay = new Date();
		return format.format(firstDay);

	}

	/** 
	 * <p>获取当月的最后一天</p>
	 * @return String:"yyyy-MM-**"格式的字符串，表示当月的最后一天(由于每个月最后一天数字不同，所以使用"**"代替)
	 */
	public static String getLastDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		java.text.Format formatter = new SimpleDateFormat("yyyy-MM-"+ maxDay);
		return formatter.format(cal.getTime());
	}

	/** 
	 * <p>获取Timestamp型的时间</p>
	 * @return Timestamp型时间，表示当前时间
	 */
	public static Timestamp now() {
		return new Timestamp(System.currentTimeMillis());
	}

	/** 
	 * <p>日期格式化，将Date型时间转化成指定格式的字符串</p>
	 * @param date Date型时间
	 * @param pattern 时间将要转化的格式
	 * @return String:指定格式的字符串型时间
	 */
	public static String date2String(Date date, String pattern) {
		if (date == null)
			return "";
		DateFormat df = new SimpleDateFormat(pattern);
		String d = df.format(date);
		return d;
	}
	
	/** 
	 * <p>计算两个日期之间相隔天数</p>
	 * @param dtFrom Date型时间，起始时间
	 * @param dtEnd Date型时间，终止时间
	 * @return Integer:两个日期之间相隔天数
	 */
	public static Integer getDaysBetweenTwoDates(Date dtFrom, Date dtEnd) {
		long begin = dtFrom.getTime();
		long end = dtEnd.getTime();
		long inter = end - begin;
		int flag = 1;
		if (inter < 0) {
			inter = inter * (-1);
			flag = flag * (-1);
		}
		long dateMillSec = 24 * 60 * 60 * 1000;
		long dateCnt = inter / dateMillSec;
		long remainder = inter % dateMillSec;
		if (remainder!= 0&&dateCnt!=0) {
			dateCnt++;
		}
		return flag * (int) dateCnt;
	}
	
	/** 
	 * <p>将"yyyy-MM-dd hh:mm:ss"格式的字符串型时间，转化为Timestamp型</p>
	 * @param dateString "yyyy-MM-dd hh:mm:ss"格式的字符串型时间
	 * @return Timestamp:转化后的时间
	 * @throws ParseException 转换时异常
	 */
	public final static Timestamp string2Time(String dateString)
			throws ParseException {
		Date timeDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			timeDate = (Date) df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		Timestamp dateTime = new Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime;
	}
	
	/** 
	 * <p>将"yyyy-MM-dd hh:mm:ss"格式的字符串型时间，转化为"yyMMddHHmmss"格式的 字符串型时间</p>
	 * @param dateString "yyyy-MM-dd hh:mm:ss"格式的字符串型时间
	 * @return Timestamp:"yyMMddHHmmss"格式的字符串型时间
	 */
	public static String getStringDate(String dateString){
		Date timeDate = null;
		String stringDate = null; 
		DateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DateFormat sdf2 = new SimpleDateFormat("yyMMddHHmmss");
		try {
			timeDate = sdf1.parse(dateString);
			stringDate = sdf2.format(timeDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return stringDate;
	}

	/**
	 * 获取指定时间所属周的指定日期
	 * @param date 指定时间
	 * @param addDay 添加的天数
	 * @return
	 */
	public final static Date getAddDayDate(Date date,int addDay){
		return getAddDayDate(date,addDay,0);
	}
	/**
	 * 获取指定时间所属周的指定日期
	 * @param date 指定时间
	 * @param addDay 添加的天数
	 * @param type 时间类型1：起始时间，2：截止时间，3：当前时间
	 * @return
	 */
	public final static Date getAddDayDate(Date date,int addDay,int type){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR,addDay);
		setDayStartOrEnd(calendar,type);
		return calendar.getTime();
	}

	/**
	 *	获取指定时间所属周的指定日期
	 * @param date 指定时间
	 * @param weekDiff 添加周数
	 * @param dayIndex 一周内日期的下标，取值范围0-6，0表示周一，6表示周日
	 * @return
	 */
	public static Date getAssignWeekDay(Date date,int weekDiff,int dayIndex) {
		return getAssignWeekDay(date,weekDiff,dayIndex,0);
	}

	/**
	 *	获取指定时间所属周的指定日期
	 * @param date 指定时间
	 * @param weekDiff 添加周数
	 * @param dayIndex 一周内日期的下标，取值范围0-6，0表示周一，6表示周日
	 * @param type 时间类型1：起始时间，2：截止时间，3：当前时间
	 * @return
	 */
	public static Date getAssignWeekDay(Date date,int weekDiff,int dayIndex, int type) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if(dayIndex<0){
			dayIndex = 0;
		}else if(dayIndex>6){
			dayIndex = 6;
		}
		// 获得当前日期是一个星期的第几天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 获得当前日期是一个星期的第几天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day + dayIndex);
		cal.add(Calendar.WEEK_OF_MONTH,weekDiff);
		setDayStartOrEnd(cal,type);
		return cal.getTime();
	}

	/**
	 * 获取指定日期的开始时间和结束时间
	 * @param date 指定日期
	 * @param type 时间类型1：起始时间，2：截止时间，3：当前时间
	 * @return
	 */
	public static Date getDateStartOrEnd(Date date, int type) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		setDayStartOrEnd(calendar,type);
		return calendar.getTime();
	}

	/**
	 * 设置日期的开始时间和结束时间
	 * @param calendar 日期驱动器
	 * @param type 时间类型1：起始时间，2：截止时间，3：当前时间
	 */
	public static void setDayStartOrEnd(Calendar calendar, int type){
		if(type == 1){
			calendar.set(Calendar.HOUR_OF_DAY,0);
			calendar.set(Calendar.MINUTE,0);
			calendar.set(Calendar.SECOND,0);
		}else if(type == 2){
			calendar.set(Calendar.HOUR_OF_DAY,23);
			calendar.set(Calendar.MINUTE,59);
			calendar.set(Calendar.SECOND,59);
		}
	}


	public static String[] getDateRange(String type){
		Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String[] dateRange = new String[2];
		Date startTime;
		Date endTime = calendar.getTime();
		if ("d".equals(type)){
			calendar.add(Calendar.DAY_OF_MONTH,-1);
		}else if("w".equals(type)){
			calendar.add(Calendar.WEEK_OF_YEAR,-1);
		}else if("m".equals(type)){
			calendar.add(Calendar.MONTH,-1);
		}else if("y".equals(type)){
			calendar.add(Calendar.YEAR,-1);
		}
		startTime = calendar.getTime();
		dateRange[0]=df.format(startTime);
		dateRange[1]=df.format(endTime);
		return dateRange;
	}

	public static boolean isSameDay(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
				.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear
				&& cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		boolean isSameDate = isSameMonth
				&& cal1.get(Calendar.DAY_OF_MONTH) == cal2
				.get(Calendar.DAY_OF_MONTH);

		return isSameDate;

	}

}
