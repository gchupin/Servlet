package fr.ub.m2.servlet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.*;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (isLoginValid(username, password)) {
            HttpSession currentSession = req.getSession();
            currentSession.setAttribute ("USER", username);
            resp.sendRedirect ("mainPage");
        }else
            resp.sendRedirect ("InvalidLogin.html");
    }

    public boolean isLoginValid(String username, String password) {
        String currentLoginLine = username + ";" + password;
        try {
            List<String> allLoginLines = Files.readAllLines(Paths.get ("listLoginFile.txt"), StandardCharsets.UTF_8);
            for (String loginLine : allLoginLines)
                if (currentLoginLine.equals(loginLine))
                    return true;
            return false;
        } catch (IOException e) {
            return false;
        }
    }
}