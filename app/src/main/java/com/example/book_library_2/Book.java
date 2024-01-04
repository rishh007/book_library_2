package com.example.book_library_2;

// Book.java
public class Book {
    private String title;
    private String author;
    private String summary;
    private int count;

    // Corrected constructor with meaningful parameter names
    public Book(String title, String author, String summary) //this is a constructor
    {
        this.title = title;
        this.author = author;
        this.summary = summary;
        // Initialize count to 0 by default
        this.count = 0;
    }

    // Constructors, getters, and setters can be added here

    public String getTitle() {
        return title;//will return to main activity openDetailsActivity
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {    //method defined here
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
