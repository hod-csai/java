<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<body>
    <form method="POST">
        Name: <input type="text" name="uname">
        <input type="submit" value="Submit">
    </form>
    
    <%
        String name = request.getParameter("uname");
        if (name != null && !name.trim().isEmpty()) {
            out.println("Submitted Name: " + name);
        }
    %>
</body>
</html>
