<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/24/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }

    h2 {
        color: #333;
    }

    a {
        text-decoration: none;
        color: #3498db;
    }

    a:hover {
        color: #207cca;
    }

    p {
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #e5e5e5;
    }

    td a {
        display: inline-block;
        padding: 5px 10px;
        background-color: #3498db;
        color: white;
        text-decoration: none;
    }

    td a:hover {
        background-color: #207cca;
    }

</style>

<body>
<h2>Danh mục danh mục</h2>
<p>
    <a href="danh_muc?action=add">Thêm mới danh mục</a>
</p>
<table border="1" cellspacing="0">
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>category</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items='${products}' var="item" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${item.productId}</td>
            <td>${item.productName}</td>
            <td>${item.description}</td>
            <td>${item.price}</td>
            <td>${item.quantity}</td>
            <td>${item.category.categoryName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>