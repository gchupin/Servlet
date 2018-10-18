package fr.ub.m2.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extend HttpServlet {
    @Override
    protected void do_get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IoException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IoException {
        String username = req.getParameter ("username");
        String password = req.getParameter ("password");

        if (isLoginValid (username, password))
        {   HttpSession currentSession = req.getSession ();
            currentSession.setAttribute ("User", username);
            currentSession.setAttribute ("Password", password);
            response.sendRedirect ("Index")
        }
    }
}