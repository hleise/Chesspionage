<%--
  Created by IntelliJ IDEA.
  User: Hunter
  Date: 4/19/17
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Controllers.HelloWorld" %>
<%@ page import="Controllers.Language" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
    <p class="message">English: <%=HelloWorld.greeting(Language.English)%></p>
    <p class="message">Spanish: <%=HelloWorld.greeting(Language.Spanish)%></p>
    <p class="message">Italian: <%=HelloWorld.greeting(Language.Italian)%></p>
    <p class="message">Vietnamese: <%=HelloWorld.greeting(Language.Vietnamese)%></p>
</body>
</html>
