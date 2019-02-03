package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class TemperatureTest {
	
	@Test
	public void constructor() throws Exception {
		Temperature temperature = new Temperature();
		assertNotNull(temperature);
	}

	@Test
	public void temp() throws Exception {
		Temperature temperature = new Temperature();
		temperature.setTemp(72);
		assertEquals(72, temperature.getTemp());
	}

	@Test
	public void from() throws Exception {
		Temperature temperature = new Temperature();
		temperature.setTemp(72);
		Temperature copy = new Temperature();
		copy.setTemp(32);
		assertEquals(32, copy.getTemp());
		copy.from(temperature);
		assertEquals(72, copy.getTemp());
	}

}
