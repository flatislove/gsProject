<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <title>Request View</title>
    <style> body {
        background-color: #D7D1D1;
    }</style>
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
            <a href="/request" class="navbar-brand glyphicon glyphicon-chevron-left">Назад</a>
            <a href="/request/export/${requestId}" class="navbar-brand glyphicon glyphicon-print"> Печать</a>
            <%--<a href="/send/letter" class="navbar-brand glyphicon glyphicon-send"> Отправить</a>--%>
        </ul>
    </nav>
    <div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Номер</th>
                <th>Номер магазина</th>
                <th>Магазин</th>
                <th>Дата формирования</th>
            </tr>

            </thead>
            <tbody>
            <tr>
                <td>${retId}</td>
                <c:forEach var="requestList" items="${requestList}">
                    <c:if test="${requestList.requestId==retId}">
                        <c:set var="reqSeller" value="${requestList.requestSeller}"/>
                    </c:if>
                </c:forEach>
                <td>${reqSeller}</td>
                <c:forEach var="sellerList" items="${sellerList}">
                    <c:if test="${reqSeller==sellerList.sellerId}">
                        <c:set var="SelName" value="${sellerList.sellerName}"/>
                    </c:if>
                </c:forEach>
                <td>${SelName}</td>
                <c:forEach var="requestList" items="${requestList}">
                    <c:if test="${retId==requestList.requestId}">
                        <c:set var="ReqDate" value="${requestList.requestDate}"/>
                    </c:if>
                </c:forEach>
                <td><fmt:formatDate value="${ReqDate}" pattern="dd-MM-yyyy"/></td>
            </tr>
            </tbody>
        </table>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Наименование</th>
            <th>Количество</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="requestList" items="${requestList}">
            <tr>
                <c:if test="${requestList.requestId==retId}">
                    <c:forEach var="skuList" items="${skuList}">
                        <c:if test="${requestList.requestSku==skuList.skuId}">
                            <c:set var="SkuName" value="${skuList.skuName}"/>
                        </c:if>
                    </c:forEach>
                    <td>${SkuName}</td>
                    <td>${Math.round(requestList.requestCount)}</td>
                    <td>
                        <a href="request/edit/${requestList.reqId}" class="navbar-brand glyphicon glyphicon-pencil"></a>
                    </td>
                </c:if>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
