<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa danh mục</title>
</head>
<body>
<h2>Chỉnh sửa danh mục</h2>
<form action="<c:url value='/admin/category/edit' />" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${category.id}" />
    <table>
        <tr>
            <td>Tên danh mục:</td>
            <td><input type="text" name="name" value="${category.name}" required /></td>
        </tr>
        <tr>
            <td>Icon hiện tại:</td>
            <td>
                <c:if test="${category.icon != null}">
                    <img src="/upload/category/${category.icon}" width="50" height="50"/>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Thay icon mới:</td>
            <td><input type="file" name="icon" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Cập nhật</button>
                <a href="<c:url value='/admin/category/list' />">Hủy</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
