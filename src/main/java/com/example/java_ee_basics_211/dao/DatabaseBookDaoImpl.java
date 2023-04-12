package com.example.java_ee_basics_211.dao;

import com.example.java_ee_basics_211.model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DatabaseBookDaoImpl implements BookDao {
    private final String url;
    private final String user;
    private final String password;


    public DatabaseBookDaoImpl(String url, String user, String password) {
        try {
            //Загрузить класс в JVM
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Book> getAll() {
        try(Connection cnn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM books";
            Statement statement = cnn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Book> result = new ArrayList<>();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                Book book = new Book(name, author, price);
                book.setId(id);
                result.add(book);
            }
            return result;

        } catch(SQLException ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public Optional<Book> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Book book) {
        try(Connection cnn = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO books(name, author, price) VALUES(?, ?, ?)";
            PreparedStatement statement = cnn.prepareStatement(query);
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setDouble(3, book.getPrice());
            statement.executeUpdate();
            cnn.commit();


        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}
