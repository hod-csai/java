package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Cookie c = new Cookie("user", "admin");
        c.setPath("/");
        response.addCookie(c);

        out.println("Cookie set successfully.<br>");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie ck : cookies) {
                out.println("Found Cookie: " + ck.getName() + " = " + ck.getValue() + "<br>");
            }
        }
    }
}
