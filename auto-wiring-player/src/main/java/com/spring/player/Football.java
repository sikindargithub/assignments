package com.spring.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component("football")
public class Football implements  Sports{
    @Override
    public List<String> showPlayers() {
        return Arrays.asList("Ronaldo","Messi","Muller","Lewandowski","Salah","Kevin De Bruyne");
    }
}
