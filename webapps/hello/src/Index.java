package fr.ub.m2.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = "/index")
public class LoginServlet extend HttpServlet {
    @Override
    protected void do_get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IoException {
        String username = Session.getAttribute ());
    }