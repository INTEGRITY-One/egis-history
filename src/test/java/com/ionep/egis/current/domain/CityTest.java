package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CityTest {
	
	@Test
	public void constructor() throws Exception {
		City city = new City();
		assertNotNull(city);
	}
	
	@Test
	public void allFields() throws Exception {
		City city = new City();
		city.setName("BALTIMORE_MD");
		assertEquals("BALTIMORE_MD", city.getName());
	}
	
	@Test
	public void from() throws Exception {
		City city = new City();
		city.setName("BALTIMORE_MD");
		City copy = new City();
		copy.setName("PITTSBURGH_PA");
		assertEquals("PITTSBURGH_PA", copy.getName());
		copy.from(city);
		assertEquals("BALTIMORE_MD", copy.getName());
	}

}
