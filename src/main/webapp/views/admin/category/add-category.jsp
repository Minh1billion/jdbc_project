<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm danh mục</title>
</head>
<body>
    <h2>Thêm danh mục mới</h2>
    <form action="<c:url value='/admin/category/add' />" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Tên danh mục:</td>
                <td><input type="text" name="name" required /></td>
            </tr>
            <tr>
                <td>Icon:</td>
                <td><input type="file" name="icon" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Thêm danh mục</button>
                    <a href="<c:url value='/admin/category/list' />">Hủy</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
