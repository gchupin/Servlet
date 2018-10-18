package fr.ub.m2.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        String search = req.getParameter("search");
        if (search.isEmpty())
            resp.sendRedirect ("https://ecosia.org/");
        else
            resp.sendRedirect ("https://ecosia.org/search?q=" + search);
    }

}