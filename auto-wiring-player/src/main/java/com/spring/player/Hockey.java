package com.spring.player;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component("hockey")
public class Hockey implements Sports{
    @Override
    public List<String> showPlayers() {
        return Arrays.asList("Hilary Knight","Rani Rampal","Emerance Maschmeyer","Tanja Eisenschmid","Maddie Hinch","Savita Punia");
    }
}
