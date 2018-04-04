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
public class WeatherServiceMain {
    
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-service.xml");
        WeatherService service = (WeatherService) context.getBean("weatherService");
        service.receiveTemperatureData();
        System.out.println ("temperatura je primljena!!!");
        
    }
}
