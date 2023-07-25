package com.bashko.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PlayServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext servletContext;
    private RequestDispatcher requestDispatcher;
    private PlayServlet playServlet;


    @BeforeEach
    void initializeAll() throws ServletException {
        playServlet = new PlayServlet();

        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        ServletConfig servletConfig = mock(ServletConfig.class);
        playServlet.init(servletConfig);
        servletContext = mock(ServletContext.class);
        requestDispatcher = mock(RequestDispatcher.class);

        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("name")).thenReturn("Vitali");
        when(session.getAttribute("count")).thenReturn(1);

        when(servletConfig.getServletContext()).thenReturn(servletContext);
    }

    @Test
    void doGet_RightAnswerChose_OnFirstQuestion() throws ServletException, IOException {

        when(request.getParameter("answer")).thenReturn("Принять вызов");

        when(servletContext.getRequestDispatcher("/playLevelTwo.jsp")).thenReturn(requestDispatcher);

        playServlet.doGet(request,response);

        Mockito.verify(requestDispatcher).forward(request,response);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Отклонить вызов","Отказаться подниматься на мостик","Солгать о себе"})
    void doGet_ChoseWrongAnswer(String answer) throws ServletException, IOException {

        when(request.getParameter("answer")).thenReturn(answer);

        when(servletContext.getRequestDispatcher("/playLoss.jsp")).thenReturn(requestDispatcher);

        playServlet.doGet(request,response);

        Mockito.verify(requestDispatcher).forward(request,response);
    }

    @Test
    void doGet_RightAnswerChose_OnSecondQuestion() throws ServletException, IOException {

        when(request.getParameter("answer")).thenReturn("Подняться на мостик");

        when(servletContext.getRequestDispatcher("/playLevelThree.jsp")).thenReturn(requestDispatcher);

        playServlet.doGet(request,response);

        Mockito.verify(requestDispatcher).forward(request,response);
    }

    @Test
    void doGet_RightAnswerChose_OnThirdQuestion() throws ServletException, IOException {

        when(request.getParameter("answer")).thenReturn("Рассказать правду о себе");

        when(servletContext.getRequestDispatcher("/playWin.jsp")).thenReturn(requestDispatcher);

        playServlet.doGet(request,response);

        Mockito.verify(requestDispatcher).forward(request,response);
    }
}