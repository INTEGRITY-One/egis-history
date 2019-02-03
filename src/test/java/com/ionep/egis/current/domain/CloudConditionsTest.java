package com.ionep.egis.current.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CloudConditionsTest {
	
	@Test
	public void constructor() throws Exception {
		CloudConditions conditions = new CloudConditions();
		assertNotNull(conditions);
	}
	
	@Test
	public void allFields() throws Exception {
		CloudConditions conditions = new CloudConditions();
		conditions.setCloudiness(Cloudiness.CLEAR.ordinal());
		assertEquals(Cloudiness.CLEAR.ordinal(), conditions.getCloudiness());
	}

	@Test
	public void from() throws Exception {
		CloudConditions conditions = new CloudConditions();
		conditions.setCloudiness(Cloudiness.CLEAR.ordinal());
		assertEquals(Cloudiness.CLEAR.ordinal(), conditions.getCloudiness());
		CloudConditions copy = new CloudConditions();
		copy.setCloudiness(Cloudiness.CLOUDY.ordinal());
		assertEquals(Cloudiness.CLOUDY.ordinal(), copy.getCloudiness());
		copy.from(conditions);
		assertEquals(Cloudiness.CLEAR.ordinal(), copy.getCloudiness());
	}

}
