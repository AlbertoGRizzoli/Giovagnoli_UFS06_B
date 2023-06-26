package org.example;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestoreAlberghi {

    List<Albergo> hotelList = new ArrayList<>();
    private static GestoreAlberghi instance;
    private static final Gson gson = new Gson();

    public GestoreAlberghi() {
        hotelList.add(new Albergo(1,"Hot place",200, false));
        hotelList.add(new Albergo(2,"Ronf Ronf posticino",150, true));
        hotelList.add(new Albergo(3,"Bel riposone",100, true));
    }

    public static GestoreAlberghi getInstance() {
        if (instance == null) {
            instance = new GestoreAlberghi();
        }
        return instance;
    }

    public String all(){
        String risposta="{ hotels: [";
        for (int i=0; i<hotelList.size();i++) {
            risposta += "id: " +hotelList.get(i).getId() + ", ";
            risposta += "Nome: " +hotelList.get(i).getNome() + ", ";
            risposta += "Prezzo_suite: " +hotelList.get(i).getSuite_price() + ", ";
            risposta += "Quantita_suite: " +hotelList.get(i).getSuite() + "; ";
        }
        risposta+="]}";
        risposta=gson.toJson(risposta);

        return risposta;
    }

    public String allSorted(){
        List<Albergo> newHotelList = new ArrayList<>(hotelList);
        newHotelList.sort(Comparator.comparing(Albergo::getNome));

        String risposta="{ hotels: [";
        for (int i=0; i<newHotelList.size();i++) {
            risposta += "id: " +newHotelList.get(i).getId() + ", ";
            risposta += "Nome: " +newHotelList.get(i).getNome() + ", ";
            risposta += "Prezzo_suite: " +newHotelList.get(i).getSuite_price() + ", ";
            risposta += "Quantita_suite: " +newHotelList.get(i).getSuite() + "; ";
        }
        risposta+="]}";
        risposta=gson.toJson(risposta);

        return risposta;
    }

    public String moreExpensiveSuite(){

        int maxPrice=0;
        int index=0;
        for(int i=0;i<hotelList.size();i++){
            if(hotelList.get(i).getSuite()==true && hotelList.get(i).getSuite_price()>maxPrice){
                maxPrice=hotelList.get(i).getSuite_price();
                index=i;
            }
        }

        String risposta="{ hotels: [";
        risposta += "id: " +hotelList.get(index).getId() + ", ";
        risposta += "Nome: " +hotelList.get(index).getNome() + ", ";
        risposta += "Prezzo_suite: " +hotelList.get(index).getSuite_price() + ", ";
        risposta += "Quantita_suite: " +hotelList.get(index).getSuite() + "; ";
        risposta+="]}";
        risposta=gson.toJson(risposta);

        return risposta;
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
