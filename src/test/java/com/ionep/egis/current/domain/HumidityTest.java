package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class HumidityTest {

	@Test
	public void constructor() throws Exception {
		Humidity humidity = new Humidity();
		assertNotNull(humidity);
	}

	@Test
	public void humid() throws Exception {
		Humidity humidity = new Humidity();
		humidity.setHumid(30);
		assertEquals(30, humidity.getHumid());
	}

	@Test
	public void from() throws Exception {
		Humidity humidity = new Humidity();
		humidity.setHumid(30);
		Humidity copy = new Humidity();
		copy.setHumid(70);
		assertEquals(70, copy.getHumid());
		copy.from(humidity);
		assertEquals(30, copy.getHumid());
	}

}
