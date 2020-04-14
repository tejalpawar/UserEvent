package com.example.IFANOW.messaging;

import com.example.IFANOW.constant.EmailConstant;
import com.example.IFANOW.constant.FcmConstant;
import com.example.IFANOW.constant.SMSConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class MessageSender {

	private static final String IFANOW_EMAIL_QUEUE = "Ifanow-email-queue";

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(String queueId, String type) {
		System.out.println("=============message send [" + queueId + "] TYPE " + type);
		if (EmailConstant.EMAIL.equalsIgnoreCase(type)) {

			jmsTemplate.send(IFANOW_EMAIL_QUEUE, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(queueId);
				}
			});
		}
	}
}
