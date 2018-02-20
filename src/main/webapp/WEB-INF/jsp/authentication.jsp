<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>Authentication</title>
    <style>
        body {
            background-color: #D7D1D1;
        }

        .wrapper {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 400px;
            margin-top: 150px;
            margin-left: 450px;
        }
    </style>
</head>
<body onload='document.loginForm.username.focus();'>
<div class="wrapper">
    <div class="container nav-brand">
        <c:if test="${not empty error}">
            <div>${error}</div>
        </c:if>
        <c:if test="${not empty message}">
            <div>${message}</div>
        </c:if>
    </div>

    <form class="form-signin" name='login' action="<c:url value='/login' />" method='POST'>
            <tr class="nav-brand">
                <td>Логин:</td>
                <td><input type='text' class="form-control" name='username' value=''></td>
            </tr>
            <tr>
                <td>Пароль:</td>
                <td><input type='password' class="form-control" name='password'/></td>
                <br>
            </tr>

            <tr>
                <td colspan='2'><input name="submit" type="submit" class="btn btn-lg btn-primary btn-block"
                                       value="Войти"/></td>
            </tr>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</body>
</html>