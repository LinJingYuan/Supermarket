package cn.itcast.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeTools {

	/**
	 * 设置时间为0点 0 分 0 秒
	 *
	 * @author: en
	 * @date:   2020年3月5日 下午5:13:05
	 *   
	 * @param date
	 * @return
	 */
	public static Date getOnlyDate(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date newDate = calendar.getTime();
		return newDate;
	}

	/**
	 * Date加/减天数
	 *
	 * @author: en
	 * @date: 2020年3月5日 下午4:51:17
	 * 
	 * @param date      被加减的日期
	 * @param addDayNum 正数+，负数-
	 * @return
	 */
	public static Date dateAddDay(Date date, int addDayNum) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, addDayNum);
		Date newDate = calendar.getTime();
		return newDate;
	}

}
