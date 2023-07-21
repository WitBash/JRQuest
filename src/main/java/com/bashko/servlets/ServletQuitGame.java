package com.bashko.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "ServletQuitGame", value = "/playQuit")
public class ServletQuitGame extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletQuitGame.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getSession().getAttribute("name").toString();
        req.getSession().invalidate();

        log.info("Session closed. Gamer with name " + name + " left game");

        resp.sendRedirect("/");
    }
}
