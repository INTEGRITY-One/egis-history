package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

public class DateDimensionTest {
	
	@Test
	public void constructor() throws Exception {
		DateDimension date = new DateDimension();
		assertNotNull(date);
	}

	@Test
	public void date() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.of(2019, Month.FEBRUARY, 2, 11, 30, 45);
		DateDimension date = new DateDimension(localDateTime);
		assertNotNull(date);
		assertEquals("20190202", date.getDate());
		assertEquals("02", date.getDayOfMonth());
		assertEquals("SAT", date.getDayOfWeek());
		assertEquals("11", date.getHour());
		assertEquals("FEB", date.getMonth());
		assertEquals("05", date.getWeekOfYear());
		assertEquals("2019", date.getYear());
	}

	@Test
	public void from() throws Exception {
		LocalDateTime localDateTime = LocalDateTime.of(2019, Month.FEBRUARY, 2, 11, 30, 45);
		DateDimension date = new DateDimension(localDateTime);

		LocalDateTime timestamp = LocalDateTime.of(2018, Month.JANUARY, 1, 21, 12, 24);
		DateDimension copy = new DateDimension(timestamp);

		assertNotNull(copy);
		assertEquals("20180101", copy.getDate());
		assertEquals("01", copy.getDayOfMonth());
		assertEquals("MON", copy.getDayOfWeek());
		assertEquals("21", copy.getHour());
		assertEquals("JAN", copy.getMonth());
		assertEquals("01", copy.getWeekOfYear());
		assertEquals("2018", copy.getYear());
		
		copy.from(date);

		assertNotNull(date);
		assertEquals("20190202", date.getDate());
		assertEquals("02", date.getDayOfMonth());
		assertEquals("SAT", date.getDayOfWeek());
		assertEquals("11", date.getHour());
		assertEquals("FEB", date.getMonth());
		assertEquals("05", date.getWeekOfYear());
		assertEquals("2019", date.getYear());
	}

}
