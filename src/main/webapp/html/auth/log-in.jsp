<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Log-in Page </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link href="css/auth/log-in.css" rel="stylesheet" type="text/css" media="all" />

    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">

</head>

<body>


    <!-- Include the header -->
    <jsp:include page="../fragments/header.jsp"/>

    <!-- main -->
    <section>
        <div class="main-section">
            <div class="form-container">
                <h1>Log in</h1>

                <%-- Check if there is an error message in the request attributes --%>
                <% String error = (String) request.getAttribute("error"); %>

                <%-- Display the error message if it exists --%>
                <% if (error != null && !error.isEmpty()) { %>
                    <p class="error-message"><%= error %></p>
                <% } %>

                <form action="log-in" method="post">
                    <input class="text email" type="email" name="email" placeholder="Email" required="">
                    <input class="text password" type="password" name="password" placeholder="Password" required="">
                    <button type="submit" class="submit">LOGIN</button>
                </form>

                <p>Don't have an Account yet? <a href="sign-up"> Sign Up!</a></p>
            </div>
        </div>
    </section>
    <!-- //main -->


            <!-- footer start -->
            <jsp:include page="../fragments/footer.jsp"/>
                <!-- footer end -->

</body>

</html>