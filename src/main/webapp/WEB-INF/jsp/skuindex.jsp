<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SKU Index</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <style>
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
            <a href="/dbeditadmin" class="navbar-brand glyphicon glyphicon-chevron-left"> Назад</a>
            <a href="/skuadd" class="navbar-brand glyphicon glyphicon-plus"> Добавить</a>
            <a href="/skuindex" class="navbar-brand glyphicon glyphicon-refresh"> Обновить</a>
        </ul>
    </nav>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Наименование</th>
            <th>Штрихкод</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.skuId}</td>
                <td>${list.skuName}</td>
                <td>${list.skuCode}</td>
                <td>
                    <a href="/sku/delete/${list.skuId}" class="navbar-brand glyphicon glyphicon-trash linkstyle"> </a>
                    <a href="/sku/view/${list.skuId}" class="navbar-brand glyphicon glyphicon-eye-open linkstyle"> </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
