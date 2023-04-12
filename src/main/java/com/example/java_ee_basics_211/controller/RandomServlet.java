package com.example.java_ee_basics_211.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "randomServlet", value = "/random")
public class RandomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("random", new Random());

        RequestDispatcher dispatcher = req.getRequestDispatcher("random.jsp");
        dispatcher.forward(req, resp);
    }
}
