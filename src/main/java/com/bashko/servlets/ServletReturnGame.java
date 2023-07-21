package com.bashko.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "ServletReturnGame", value = "/playReturn")
public class ServletReturnGame extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletReturnGame.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getSession().getAttribute("name").toString();
        int count = (Integer) req.getSession().getAttribute("count");

        log.info("Gamer " + name + " wants refresh his game in " + count + " times");

        resp.sendRedirect("/start");
    }
}
