package com.example.Student_Library_Management.Models;

import com.example.Student_Library_Management.Enums.Genre;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "book")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int pages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn //add an extra attribute of authorId(parent table primary key)for the foreign key of child table
    private Author author; //This is the parent entity we are connecting with



    //Book is also child wrt card class
    @ManyToOne
    @JoinColumn
    private Card card;

    private boolean issued;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transactions> listOfTransaction= new ArrayList<>();

    public List<Transactions> getListOfTransaction() {
        return listOfTransaction;
    }

    public void setListOfTransaction(List<Transactions> listOfTransaction) {
        this.listOfTransaction = listOfTransaction;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
