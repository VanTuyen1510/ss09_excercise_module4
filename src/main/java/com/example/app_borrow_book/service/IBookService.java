package com.example.app_borrow_book.service;

import com.example.app_borrow_book.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int idBook);

    void save(Book book);

    void delete(int idBook);

}
