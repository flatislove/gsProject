
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>Request Edit</title>
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
            <a href="/requestmainview/${request.requestId}" class="navbar-brand glyphicon glyphicon-chevron-left"> Назад</a>
        </ul>
    </nav>
    <hr/>
    <form method="post" action="/requestmainedit/save">

        <input type="hidden" name="reqId" value="${request.reqId}"/>
        <input type="hidden" name="requestId" value="${request.requestId}">
        Количество:<br>
        <input type="text" name="requestCount" required pattern="^[ 0-9]+$" value="${request.requestCount}"/>
        <br><br>
        <input type="submit" class="btn btn-primary" value="Сохранить">
    </form>
</div>
</body>
</html>
