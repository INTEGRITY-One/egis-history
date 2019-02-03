package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class PrecipitationTest {

	@Test
	public void constructor() throws Exception {
		Precipitation precipitation = new Precipitation();
		assertNotNull(precipitation);
	}

	@Test
	public void precip() throws Exception {
		Precipitation precipitation = new Precipitation();
		precipitation.setPrecip(2);
		assertEquals(2, precipitation.getPrecip());
	}

	@Test
	public void from() throws Exception {
		Precipitation precipitation = new Precipitation();
		precipitation.setPrecip(2);
		Precipitation copy = new Precipitation();
		copy.setPrecip(1);
		assertEquals(1, copy.getPrecip());
		copy.from(precipitation);
		assertEquals(2, copy.getPrecip());
	}

}
