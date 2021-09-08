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

		<div class="container mt-5" style="min-height: 318px;">
			<div class="row">
				<div class="col-md-12">
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
									<td class="san-pham"><a href="book-detail?id=${cart_.bookItem.id }"
										style="margin-right: 10px"><img
											src="${pageContext.request.contextPath}/static/upload/${cart_.bookItem.img }"
											alt="product"></a><a href="book-detail?id=${cart_.bookItem.id }">
											<h6>${cart_.bookItem.name }</h6>
									</a></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="3"
											value="${cart_.bookItem.price }" /> Đ</td>
									<td><input class="form-control text-center nhap-so-luong"
										value="${cart_.amount }" type="number" min="1"
										style="width: 70px;"></td>
									<td><fmt:formatNumber type="number" maxFractionDigits="3"
											value="${cart_.bookItem.price*cart_.amount }" /> Đ</td>
									<td></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="card-body" style="text-align: right;">
						<div class="tongtienthanhtoan">
							Tổng tiền đơn hàng: <strong><span id="total_value">
							</span>
							<fmt:formatNumber type="number" maxFractionDigits="3"
									value="${tongTien }" /> Đ</strong>
						</div>
					</div>
				</div>

			</div>
			<form action="cart" method="post">
				<div class="row">

					<div class="col-md-4">
						<div class="thanh-toan">
							<div class="form-group">
								<h5>Đơn vị vận chuyển</h5>
								<select name="shipmentId" class="form-control">
									<c:forEach var="shipment" items="${listShipment }">
										<option value="${shipment.id }">${shipment.name }&emsp;<fmt:formatNumber
												type="number" maxFractionDigits="3"
												value="${shipment.price }" />&nbsp;Đ
										</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="thanh-toan">
							<div class="form-group">
								<h5>Phương thức thanh toán</h5>
								<div class="form-check">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="paymentType"
										value="Thanh toán
										bằng thẻ ngân hàng" checked>Thanh
										toán bằng thẻ ngân hàng
									</label>
								</div>
								<div class="form-check">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="paymentType"
										value="Thanh toán
										trực tiếp khi nhận hàng">Thanh
										toán trực tiếp khi nhận hàng
									</label>
								</div>
							</div>
						</div>
					</div>

					<div class="col-md-4">
						<div class="thanh-toan">
							<c:choose>
								<c:when test="${empty giohang }">
									<button type="submit" class="btn btn-success btn-thanh-toan"
										disabled>
										<div style="text-align: center; width: 100%">
											<span style="font-size: 16px; font-weight: 600;">MUA
												HÀNG</span><br> <span style="font-size: 12px;">Bạn phải
												đăng nhập để tiếp tục</span>
										</div>
									</button>
								</c:when>

								<c:when test="${not empty giohang }">
									<button type="submit" class="btn btn-success btn-thanh-toan">
										<div style="text-align: center; width: 100%">
											<span style="font-size: 16px; font-weight: 600;">MUA
												HÀNG</span><br> <span style="font-size: 12px;">Bạn phải
												đăng nhập để tiếp tục</span>
										</div>
									</button>
								</c:when>
							</c:choose>

						</div>
					</div>

				</div>
			</form>
		</div>

	</div>
	<!-- --- -->

	<!-- FOOTER -->
	<%@ include file="/layout/footer.jsp"%>
	<!-- ------ -->


</body>

</html>