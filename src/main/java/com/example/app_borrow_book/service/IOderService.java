package com.example.app_borrow_book.service;

import com.example.app_borrow_book.entity.Book;
import com.example.app_borrow_book.entity.Oder;

import java.util.List;

public interface IOderService {

    List<Oder> findAll();

    Oder findById(long id);

    Oder findByCode(long code);

    void saveOder(Oder oder);
}
