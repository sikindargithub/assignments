package com.spring.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component("cricket")
public class Cricket implements Sports {
    @Override
    public List<String> showPlayers() {
        return Arrays.asList("Kohli","Warner","Gale","Root","Sachin","Sehwag","Jayasurya");
    }
}
