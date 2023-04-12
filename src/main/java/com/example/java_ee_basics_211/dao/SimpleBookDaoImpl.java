package com.example.java_ee_basics_211.dao;

import com.example.java_ee_basics_211.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleBookDaoImpl implements BookDao {
    private final List<Book> data = new ArrayList<>();

    @Override
    public List<Book> getAll() {
        return data;
    }

    @Override
    public Optional<Book> findById(int id) {
        return data.stream()
                .filter(b -> b.getId() == id)
                .findAny();
    }

    @Override
    public void save(Book book) {
        data.add(book);
    }
}
