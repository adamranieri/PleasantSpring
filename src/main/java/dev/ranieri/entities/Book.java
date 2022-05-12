package dev.ranieri.entities;
// ORM Object Relational mapping
// We can use annotations to map an entity to a table in our database

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id// this is the field that is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// this field is auto generated by postgres
    @Column(name = "book_id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "return_date")
    private long returnDate;

    @Column(name = "p_id")
    private int publisherId;


    public Book() {
    }

    public Book(int id, String title, String author, long returnDate, int publisherId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.returnDate = returnDate;
        this.publisherId = publisherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(long returnDate) {
        this.returnDate = returnDate;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", returnDate=" + returnDate +
                ", publisherId=" + publisherId +
                '}';
    }
}
