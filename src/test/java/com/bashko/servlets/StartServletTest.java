package com.bashko.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class StartServletTest extends Mockito{

    @Test
    void doGet_ShouldForwardNextJsp_WhenRequestParameterNameNotNull() throws ServletException, IOException {

        StartServlet startServlet = new StartServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        ServletConfig servletConfig = mock(ServletConfig.class);
        startServlet.init(servletConfig);
        ServletContext servletContext = mock(ServletContext.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        HttpSession session = mock(HttpSession.class);


        when(request.getSession()).thenReturn(session);
        when(request.getParameter("name")).thenReturn("Vitali");
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher("/playLevelOne.jsp")).thenReturn(requestDispatcher);

        startServlet.doGet(request,response);

        Mockito.verify(requestDispatcher).forward(request,response);
    }

    @Test
    void doGet_ShouldForwardNextJsp_WhenRequestParameterNameNull() throws ServletException, IOException {

        StartServlet startServlet = new StartServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        ServletConfig servletConfig = mock(ServletConfig.class);
        startServlet.init(servletConfig);
        ServletContext servletContext = mock(ServletContext.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        HttpSession session = mock(HttpSession.class);


        when(request.getSession()).thenReturn(session);
        when(request.getParameter("name")).thenReturn(null);
        when(session.getAttribute("name")).thenReturn("Vitali");
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher("/playLevelOne.jsp")).thenReturn(requestDispatcher);

        startServlet.doGet(request,response);

        Mockito.verify(requestDispatcher).forward(request,response);
    }
}