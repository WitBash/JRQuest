package com.bashko.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class QuitGameServletTest {

    @Test
    void doGet_QuitGame() throws ServletException, IOException {

        QuitGameServlet quitGameServlet = new QuitGameServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("name")).thenReturn("Vitali");

        quitGameServlet.doGet(request,response);

        Mockito.verify(session).invalidate();
        Mockito.verify(response).sendRedirect("/");
    }
}