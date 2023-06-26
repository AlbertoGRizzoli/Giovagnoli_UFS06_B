package org.example;

public class Albergo {
    private int id;
    private String nome;
    private int price_suite;
    private int suite_qty;

    public Albergo(int id, String nome, int price_suite, int suite_qty) {
        this.id = id;
        this.nome = nome;
        this.price_suite = price_suite;
        this.suite_qty = suite_qty;
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

    public int getPrice_suite() {
        return price_suite;
    }

    public void setPrice_suite(int price_suite) {
        if(price_suite>0) this.price_suite = price_suite;
        else this.price_suite=1;
    }

    public int getSuite_qty() {
        return suite_qty;
    }

    public void setSuite_qty(int suite_qty) {
        if(suite_qty>=0) this.suite_qty = suite_qty;
        else this.suite_qty=0;

    }
}
