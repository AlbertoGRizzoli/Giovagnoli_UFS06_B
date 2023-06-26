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
        return gson.toJson(hotelList);
    }

    public String allSorted(){
        List<Albergo> newHotelList = new ArrayList<>(hotelList);
        newHotelList.sort(Comparator.comparing(Albergo::getNome));
        return gson.toJson(newHotelList);
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
        return gson.toJson(hotelList.get(index));
    }

    public String moreExpensiveHTML(){

        HtmlDesign design = new HtmlDesign();
        String risposta = design.getUpperPart();
        int maxPrice=0;
        int index=0;
        for(int i=0;i<hotelList.size();i++){
            if(hotelList.get(i).getSuite()==true && hotelList.get(i).getSuite_price()>maxPrice){
                maxPrice=hotelList.get(i).getSuite_price();
                index=i;
            }
        }
        risposta += "<tr><td>" + hotelList.get(index).getId() + "</td> <td>"
                + hotelList.get(index).getNome() + "</td> <td>"
                + hotelList.get(index).getSuite_price() + "</td> <td>"
                + hotelList.get(index).getSuite() + "</td> </tr>";

        risposta+=design.getBottomPart();
        return risposta;
    }
    private String allHtml() {
        HtmlDesign design = new HtmlDesign();
        String risposta = design.getUpperPart();
        for(int i=0;i<hotelList.size();i++) {
            risposta += "<tr><td>" + hotelList.get(i).getId() + "</td> <td>"
                + hotelList.get(i).getNome() + "</td> <td>"
                + hotelList.get(i).getSuite_price() + "</td> <td>"
                + hotelList.get(i).getSuite() + "</td> </tr>";
        }
        risposta+=design.getBottomPart();
        return risposta;
    }
    private String allSortedHtml() {
        List<Albergo> newHotelList = new ArrayList<>(hotelList);

        HtmlDesign design = new HtmlDesign();
        String risposta = design.getUpperPart();

        newHotelList.sort(Comparator.comparing(Albergo::getNome));

        for(int i=0;i<newHotelList.size();i++) {
            risposta += "<tr><td>" + newHotelList.get(i).getId() + "</td> <td>"
                    + newHotelList.get(i).getNome() + "</td> <td>"
                    + newHotelList.get(i).getSuite_price() + "</td> <td>"
                    + newHotelList.get(i).getSuite() + "</td> </tr>";
        }
        risposta+=design.getBottomPart();
        return risposta;
    }

    String selettoreComandiGestore(String command) {
        return switch (command.toLowerCase()) {
            case "all" -> all();
            case "all_sorted" -> allSorted();
            case "more_expensive_suite" -> moreExpensiveSuite();
            case "all_html" -> allHtml();
            case "all_sorted_html" -> allSortedHtml();
            case "more_expensive_html" -> moreExpensiveHTML();

            default -> "Comando sconosciuto. Provare con 'all', 'all_sorted' o 'more_expensive_suite'";
        };
    }




}
