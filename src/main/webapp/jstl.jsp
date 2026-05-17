<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <c:set var="myVariable" value="Hello JSTL World!" />
    
    <h2><c:out value="${myVariable}" /></h2>
</body>
</html>
