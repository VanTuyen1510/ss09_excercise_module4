package com.example.app_borrow_book.service;

import com.example.app_borrow_book.entity.Book;

import com.example.app_borrow_book.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(int idBook) {
        return iBookRepository.findById(idBook).orElse(null);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void delete(int idBook) {
        iBookRepository.deleteById(idBook);
    }


}
