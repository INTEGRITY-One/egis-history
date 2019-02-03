package com.ionep.egis.history.core;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.util.ReflectionTestUtils;

import com.ionep.egis.current.domain.CurrentConditions;
import com.ionep.egis.history.service.CurrentConditionsWriter;

@ExtendWith(MockitoExtension.class)
public class EventListenerTest {
	
	@Mock
	private CurrentConditionsWriter writer;
	
	@Test
	public void constructor() throws Exception {
		EventListener eventListener = new EventListener();
		assertNotNull(eventListener);
		ReflectionTestUtils.setField(eventListener, "currentConditionsWriter", this.writer);
	}
	
	@Test
	public void currentConditionsListener() throws Exception {
		EventListener eventListener = new EventListener();
		ReflectionTestUtils.setField(eventListener, "currentConditionsWriter", this.writer);
		CurrentConditions currentConditions = new CurrentConditions();
		eventListener.currentConditionsListener(currentConditions);
	}

}
