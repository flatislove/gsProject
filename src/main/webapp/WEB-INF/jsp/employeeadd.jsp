<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>Add Employee</title>
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
            <a href="/employeeindex" class="navbar-brand glyphicon glyphicon-chevron-left"> Назад</a>
        </ul>
    </nav>
    <div class="container">
        <form class="form-horizontal" method="post" action="/save">
            <div class="form-group">
                <input type="hidden" class="form-control" name="employeeId" value="">
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Имя:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="Введите имя" name="firstname">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Фамилия:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="Введите фамилию" name="lastname">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Должность:</label>
                <select name="employeePosition" class="col-sm-10">
                    <c:forEach var="list" items="${positionList}">
                        <option value="${list.positionId}">${list.positionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Email:</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" placeholder="Введите email" name="email">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Пароль:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" placeholder="Введите пароль" name="password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Сохранить</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>