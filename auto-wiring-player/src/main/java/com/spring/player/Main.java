package com.spring.player;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.player");
        EventDetails eventDetails = context.getBean("eventDetails",EventDetails.class);
        eventDetails.printEvent("football").forEach(System.out::println);
        eventDetails.printEvent("hockey").forEach(System.out::println);
        eventDetails.printEvent("cricket").forEach(System.out::println);
    }
}
