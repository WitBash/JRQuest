package com.bashko.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "ServletPlay", value = "/play")
public class ServletPlay extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ServletPlay.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String answer = req.getParameter("answer");

        int count = (Integer) req.getSession().getAttribute("count");

        log.info("Gamer chose variant " + answer + " in " + count + " game");

        switch (answer) {
            case "Принять вызов" -> {
                getServletContext().getRequestDispatcher("/playLevelTwo.jsp").forward(req, resp);
            }
            case "Отклонить вызов" -> {
                req.setAttribute("result", "Ты отклонил вызов.");
                getServletContext().getRequestDispatcher("/playLoss.jsp").forward(req, resp);
            }
            case "Подняться на мостик" -> {
                getServletContext().getRequestDispatcher("/playLevelThree.jsp").forward(req, resp);
            }
            case "Отказаться подниматься на мостик" -> {
                req.setAttribute("result", "Ты не пошел на переговоры.");
                getServletContext().getRequestDispatcher("/playLoss.jsp").forward(req, resp);
            }
            case "Рассказать правду о себе" -> {
                req.setAttribute("result", "Тебя вернули домой.");
                getServletContext().getRequestDispatcher("/playWin.jsp").forward(req, resp);
            }
            case "Солгать о себе" -> {
                req.setAttribute("result", "Твою ложь разоблачили.");
                getServletContext().getRequestDispatcher("/playLoss.jsp").forward(req, resp);
            }
        }
    }
}

