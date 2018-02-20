<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        Employee Edit
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #D7D1D1;
        }
        table {
            font-family: Arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

    </style>
</head>
<body>
<div class="navbar navbar-inverse">
    <div class="container">
        <nav>
            <form class="navbar-form navbar-left">
                <a href="/home" class="navbar-brand glyphicon glyphicon-home"> Главная</a>
                <a href="/request" class="navbar-brand glyphicon glyphicon-file"> Формирование заявки</a>
                <a href="/dbeditadmin" class="navbar-brand glyphicon glyphicon-briefcase"> Данные</a>
                <a href="/matrix" class="navbar-brand glyphicon glyphicon-list-alt"> Матрица наименований</a>
                <a href="/selling" class="navbar-brand glyphicon glyphicon-import"> Внести продажи</a>
            </form>
        </nav>
    </div>
</div>
<div class="container">
    <nav class="navmenu navmenu-default navmenu-fixed-left offcanvas" role="navigation">
        <ul class="nav navmenu-nav">
            <a href="/employeeindex" class="navbar-brand glyphicon glyphicon-chevron-left"> Назад</a>
        </ul>
    </nav>
    <form method="post" action="/save">
        Id:<br>
        <input type="hidden" name="employeeId" value="${lists.employeeId}"/>
        <br>
        Имя:<br>
        <input type="text" name="firstname" value="${lists.firstname}"/>
        <br>
        Фамилия:<br>
        <input type="text" name="lastname" value="${lists.lastname}"/>
        <br>
        Должность:<br>
        <input type="text" name="employeePosition" value="${lists.employeePosition}"/>
        <br>
        Email:<br>
        <input type="text" name="email" value="${lists.email}"/>
        <br>
        Password:<br>
        <input type="text" name="password" value="${lists.password}"/>
        <br>
        <input type="submit" class="btn btn-primary" value="Сохранить">
    </form>
</div>
</body>
</html>