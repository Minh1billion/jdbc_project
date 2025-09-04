<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="forgot-password" method="post">
		<h2>Quên mật khẩu</h2>
		<c:if test="${alert != null}">
			<div class="alert">${alert}</div>
		</c:if>
		<input type="email" name="email" placeholder="Nhập email đã đăng ký"
			required> <input type="password" name="newPassword"
			placeholder="Mật khẩu mới" required>
		<button type="submit">Đặt lại mật khẩu</button>
	</form>
</body>
</html>