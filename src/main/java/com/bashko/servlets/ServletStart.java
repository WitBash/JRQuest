package com.bashko.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "ServletStart", value = "/start")
public class ServletStart extends HttpServlet {
    private final int START_COUNT_GAME = 0;
    private int countGame;
    private HttpSession session;
    private String name;

    private static final Logger log = LoggerFactory.getLogger(ServletStart.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        session = req.getSession();
        name = req.getParameter("name");
        if (name == null) {
            name = session.getAttribute("name").toString();

            log.info("Gamer with name: " + name + " refreshed his game in " + countGame + " times");

            session.setAttribute("name", name);
            session.setAttribute("count", ++countGame);
        } else {
            log.info("New gamer: " + name + " started game");

            session.setAttribute("name", name);
            countGame = START_COUNT_GAME;
            session.setAttribute("count", ++countGame);
        }
        getServletContext().getRequestDispatcher("/playLevelOne.jsp").forward(req, resp);
    }
}
