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
	href="${pageContext.request.contextPath}/static/css/cart.css">
<!-- --- -->

<title>BookShop</title>
</head>

<body>
	<!-- HEADER -->
	<%@ include file="/layout/header.jsp"%>
	<!-- ------ -->

	<!-- MAIN -->
	<div id="main">
		<div class="container mt-5">
			<div class="row">
				<div class="col-md-12">
					<c:choose>
						<c:when test="${status=='faile'}">
							<div class="alert alert-danger">
								<strong>Faile!</strong> Đặt hàng thất bại!
							</div>
						</c:when>
					</c:choose>
					<table class="table list-sp" style="background-color: white;">
						<thead class="thead-light">
							<tr>
								<th>Sản phẩm</th>
								<th>Giá</th>
								<th>Số lượng</th>
								<th>Thành tiền</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cart_" items="${giohang.boughtBookItems }">
								<tr>
									<td class="san-pham"><a href="javascript:void(0);"
										style="margin-right: 10px"><img
											src="${pageContext.request.contextPath}/static/upload/${cart_.bookItem.img }"
											alt="product"></a><a href="javascript:void(0);">
											<h6>${cart_.bookItem.name }</h6>
									</a></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="3"
											value="${cart_.bookItem.price }" /> Đ</td>
									<td>${cart_.amount }</td>
									<td><fmt:formatNumber type="number" maxFractionDigits="3"
											value="${cart_.bookItem.price*cart_.amount }" /> Đ</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="thanh-toan">
						<div class="form-group">
							<h5>Đơn vị vận chuyển</h5>
							<table style="width: 100%;">
								<tbody>
									<tr>
										<td>${shipment.name }</td>
										<td><fmt:formatNumber type="number" maxFractionDigits="3"
												value="${shipment.price }" /> Đ</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="thanh-toan">
						<div class="form-group">
							<h5>Phương thức thanh toán</h5>
							${payment.paymentType }
						</div>
					</div>

				</div>

				<div class="col-md-4">
					<div class="thanh-toan">
						<h5>Thanh toán</h5>
						<table style="width: 100%;">
							<tbody>
								<tr>
									<td>Thành tiền:</td>
									<td class="thanh-tien"><fmt:formatNumber type="number"
											maxFractionDigits="3" value="${payment.allMoney }" /> Đ</td>
								</tr>
								<tr>
									<td colspan="2" style="text-align: right;">(Đã bao gồm
										VAT)</td>
								</tr>
							</tbody>
						</table>
						<a href="finish" class="btn btn-dark btn-thanh-toan"><span
							style="font-size: 16px; font-weight: 600;">ĐẶT HÀNG</span> </a>
					</div>


				</div>
			</div>

		</div>

	</div>
	<!-- --- -->

	<!-- FOOTER -->
	<%@ include file="/layout/footer.jsp"%>
	<!-- ------ -->


</body>

</html>