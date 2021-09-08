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
				<h1 class="mt-5" style="text-align: center;">Đăng kí</h1>
				<form action="register" method="POST">
					<div class="form-group">
						<c:choose>
							<c:when test="${status=='faileTenBiTrung'}">
								<div class="alert alert-danger">
									<strong>Faile!</strong> Tên tài khoản đã được sử dụng!
								</div>
							</c:when>
							<c:when test="${status=='faile'}">
								<div class="alert alert-danger">
									<strong>Faile!</strong> Đăng kí thất bại!
								</div>
							</c:when>
						</c:choose>
						<label>Tên tài khoản:</label> <input type="text"
							class="form-control" placeholder="Enter user name"
							name="username" />
					</div>
					<div class="form-group">
						<label>Mật khẩu:</label> <input type="password"
							class="form-control" placeholder="Enter password" name="password" />
					</div>
					<div class="form-group">
						<label>Họ tên:</label> <input type="text" class="form-control"
							placeholder="Enter full name" name="fullName" />
					</div>
					<div class="form-group">
						<label>Số điện thoại:</label> <input type="text"
							class="form-control" placeholder="Enter mobile" name="mobile" />
					</div>
					<div class="form-group">
						<label>Thành phố:</label> <input type="text" class="form-control"
							placeholder="Enter city" name="city" />
					</div>
					<div style="text-align: center; margin-top: 20px;">
						<button type="submit" class="btn btn-success">
							<i class="fas fa-upload"></i> Save
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- FOOTER -->
	<%@ include file="/layout/footer.jsp"%>
	<!-- ------ -->

</body>

</html>