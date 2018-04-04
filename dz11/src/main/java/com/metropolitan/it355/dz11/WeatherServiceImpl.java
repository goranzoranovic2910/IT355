/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it355.dz11;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;

/**
 *
 * @author Goran
 */
public class WeatherServiceImpl implements WeatherService {
    private JmsTemplate jmsTemplate;
    private Destination destination;
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
    this.destination = destination;
    }
    @Override
    public void receiveTemperatureData() {
        MapMessage message = (MapMessage) jmsTemplate.receive(destination);
        
        while(message != null){
            try {
                if (message == null) {
                    System.out.println("Null message received!");
                }
                TemperatureInfo i = new TemperatureInfo(message.getDouble("temperature"), message.getString("city"));
                System.out.println("Temperature received: " + i.getTemperature() + " degrees in " + i.getCity() );
                message = (MapMessage) jmsTemplate.receive(destination);

            } catch (JMSException e) {
                throw JmsUtils.convertJmsAccessException(e);
            }
        }
    }
    
}
