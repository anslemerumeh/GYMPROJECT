package com.company.account;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Drive {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date();
		GregorianCalendar cal1 = new GregorianCalendar(2019, 8, 28);
		Calendar cal = GregorianCalendar.getInstance();
		System.out.println(cal.getTime().after(date));

		ZonedDateTime am = ZonedDateTime.now();
		System.out.println(
				"zone: " + am.getDayOfMonth() + " day week: " + am.getDayOfWeek() + " month: " + am.getMonth());

		System.out.println("cal1: " + cal1.getGregorianChange());
		System.out.println("Date: " + date.getHours());
		if (cal1.getWeeksInWeekYear() == cal.getWeeksInWeekYear())
			System.out.println("true");
		else
			System.out.println("false");

		LocalDateTime d = LocalDateTime.of(2017, 5, 28, 15, 26);
		System.out.println("Local month: " + d.getMonth() + " >>Day: " + d.getDayOfMonth() + " >> pep"
				+ d.getDayOfWeek() + " Hour " + d.getHour() + " Minute: " + d.getMinute());
		ZoneId i = ZoneId.of("Africa/Johannesburg");
		ZonedDateTime z = ZonedDateTime.of(d, i);
		System.out.println(z.getZone());
		LocalDateTime di = LocalDateTime.now();
		System.out.println(di.getHour());

		/*
		 * 
		 * LocalDateTime today = LocalDateTime.now(); //Today LocalDateTime tomorrow =
		 * today.plusDays(1); //Plus 1 day LocalDateTime yesterday = today.minusDays(1);
		 * //Minus 1 day
		 * 
		 * System.out.println(today); //2018-07-14 System.out.println(tomorrow);
		 * //2018-07-15 System.out.println(yesterday); //2018-07-13
		 * 
		 * LocalDateTime sameDayNextMonth = today.plusMonths(1); //2018-08-14
		 * LocalDateTime sameDayLastMonth = today.minusMonths(1); //2018-06-14
		 * 
		 * LocalDateTime sameDayNextYear = today.plusYears(1); //2019-07-14
		 * LocalDateTime sameDayLastYear = today.minusYears(1); //2017-07-14
		 * 
		 * //Get Date from LocalDateTime //Not recommended. Use when you have no options
		 * in legacy code. Date currentDatePlusOneDay =
		 * Date.from(tomorrow.atZone(ZoneId.systemDefault()).toInstant());
		 * 
		 * System.out.println(currentDatePlusOneDay); //Sun Jul 15 22:25:04 IST 2018
		 */

	}
}
