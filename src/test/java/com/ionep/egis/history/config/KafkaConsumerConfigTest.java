package com.ionep.egis.history.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.ConsumerFactory;

import com.ionep.egis.current.domain.CurrentConditions;

public class KafkaConsumerConfigTest {
	
	@Test
	public void constructor() throws Exception {
		KafkaConsumerConfig producerConfig = new KafkaConsumerConfig();
		assertNotNull(producerConfig);
	}
	
	@Test
	public void bootstrapAddress() throws Exception {
		String bootstrapAddess = "localhost:1234";
		KafkaConsumerConfig producerConfig = new KafkaConsumerConfig();
		producerConfig.setBootstrapAddress(bootstrapAddess);
		assertEquals(bootstrapAddess, producerConfig.getBootstrapAddress());
	}

	@Test
	public void producerFactory() throws Exception {
		KafkaConsumerConfig producerConfig = new KafkaConsumerConfig();
		ConsumerFactory<String, CurrentConditions> producerFactory = producerConfig.consumerFactory();
		assertNotNull(producerFactory);
	}

}
