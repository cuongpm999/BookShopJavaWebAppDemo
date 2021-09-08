<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	href="${pageContext.request.contextPath}/static/css/product_detail.css">
<!-- --- -->

<title>BookShop</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/layout/header.jsp"%>
	<!-- ------ -->

	<div id="main">
		<div class="container mt-5">
			<div class="item-detail">
				<div class="row">
					<div class="col-md-5">
						<img
							src="${pageContext.request.contextPath}/static/upload/${product.img }"
							alt="product">
						<div class="list-img">
							<img
								src="${pageContext.request.contextPath}/static/upload/${product.img }"
								alt="product">
						</div>
					</div>
					<div class="col-md-7">
						<h4 class="text-uppercase">${product.name }</h4>
						<table class="table table-hover">
							<tbody>
								<tr>
									<td>Tác giả</td>
									<td>${product.author }</td>
								</tr>
								<tr>
									<td>Năm XB</td>
									<td>${product.year }</td>
								</tr>
								<tr>
									<td>Giá</td>
									<td><h5><fmt:formatNumber type="number" maxFractionDigits="3"
										value="${product.price }" /> Đ</h5></td>
								</tr>
							</tbody>
						</table>
						
						<div class="btn-buy">
							<a href="buy?id=${product.id }" class="btn btn-warning"
								style="width: 100%; margin-bottom: 10px;">Mua ngay</a>
						</div>
					</div>
				</div>
			</div>

		</div>

	</div>
	<!-- ------ -->

	<!-- FOOTER -->
	<%@ include file="/layout/footer.jsp"%>
	<!-- ------ -->


</body>

</html>