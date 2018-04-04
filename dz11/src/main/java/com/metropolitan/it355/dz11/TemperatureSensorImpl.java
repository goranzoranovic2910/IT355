/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it355.dz11;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 *
 * @author Goran
 */
public class TemperatureSensorImpl implements TemperatureSensor {

    private JmsTemplate jmsTemplate;
    private Destination destination;
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
    }
    public void setDestination(Destination destination) {
    this.destination = destination;
    }

    @Override
    public void sendCurrentTemperature(TemperatureInfo info) {
        
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
            MapMessage message = session.createMapMessage();
            message.setDouble("temperature", info.getTemperature());
            message.setString("city", info.getCity());
            return message;
            }
        });
    }
}
