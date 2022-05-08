package com.spring.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class EventDetails {

    Sports sports;
    @Autowired
//    @Qualifier("cricket")
    Sports cricket;

    Sports football;
    @Autowired
    public EventDetails(Sports football) {
        this.football = football;
    }
    @Autowired
    Sports hockey;

    List<String> printEvent(String choice){
        System.out.println("Printing sports details : ");
       if (choice.equalsIgnoreCase("cricket")) {
           System.out.println("Cricket players list :");
           return cricket.showPlayers();
       }
       else if(choice.equalsIgnoreCase("hockey")) {
           System.out.println("Hockey players list :");
           return hockey.showPlayers();
       }
       else {
           System.out.println("Football players list :");
           return football.showPlayers();
       }
    }
}
