package org.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Author")
    private String Author;
    @JsonProperty("Genre")
    private String Genre;
    @JsonProperty("Publisher")
    private String Publisher;
    @JsonProperty("Number")
    private int Number;
    @JsonProperty("SubGenre")
    private String Subgenre;

    private boolean isLoaned = false;

    private int timesLoaned = 0;


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getSubgenre() {
        return Subgenre;
    }

    public void setSubgenre(String subgenre) {
        Subgenre = subgenre;
    }

    public boolean isLoaned() {
        return isLoaned;
    }

    public void setLoaned(boolean loaned) {
        isLoaned = loaned;
    }

    public int getTimesLoaned() {
        return timesLoaned;
    }

    public void setTimesLoaned(int timesLoaned) {
        this.timesLoaned = timesLoaned;
    }

    public Book() {
    }

    public String getInfo(){
        return getTitle() + " by " + getAuthor() + " under the genres " + getGenre() + " and " + getSubgenre() + " and published by " + getPublisher();
    }


}
