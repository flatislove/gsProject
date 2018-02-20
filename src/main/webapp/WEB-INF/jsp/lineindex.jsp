<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        Spring Boot Application
    </title>
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

    </style>
</head>
<body>
<table class="table table-hover">
    <tr>
        <th>LineId</th>
        <th>LineSKU</th>
        <th>LineCount</th>
        <th>Action</th>
    </tr>
    <c:forEach var="list" items="${lists}">
        <tr>
            <td>${list.lineId}</td>
            <td>${list.lineSku}</td>
            <td>${list.lineCount}</td>
            <td>
                <a href="line/view/${list.lineId}">View</a>
                <a href="line/delete/${list.lineId}">Delete</a>
                <a href="line/edit/${list.lineId}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr/>
<form method="post" action="/line/save">
    <input type="hidden" name="lineId" value=""/>
    Line SKU:<br>
    <input type="text" name="lineSku"/>
    <br>
    Line Count:<br>
    <input type="text" name="lineCount"/>
    <br><br>
    <input type="submit" value="submit">
</form>
</body>
</html>