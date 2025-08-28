<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .alert { color: red; }
        form { max-width: 400px; margin: 50px auto; }
        input { display: block; width: 100%; padding: 10px; margin: 10px 0; }
        button { padding: 10px; width: 100%; }
    </style>
</head>
<body>

<form action="register" method="post">
    <h2>Đăng ký tài khoản mới</h2>

    <c:if test="${alert != null}">
        <div class="alert">${alert}</div>
    </c:if>

    <input type="text" name="username" placeholder="Tài khoản" required>
    <input type="password" name="password" placeholder="Mật khẩu" required>
    <input type="email" name="email" placeholder="Email" required>
    <input type="text" name="fullname" placeholder="Họ và tên" required>
    <input type="text" name="phone" placeholder="Số điện thoại" required>

    <button type="submit">Đăng ký</button>

    <p style="text-align:center; margin-top:10px;">
        Bạn đã có tài khoản? <a href="login">Đăng nhập</a>
    </p>
</form>

</body>
</html>
