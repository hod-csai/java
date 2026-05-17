package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String subscribe = request.getParameter("subscribe");
        String comments = request.getParameter("comments");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Form submission received</h3>");
        out.println("<table border='1' cellpadding='6'>");
        out.println(tr("Name", name));
        out.println(tr("Email", email));
        out.println(tr("Age", age));
        out.println(tr("Gender", gender));
        out.println(tr("Country", country));
        out.println(tr("Subscribe", subscribe == null ? "no" : escapeHtml(subscribe)));
        out.println(tr("Comments", comments));
        out.println("</table>");
        out.println("</body></html>");
    }

    private String tr(String label, String value) {
        return "<tr><td><strong>" + escapeHtml(label) + "</strong></td><td>" + (value == null ? "" : escapeHtml(value)) + "</td></tr>";
    }

    private String escapeHtml(String s) {
        return s.replace("&","&amp;")
                .replace("<","&lt;")
                .replace(">","&gt;")
                .replace("\"","&quot;");
    }
}
