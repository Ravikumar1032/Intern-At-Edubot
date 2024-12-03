
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Feedback Form</title>
</head>
<body>
    <h2>User Feedback Form</h2>
    
    <c:if test="${not empty errorMessage}">
        <p style="color:red;">${errorMessage}</p>
    </c:if>
    
    <c:if test="${not empty sessionScope.successMessage}">
        <p style="color:green;">${sessionScope.successMessage}</p>
        <c:remove var="successMessage" scope="session"/>
    </c:if>

    <form action="FeedbackServlet" method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br><br>
        
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email"><br><br>
        
        <label for="feedback">Feedback:</label><br>
        <textarea id="feedback" name="feedback"></textarea><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
