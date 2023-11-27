package by.bsuir.webtech.ilya.entities;

import java.sql.Date;

public class Book extends  Entity{
    private long id;
    private String title;
    private String author;
    private String genre;
    private int price;
    private Date publicationDate;
    private String description;
    private String imageUrl;
    private int rating;

    public Book(String author,String title,int price,String genre)
    {
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.title = title;
    }
    public Book(Long id,String author,String title,int price,String genre)
    {
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.title = title;
        this.id = id;
    }
    public Book(Long id,String author,String title,int price,String genre,String description,Date publicationDate)
    {
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.title = title;
        this.id = id;
        this.description = description;
        this.publicationDate = publicationDate;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
