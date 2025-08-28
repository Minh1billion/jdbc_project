<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Website</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }

    /* Topbar chính */
    .topbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #333;
        color: #fff;
        padding: 10px 30px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.3);
    }

    /* Link bên trái và phải */
    .topbar-left a, .topbar-right a {
        color: #fff;
        text-decoration: none;
        margin-right: 20px;
        font-weight: 500;
    }

    .topbar-left a:hover, .topbar-right a:hover {
        color: #FFD700; /* màu vàng khi hover */
        text-decoration: underline;
    }

    .topbar-right span {
        margin-right: 10px;
    }

    /* Responsive cơ bản */
    @media screen and (max-width: 768px) {
        .topbar {
            flex-direction: column;
            align-items: flex-start;
        }
        .topbar-left, .topbar-right {
            margin: 5px 0;
        }
    }
</style>
</head>
<body>
    <div class="topbar">
        <div class="topbar-left">
            <a href="<c:url value='/home' />">Trang chủ</a>
            <a href="<c:url value='/products' />">Sản phẩm</a>
            <a href="<c:url value='/about' />">Giới thiệu</a>
            <a href="<c:url value='/contact' />">Liên hệ</a>
        </div>
        <div class="topbar-right">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <span>Xin chào, ${sessionScope.user.name}</span>
                    <a href="<c:url value='/logout' />">Đăng xuất</a>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value='/login' />">Đăng nhập</a>
                    <a href="<c:url value='/register' />">Đăng ký</a>
                </c:otherwise>
            </c:choose>
            <a href="<c:url value='/cart' />">Giỏ hàng (<c:out value="${sessionScope.cart != null ? sessionScope.cart.size() : 0}"/>)</a>
        </div>
    </div>
</body>
</html>
