<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>
        Employee
    </title>
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

        tr:nth-child(even) {
            background-color: #dddddd;
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
            <a href="/dbeditadmin" class="navbar-brand glyphicon glyphicon-chevron-left"> Назад</a>
            <a href="/employeeadd" class="navbar-brand glyphicon glyphicon-plus"> Добавить</a>
            <a href="/employeeindex" class="navbar-brand glyphicon glyphicon-refresh"> Обновить</a>

        </ul>
    </nav>

    <table class="table table-hover">
        <tr>
            <th>Пользователь</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Должность</th>
            <th>Email</th>
            <th>Действие</th>
        </tr>
        <c:forEach var="list" items="${lists}">
            <tr>
                <td>${list.employeeId}</td>
                <td>${list.firstname}</td>
                <td>${list.lastname}</td>
                <c:forEach var="positionList" items="${positionList}">
                    <c:if test="${positionList.positionId==list.employeePosition}">
                        <c:set var="positionText" value="${positionList.positionName}"/>
                    </c:if>
                </c:forEach>
                <td>${positionText}</td>
                <td>${list.email}</td>
                <td>
                    <a href="/view/${list.employeeId}" class="navbar-brand glyphicon glyphicon-eye-open"></a>
                    <a href="/delete/${list.employeeId}" class="navbar-brand glyphicon glyphicon-trash"></a>
                    <a href="/edit/${list.employeeId}" class="navbar-brand glyphicon glyphicon-pencil"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>