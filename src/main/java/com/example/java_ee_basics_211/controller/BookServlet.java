package com.example.java_ee_basics_211.controller;

import com.example.java_ee_basics_211.dao.BookDao;
import com.example.java_ee_basics_211.dao.DatabaseBookDaoImpl;
import com.example.java_ee_basics_211.dao.SimpleBookDaoImpl;
import com.example.java_ee_basics_211.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookServlet", value = "/books")
public class BookServlet extends HttpServlet {
    private final BookDao dao = new DatabaseBookDaoImpl(
            "jdbc:postgresql://localhost:5432/books_store", "postgres", "1");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("books/all_books.jsp");
        req.setAttribute("allBooks", dao.getAll());
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));

        Book book = new Book(name, author, price);
        dao.save(book);
        resp.sendRedirect("/books");
    }
}
