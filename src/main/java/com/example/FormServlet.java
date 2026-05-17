package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = safe(req.getParameter("username"));
        String password = req.getParameter("password"); // do not display raw
        String email = safe(req.getParameter("email"));
        String age = safe(req.getParameter("age"));
        String gender = safe(req.getParameter("gender"));
        String country = safe(req.getParameter("country"));
        String subscribe = req.getParameter("subscribe") != null ? "yes" : "no";
        String comments = safe(req.getParameter("comments"));

        // store a simple representation in application scope
        @SuppressWarnings("unchecked")
        List<String> users = (List<String>) getServletContext().getAttribute("registeredUsers");
        if (users == null) {
            users = new CopyOnWriteArrayList<>();
            getServletContext().setAttribute("registeredUsers", users);
        }

        String rec = "User: " + username + ", Email: " + email + ", Age: " + age + ", Gender: " + gender + ", Country: " + country + ", Subscribed: " + subscribe;
        users.add(rec);

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><body>");
            out.println("<h2>Registration successful</h2>");
            out.println("<p>Thank you, " + username + "</p>");
            out.println("<ul>");
            out.println("<li>Email: " + email + "</li>");
            out.println("<li>Age: " + age + "</li>");
            out.println("<li>Gender: " + gender + "</li>");
            out.println("<li>Country: " + country + "</li>");
            out.println("<li>Subscribed: " + subscribe + "</li>");
            out.println("</ul>");

            out.println("<h3>Registered users</h3>");
            out.println("<ol>");
            for (String u : users) {
                out.println("<li>" + u + "</li>");
            }
            out.println("</ol>");

            out.println("<p><a href=\"index.jsp\">Back</a></p>");
            out.println("</body></html>");
        }
    }

    private String safe(String s) {
        if (s == null) return "";
        return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;").replace("\"","&quot;");
    }
}
