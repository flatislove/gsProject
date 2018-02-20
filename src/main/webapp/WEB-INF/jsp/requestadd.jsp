<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Matrix</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script> $('#makeEditable').SetEditable({$addButton: $('#but_add')});</script>
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
            <a href="/request/export" class="navbar-brand glyphicon glyphicon-print"> Печать</a>
            <a href="/request/send" class="navbar-brand glyphicon glyphicon-send"> Отправить</a>
            <a href="/request/save/${createdRequestList}" class="navbar-brand glyphicon glyphicon-floppy-disk">
                Сохранить</a>
        </ul>
    </nav>
    <table class="table table-sm table-hover">
        <thead class="thead-dark">
        <tr>
            <th>Наименование</th>
            <th>Штрихкод</th>
            <th>Количество</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="createdRequestList" items="${createdRequestList}">
            <tr>
                <c:forEach var="skuList" items="${skuList}">
                    <c:if test="${skuList.skuId==createdRequestList.requestSku}">
                        <c:set var="skuName" value="${skuList.skuName}"/>
                        <c:set var="skuCode" value="${skuList.skuCode}"/>
                    </c:if>
                </c:forEach>
                <td>${skuName}</td>
                <td>${skuCode}</td>
                <td contenteditable='true'>${createdRequestList.requestCount}</td>

                <td>
                        <%--<a href="//${createdRequestList.requestId}" class="navbar-brand glyphicon glyphicon-ok"></a>--%>
                        <a href="/requestedit/${createdRequestList.requestId}"class="navbar-brand glyphicon glyphicon-pencil" ></a>
                    <a href="/requestdelete/${createdRequestList.requestId}"
                       class="navbar-brand glyphicon glyphicon-trash"></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>
