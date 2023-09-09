package com.example.app_borrow_book.service;

import com.example.app_borrow_book.entity.Oder;
import com.example.app_borrow_book.repository.IOderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderService implements IOderService{

    @Autowired
    private IOderRepository iOderRepository;

    @Override
    public List<Oder> findAll() {
        return iOderRepository.findAll();
    }

    @Override
    public Oder findById(long id) {
        return iOderRepository.findById(id).orElse(null);
    }

    @Override
    public Oder findByCode(long code) {
        return iOderRepository.findByCode(code);
    }

    @Override
    public void saveOder(Oder oder) {
        iOderRepository.save(oder);
    }

//    @Override
//    public void save(Oder oder) {
//        iOderRepository.save(oder);
//    }
}
