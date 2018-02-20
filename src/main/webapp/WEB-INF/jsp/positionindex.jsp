<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>
        Position
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
            <a href="/positionadd" class="navbar-brand glyphicon glyphicon-plus"> Добавить</a>
            <a href="/position" class="navbar-brand glyphicon glyphicon-refresh"> Обновить</a>

        </ul>
    </nav>

    <table class="table table-hover">
        <tr>
            <th>Номер</th>
            <th>Должность</th>
            <th>Действие</th>
        </tr>
        <c:forEach var="list" items="${lists}">
            <tr>
                <td>${list.positionId}</td>
                <td>${list.positionName}</td>
                <td>
                    <a href="position/view/${list.positionId}" class="navbar-brand glyphicon glyphicon-eye-open"></a>
                    <a href="position/delete/${list.positionId}" class="navbar-brand glyphicon glyphicon-trash"></a>
                    <a href="position/edit/${list.positionId}" class="navbar-brand glyphicon glyphicon-pencil"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>