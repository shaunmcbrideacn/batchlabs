package com.batchdemo.error;

import org.springframework.batch.core.listener.SkipListenerSupport;
import org.springframework.jms.core.JmsTemplate;

/**
 * Writes errors to a message queue
 */
public class QueueErrorListener<T, S> extends SkipListenerSupport<T, S> {

	private JmsTemplate jmsTemplate;
	
	private String errorQueueName;

	@Override
	public void onSkipInProcess(T item, Throwable t) {
		ItemAndThrowable message = new ItemAndThrowable(item, t);
		jmsTemplate.convertAndSend(errorQueueName, message.toString());
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public String getErrorQueueName() {
		return errorQueueName;
	}

	public void setErrorQueueName(String errorQueueName) {
		this.errorQueueName = errorQueueName;
	}
	
	
	
	

}
