package com.servlet.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String director;
    private int year;
    private String rate;

    public Movie() {

    }

    public Movie(String t, double rate) {
        DecimalFormat df = new DecimalFormat("#.##");
        this.rate = df.format(rate);
        if (checkTitle(t)) this.title = t;
    }

    public Movie(String string, String string1, int anInt, String rate) {
        if (checkTitle(string)) this.title = string;
        if (checkDirector(string1)) this.director = string1;
        this.year = anInt;
        this.rate = rate;
    }

    public String toStringAboutMovie() {
        return "movie: " + title + "\n produced by: " + director +
                "\n average rate: " + rate +
                "\n year: " + year;
    }

    private boolean checkTitle(String t) {
        return Pattern.matches("^[\\p{L} .'-]*$", t);
    }

    private boolean checkDirector(String d) {
        return Pattern.matches("^[\\p{L} .'-]*$", d);
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", year='" + year + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }

}