package org.example;

public class Albergo {
    private int id;
    private String nome;
    private int suite_price;
    private boolean suite;

    public Albergo(int id, String nome, int price_suite, boolean suite) {
        this.id = id;
        this.nome = nome;
        this.suite_price = price_suite;
        this.suite=suite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome!="") this.nome = nome;
        else this.nome="nome default";
    }

    public int getSuite_price() {
        return suite_price;
    }

    public void setSuite_price(int suite_price) {
        if(suite_price>0) this.suite_price = suite_price;
        else this.suite_price = 1;
    }


    public boolean getSuite() {
        return suite;
    }

    public void setSuite(boolean suite) {
        this.suite = suite;
    }
}
