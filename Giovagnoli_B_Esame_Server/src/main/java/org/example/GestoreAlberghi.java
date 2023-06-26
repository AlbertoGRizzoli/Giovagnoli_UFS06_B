package org.example;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GestoreAlberghi {

    List<Albergo> hotelList = new ArrayList<>();
    private static GestoreAlberghi instance;
    private static final Gson gson = new Gson();

    public GestoreAlberghi() {
        hotelList.add(new Albergo(1,"Hot place",200, 6));
        hotelList.add(new Albergo(2,"Sogni d'oro",150, 0));
        hotelList.add(new Albergo(3,"Bel riposone",100, 2));
    }

    public static GestoreAlberghi getInstance() {
        if (instance == null) {
            instance = new GestoreAlberghi();
        }

        return instance;
    }

    public String all(){
        return "";
    }

    public String allSorted(){
        return "";
    }

    public String moreExpensiveSuite(){
        return "";
    }


    String selettoreComandiGestore(String command) {
        return switch (command.toLowerCase()) {
            case "all" -> all();
            case "all_sorted" -> allSorted();
            case "more_expensive_suite" -> moreExpensiveSuite();
            default -> "Comando sconosciuto. Provare con 'all', 'all_sorted' o 'more_expensive_suite'";
        };
    }
}
