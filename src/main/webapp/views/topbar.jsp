<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topbar</title>
<style>
body { font-family: Arial, sans-serif; margin: 0; padding: 0; }

.topbar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background-color: #333;
	color: #fff;
	padding: 10px 30px;
	box-shadow: 0 2px 5px rgba(0,0,0,0.3);
}

.topbar-left, .topbar-right { display: flex; align-items: center; }

.topbar-left a, .topbar-right a, .dropdown-btn {
	color: #fff;
	text-decoration: none;
	margin-right: 20px;
	font-weight: 500;
	cursor: pointer;
}

.topbar-left a:hover, .topbar-right a:hover, .dropdown-btn:hover {
	color: #FFD700;
	text-decoration: underline;
}

.dropdown {
	position: relative;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #444;
	min-width: 150px;
	box-shadow: 0 2px 5px rgba(0,0,0,0.5);
	z-index: 1;
}

.dropdown-content a {
	color: #fff;
	padding: 8px 12px;
	display: block;
	text-decoration: none;
}

.dropdown-content a:hover { background-color: #555; }

.dropdown:hover .dropdown-content { display: block; }

@media screen and (max-width: 768px) {
	.topbar { flex-direction: column; align-items: flex-start; }
	.topbar-left, .topbar-right { margin: 5px 0; flex-direction: column; }
	.topbar-left a, .topbar-right a { margin: 5px 0; }
}
</style>
</head>
<body>
<div class="topbar">
	<div class="topbar-left">
		<a href="<c:url value='/home' />">Trang chủ</a>

		<!-- Dropdown sản phẩm theo category -->
		<div class="dropdown">
			<span class="dropdown-btn">Sản phẩm</span>
			<div class="dropdown-content">
				<c:forEach var="cat" items="${categories}">
					<a href="<c:url value='/products?cateId=${cat.id}' />">${cat.name}</a>
				</c:forEach>
			</div>
		</div>

		<c:if test="${sessionScope.account != null && sessionScope.account.roleid == 1}">
			<div class="dropdown">
				<span class="dropdown-btn">Admin</span>
				<div class="dropdown-content">
					<a href="<c:url value='/admin/category/list' />">Quản lý danh mục</a>
				</div>
			</div>
		</c:if>
	</div>

	<div class="topbar-right">
		<c:choose>
			<c:when test="${sessionScope.account != null}">
				<span>Xin chào, ${sessionScope.account.userName}</span>
				<a href="<c:url value='/logout' />">Đăng xuất</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value='/login' />">Đăng nhập</a>
				<a href="<c:url value='/register' />">Đăng ký</a>
			</c:otherwise>
		</c:choose>

		<a href="<c:url value='/cart' />">Giỏ hàng (<c:out value="${sessionScope.cart != null ? sessionScope.cart.size() : 0}" />)</a>
	</div>
</div>
</body>
</html>
