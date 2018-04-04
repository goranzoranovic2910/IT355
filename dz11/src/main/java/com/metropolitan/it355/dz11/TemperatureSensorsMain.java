/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metropolitan.it355.dz11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Goran
 */
public class TemperatureSensorsMain {
    
    public static void main(String[] args){
        
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-sensor.xml");
        TemperatureSensor sensor = (TemperatureSensor) context.getBean("temperatureSensor");       
        sensor.sendCurrentTemperature(new TemperatureInfo(20, "Beograd"));
        System.out.println ("Temperatura je poslata za Beograd!!!");
        
        TemperatureSensor sensor2 = (TemperatureSensor) context.getBean("temperatureSensor");       
        sensor2.sendCurrentTemperature(new TemperatureInfo(21, "Novi sad"));
        System.out.println ("Temperatura je poslata za Novi sad!!!");
    }
    
}
