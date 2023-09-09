package com.example.app_borrow_book.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Data
// lombook là 1 thư viện tự tạo getter,setter ,contructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int count;

    private String author;

    @ManyToMany
    @JoinTable(
            name = "oder_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "oder_id"))

    List<Oder> list;


    public Book() {
    }

    public Book(int id, String name, int count, String author, List<Oder> list) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.author = author;
        this.list = list;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Oder> getList() {
        return list;
    }

    public void setList(List<Oder> list) {
        this.list = list;
    }
}
