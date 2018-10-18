package fr.ub.m2.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/world")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String parameterValue = req.getParameter("name");
        out.println("<html>");
        out.println("<body>");
        out.print("Hello ");
        out.println(parameterValue);
        printHeaders(req, out);
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        if (!(name.isEmpty()))
            req.getSession().setAttribute("name", name);
        if (name.isEmpty())
            name = (String) req.getSession().getAttribute("name");
        if (name.equals("Julien"))
            out.println("La vie de moi t'est tros beau putain");
        else
            out.println ("Hello " + name + " !");
    }

    private void printHeaders(HttpServletRequest req, PrintWriter out) {
        out.println("<b>Request Method: </b>" + req.getMethod() + "<br/>");
        out.println("<b>Request URI: </b>" + req.getRequestURI() + "<br/>");
        out.println("<b>Request Protocol: </b>" + req.getProtocol() + "<br/><br/>");
        out.println("<table><thead>\n");
        out.println("\t<tr>\n<th>Header Name</th><th>Header Value</th></tr>\n");
        out.println("</thead><tbody>");
        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.println("\t<tr>\n\t\t<td>" + headerName + "</td>");
            out.println("<td>" + req.getHeader(headerName) + "</td>\n");
            out.println("\t</tr>\n");
        }
        out.println("</tbody></table>");
    }

}
