<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>Add Matrix</title>
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
    <form method="post" action="/matrixsave">
        Наименование:<br>
        <%--<option value="${positionList.positionName}"></option>">--%>
        <input type="hidden" name="matrixId" value=""/>
        <input type="hidden" name="matrixSeller" value="102"/>

        <select name="matrixSku">
            <c:forEach var="skuList" items="${skuList}">
                <option value="${skuList.skuId}">${skuList.skuName}</option>
            </c:forEach>
        </select><br>
        <br><br>
        <input type="submit" class="btn btn-primary" value="Сохранить">
    </form>
</div>
</body>
</html>
