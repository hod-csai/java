<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<body>
    <form action="FormServlet" method="POST">
        <label>Username: <input type="text" name="username" required></label><br>
        <label>Password: <input type="password" name="password" required></label><br>
        <label>Email: <input type="email" name="email"></label><br>
        <label>Age: <input type="number" name="age" min="0" max="150"></label><br>
        <label>Gender:
            <select name="gender">
                <option value="">--</option>
                <option>Male</option>
                <option>Female</option>
                <option>Other</option>
            </select>
        </label><br>
        <label>Country: <input type="text" name="country"></label><br>
        <label>Subscribe to newsletter: <input type="checkbox" name="subscribe" value="yes"></label><br>
        <label>Comments:<br>
            <textarea name="comments" rows="4" cols="40"></textarea>
        </label><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
