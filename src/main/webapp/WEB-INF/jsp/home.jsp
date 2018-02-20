<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: #D7D1D1;
        }
        .statistic-text {
            font-family: Lobster;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="position-cred">
    <div class="navbar navbar-inverse">
        <div class="container">
            <nav>
                <form class="navbar-form navbar-left">
                    <%--<a (click)="appToAccount()" class="navbar-brand"> Account</a>--%>
                    <a href="/home" class="navbar-brand glyphicon glyphicon-home"> Главная</a>
                    <a href="/request" class="navbar-brand glyphicon glyphicon-file"> Формирование заявки</a>
                    <a href="/dbeditadmin" class="navbar-brand glyphicon glyphicon-briefcase"> Данные</a>
                    <a href="/matrix" class="navbar-brand glyphicon glyphicon-list-alt"> Матрица наименований</a>
                    <a href="/selling" class="navbar-brand glyphicon glyphicon-import"> Внести продажи</a>
                </form>
            </nav>
        </div>
    </div>
    <div class="container statistic-text">
        <h1>ОАО "АФПК "Жлобинский мясокомбинат"</h1>
        <h2>г.Жлобин</h2>
    </div>
    <div class="statistic-text">
        <div><h4>Точность последней автоматически сформированной заявки: ${lastDayStatistic}%</h4></div>
        <br>
        <div><h4>Точность за все время: ${allTimeStatistic}%</h4></div>
    </div>
</div>
</div>
</body>
</html>