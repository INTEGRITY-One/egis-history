package com.ionep.egis.history.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
public class KafkaAdminConfigTest {
	
	@Test
	public void constructor() throws Exception {
		KafkaAdminConfig config = new KafkaAdminConfig();
		assertNotNull(config);
	}
	
	@Test
	public void kafkaAdmin() throws Exception {
		KafkaAdminConfig config = new KafkaAdminConfig();
		KafkaAdmin admin = config.kafkaAdmin();
		assertNotNull(admin);
	}

}
