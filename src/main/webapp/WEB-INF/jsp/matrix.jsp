<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Matrix</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
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
            <a href="/matrixadd" class="navbar-brand glyphicon glyphicon-plus">Добавить</a>
            <a href="/matrix" class="navbar-brand glyphicon glyphicon-refresh">Обновить</a>
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
        <c:forEach var="matrixList" items="${matrixList}">
            <tr>
                <td>${matrixList.matrixId}</td>
                <c:forEach var="skuList" items="${skuList}">
                    <c:if test="${skuList.skuId==matrixList.matrixSku}">
                        <c:set var="skuName" value="${skuList.skuName}"/>
                        <c:set var="skuCode" value="${skuList.skuCode}"/>
                    </c:if>
                </c:forEach>
                <td>${skuName}</td>
                <td>${skuCode}</td>
                <td>
                    <a href="/matrixdelete/${matrixList.matrixId}" type="button"
                       class="navbar-brand glyphicon glyphicon-trash" data-toggle="#modal" data-target="modal"></a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="container">
    <div class="modal" id="modal">
        <div class="modal-dialog">
            <div class="content">
                <div class="modal-header">
                    <h3>Удаление</h3>
                </div>
                <div class="modal-body">
                    <p>Запись успешно удалена.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                </div>

            </div>
        </div>
    </div>

</div>
</body>
</html>
