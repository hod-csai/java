<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<body>
    <!-- Instantiate the bean -->
    <jsp:useBean id="user" class="com.example.UserBean" />
    
    <!-- Set a property -->
    <jsp:setProperty name="user" property="name" value="Alice" />
    
    <!-- Get and display the property -->
    <h2>Hello, <jsp:getProperty name="user" property="name" />!</h2>
</body>
</html>