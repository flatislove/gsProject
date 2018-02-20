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
<hr/>
<form method="post" action="/line/save">
    Id:<br>
    <input type="hidden" name="lineId" value="${lists.lineId}"/>
    <br>
    Line SKU:<br>
    <input type="text" name="lineSKU" value="${lists.lineSKU}"/>
    Line Count:<br>
    <input type="text" name="lineCount" value="${lists.lineCount}"/>
    <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>