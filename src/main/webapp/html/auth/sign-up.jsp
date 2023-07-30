<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

<head>
    <title>Sign-Up Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link href="css/auth/sign-up.css" rel="stylesheet" type="text/css" media="all" />

    <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">

</head>

<body>

    <!-- Include the header -->
    <jsp:include page="../fragments/header.jsp" />

    <!-- main -->
    <section>
        <div class="sign-up-section">
            <div class="form-container">
                <h1>Sign up</h1>

                <form action="sign-up" method="post">
                    <input class="text" type="text" name="Name" placeholder="Name" required="">
                    <input class="text" type="text" name="Surname" placeholder="Surname" required="">
                    <input class="text" type="date" name="birthday" placeholder="Birthday" required="">

                    <div class="text gender-form">
                        <label class="anim">Gender: </label>
                        <label class="radio-inline">
                            <input type="radio" name="gender" value="MALE" required=""> Male
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="gender" value="FEMALE" required=""> Female
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="gender" value="OTHER" required=""> Other
                        </label>
                    </div>

                    <input class="text email" type="email" name="email" placeholder="Email" required="">
                    <%-- Check if there is an error message in the request attributes --%>
                        <% String error=(String) request.getAttribute("error"); %>

                            <%-- Display the error message if it exists --%>
                                <% if (error !=null && !error.isEmpty()) { %>
                                    <p class="error-message">
                                        <%= error %>
                                    </p>
                                    <% } %>

                                        <input class="text password" type="password" name="password"
                                            placeholder="Password" required="">

                                        <input type="checkbox" class="checkbox" required="">
                                        <label for="checkbox">I Agree To The Terms & Conditions</label>
                                        <button type="submit" class="submit">SUBMIT</button>

                </form>
                <p>Already have an Account? <a href="log-in"> Log in!</a></p>
            </div>
        </div>
    </section>
    <!-- //main -->

    <!-- footer start -->
    <jsp:include page="../fragments/footer.jsp" />
    <!-- footer end -->


</body>

</html>