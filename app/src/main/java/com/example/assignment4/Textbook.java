package com.example.assignment4;

public class Textbook {
    private double price;
    private String title;
    private String seller;
    private String quality;
    private String author;
    private String isbn;
    private String edition;
    private String class_tag;
    private String lastUsed;
    Textbook(double p, String t, String a, String s, String q, String isbn, String edition, String class_tag, String lastUsed) {
        price = p;
        title = t;
        author = a;
        seller = s;
        quality = q;
        this.isbn = isbn;
        this.edition = edition;
        this.class_tag = class_tag;
        this.lastUsed = lastUsed;
    }
    public double getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }
    public String getSeller() {
        return seller;
    }
    public String getQuality() {return quality;}
    public String getISBN() {return isbn;}
    public String getClassTag() {return class_tag;}
    public String getLastUsed() {return lastUsed;}
    public String getAuthor() {return author;}

    public void setPrice(double p ) {
        price = p;
    }
    public void setTitle(String t ) {
        title = t;
    }
    public void setSeller(String s ) {
        seller = s;
    }


}
