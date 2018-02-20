<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>Selling View</title>
    <style>
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
        body {
            background-color: #D7D1D1;
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
            <a href="/selling/view/${list.sellingDate}" class="navbar-brand glyphicon glyphicon-chevron-left"> Назад</a>
        </ul>
    </nav>
    <table class="table table-hover">
        <tr>
            <th>Учетный номер</th>
            <td>${list.sellingId}</td>
        </tr>
        <tr>
            <th>Дата</th>
            <td>${list.sellingDate}</td>
        </tr>
        <tr>
            <th>Наименование</th>
            <td>${sku.skuName}</td>
        </tr>
        <tr>
            <th>Количество</th>
            <td>${list.sellingCount}</td>
        </tr>
    </table>
</div>

</body>
</html>
