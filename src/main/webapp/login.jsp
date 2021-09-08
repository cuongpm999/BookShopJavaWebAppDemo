<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="description" content="app mua sách">
<meta name="keywords" content="app, mua, sách">
<meta name="author" content="CuongPham">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS & JS -->
<%@ include file="/layout/css_js.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/login.css">
<!-- --- -->

<title>BookShop</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/layout/header.jsp"%>
	<!-- ------ -->

	<div id="main">
		<div class="container">
			<div class="container-form">
				<h1 class="mt-5" style="text-align: center;">Đăng nhập</h1>
				<c:choose>
					<c:when test="${status=='logFaile'}">
						<div class="alert alert-danger">
							<strong>Faile!</strong> Bạn đăng nhập thất bại
						</div>
					</c:when>
				</c:choose>
				<form action="login" method="POST">
					<div class="form-group">
						<label>User name:</label> <input type="text" class="form-control"
							placeholder="Enter user name" name="username">
					</div>
					<div class="form-group">
						<label>Password:</label> <input type="password"
							class="form-control" placeholder="Enter password" name="password">
					</div>
					<div style="text-align: center; margin-top: 20px;">
						<button type="submit" class="btn btn-primary" style="width: 100%;">Login</button>
					</div>
				</form>
				<h5 style="margin-top: 30px; text-align: center;">
					Bạn chưa có tài khoản <br>
					<a href="register">Đăng kí ngay</a>
				</h5>
			</div>
		</div>
	</div>

	<!-- FOOTER -->
	<%@ include file="/layout/footer.jsp"%>
	<!-- ------ -->

</body>

</html>