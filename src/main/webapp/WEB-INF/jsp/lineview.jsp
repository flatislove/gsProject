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
        <th>ID</th>
        <td>${lists.lineId}</td>
    </tr>
    <tr>
        <th>Line SKU</th>
        <td>${lists.lineSKU}</td>
    </tr>
    <tr>
        <th>Line Count</th>
        <td>${lists.lineCount}</td>
    </tr>
</table>
<a href="/line"> Back</a>
</body>
</html>