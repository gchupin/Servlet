package fr.ub.m2.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/mainPage")
public class MainServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("USER");
        if (userName != null) {
            resp.setContentType("text/html");
            ServletOutputStream out = resp.getOutputStream();
            out.println("<html><body><h1>");
            out.println("Hello, " + userName + "! ");
            out.println("</h1></body></html>");
            out.println ("<form action=logout method=GET>");
            out.println ("<input type=submit value=deconexion/></form>");
        } else {
            resp.sendRedirect("loginForm.html");
        }
    }
}