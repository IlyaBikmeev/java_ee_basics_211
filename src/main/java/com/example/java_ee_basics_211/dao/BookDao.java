package com.example.java_ee_basics_211.dao;

import com.example.java_ee_basics_211.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    List<Book> getAll();
    Optional<Book> findById(int id);
    void save(Book book);
}
