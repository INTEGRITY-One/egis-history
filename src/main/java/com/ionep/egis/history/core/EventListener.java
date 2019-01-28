package com.ionep.egis.history.core;

import java.util.concurrent.CountDownLatch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ionep.egis.current.domain.CurrentConditions;

@Component
public class EventListener {
	
	private static Log log = LogFactory.getLog(EventListener.class);
	
	private CountDownLatch currentConditionsLatch = new CountDownLatch(1);

	@KafkaListener(topics = "BALTIMORE_MD", containerFactory = "currentConditionsKafkaListenerContainerFactory")
	public void currentConditionsListener(CurrentConditions currentConditions) {
		log.info("Received message: " + currentConditions);
		this.currentConditionsLatch.countDown();
	}

}
