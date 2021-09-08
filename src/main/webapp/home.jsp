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
<!-- --- -->

<title>BookShop</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/layout/header.jsp"%>
	<!-- ------ -->


	<!-- MAIN  -->
	<div id="banner">
		<div id="demo" class="carousel slide" data-ride="carousel">

			<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
				<li data-target="#demo" data-slide-to="2"></li>
			</ul>

			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="${pageContext.request.contextPath}/static/img/banner1.jpg"
						alt="Banner">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/static/img/banner2.jpg"
						alt="Banner">
				</div>
				<div class="carousel-item">
					<img
						src="${pageContext.request.contextPath}/static/img/banner3.jpg"
						alt="Banner">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="carousel-control-prev" href="#demo" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#demo" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>

		</div>
	</div>

	<!-- MAIN -->
	<div id="main">
		<div class="container">
			<h3 class="tieu-de" style="margin-top: 20px; text-align: center;">SẢN
				PHẨM</h3>

			<div class="row">
				<c:forEach var="product" items="${listBook }">
					<div class="col-md-3">
						<a href="book-detail?id=${product.id }"><img
							src="${pageContext.request.contextPath}/static/upload/${product.img }"
							alt="product"></a>
						<div class="infor" style="text-align: center;">
							<a href="book-detail?id=${product.id }">
								<h6>${product.name }</h6>
							</a>
							<div class="price-buy">
								<p>
									<fmt:formatNumber type="number" maxFractionDigits="3"
										value="${product.price }" />
									Đ
								</p>
								<a href="buy?id=${product.id }"><i
									class="fas fa-shopping-cart"></i>&nbsp;Mua ngay</a>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>


		</div>

	</div>
	<!-- --- -->

	<!-- FOOTER -->
	<%@ include file="/layout/footer.jsp"%>
	<!-- ------ -->


</body>

</html>