<%--
  Created by IntelliJ IDEA.
  User: Hunter
  Date: 4/22/17
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chesspionage | Profile</title>
    <link href="/resources/css/global.css" rel="stylesheet" />
    <link href="/resources/css/menu.css" rel="stylesheet" />
    <link href="/resources/css/profile.css" rel="stylesheet" />
    <link rel="icon" type="image/png" href="/resources/images/favicon.ico">
</head>
<body>
<div id="menu-container">
    <div class="menu-button" id="back-button" onclick="location.href='/index.jsp'">
        ❮ Back
    </div>
    <h1>hleise</h1>
    <p>Wins: 3 wins</p>
    <p>Losses: 3 losses</p>
    <div class="menu-button" onclick="location.href='/#'">
        Change Username
    </div>
    <div class="menu-button" onclick="location.href='#'">
        Change Password
    </div>
    <div class="menu-button" onclick="location.href='#'">
        Logout
    </div>
    <div class="menu-button alert-button" onclick="location.href='#'">
        Delete Account
    </div>
</div>
</body>
</html>
