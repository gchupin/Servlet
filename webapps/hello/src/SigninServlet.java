package fr.ub.m2.servlet;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(urlPatterns = "/signin")
public class SigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        PrintWriter out = resp.getWriter();
        if (username.isEmpty())
            resp.sendRedirect("signinForm.html");
        String password = req.getParameter("password");
        String lineLogin = username + ";" + password + "\n";
        try {
            Files.write(Paths.get("listLoginFile.txt"), lineLogin.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            // ToDo
        }
        resp.sendRedirect ("index.html");
    }
}