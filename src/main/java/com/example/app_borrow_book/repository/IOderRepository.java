package com.example.app_borrow_book.repository;

import com.example.app_borrow_book.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOderRepository extends JpaRepository<Oder,Long> {
    Oder findByCode(long code);
}
