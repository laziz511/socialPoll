<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/fragments/header.css">
</head>

<body>
    <div class="navbar">
        <div class="navbar-container">

            <div class="logo-container">
                <svg fill="none" viewBox="0 0 245 55" width="100"></svg>
                <h1>My Voice</h1>
            </div>

            <div class="navbar-menu">
                <a href="home" class="navbar-menu-element home">Home</a>

                <!-- Show "My polls" link if the user is in session and is an ADMIN -->
                <c:if test="${not empty sessionScope.user and sessionScope.user.role eq 'ADMIN'}">
                    <a href="admin-dashboard" class="navbar-menu-element">My polls</a>
                </c:if>

                <!-- Show "My Submissions" link if there is a user in the session -->
                <c:if test="${not empty sessionScope.user}">
                    <a href="user-polls" class="navbar-menu-element">My Submissions</a>
                </c:if>

                <!-- Show "Log In" link if the user is not in session -->
                <c:if test="${empty sessionScope.user}">
                    <a href="log-in" class="navbar-menu-element">Log In</a>
                </c:if>
            </div>

        </div>
    </div>
</body>

</html>
