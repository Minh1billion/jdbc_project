<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách danh mục</title>
</head>
<body>
    <h2>Danh sách danh mục</h2>

    <!-- Nút thêm danh mục mới -->
    <a href="<c:url value='/admin/category/add' />">Thêm danh mục mới</a>

    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên danh mục</th>
                <th>Icon</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${categories}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.name}</td>
                    <td>${c.icon}</td>
                    <td>
                        <a href="<c:url value='/admin/category/edit?id=${c.id}' />">Sửa</a> |
                        <a href="<c:url value='/admin/category/delete?id=${c.id}' />"
                           onclick="return confirm('Bạn có chắc muốn xóa danh mục này?');">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
