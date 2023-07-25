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

class ReturnGameServletTest {

    @Test
    void doGet_ReturnGame() throws ServletException, IOException {

        ReturnGameServlet returnGameServlet = new ReturnGameServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("name")).thenReturn("Vitali");
        when(session.getAttribute("count")).thenReturn(1);

        returnGameServlet.doGet(request,response);

        Mockito.verify(response).sendRedirect("/start");
    }
}