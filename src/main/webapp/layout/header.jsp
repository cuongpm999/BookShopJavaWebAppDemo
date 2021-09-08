<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="header">
		<nav class="navbar navbar-expand-sm container">

			<a class="navbar-brand" href="/BookShop/"><img class="logo"
				src="${pageContext.request.contextPath}/static/img/logo.png"
				alt="logo"></a>

			<ul class="navbar-nav">
				<div class="nav-left" style="display: flex; align-items: center;">
					<li class="nav-item"><a class="nav-link" href="/BookShop/">Trang chủ</a></li>
				</div>
				<div class="nav-center" style="display: flex;">
					<form class="form-inline" action="search-name"
						style="width: 100%; position: relative;" method="get">
						<input class="form-control mr-sm-2" type="text"
							placeholder="Search" name="key">
						<button class="btn" type="submit">
							<i class="fas fa-search"></i>
						</button>
					</form>
				</div>

				<div class="nav-right" style="display: flex; align-items: center;">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbardrop"
						data-toggle="dropdown"> Tài khoản </a>
						<div class="dropdown-menu">
							<c:choose>
							<c:when test="${not empty cookie.username.value }">
								<a class="dropdown-item" href="javascript:void(0);">${cookie.username.value }</a>
								<a class="dropdown-item" href="logout">Logout</a>
							</c:when>
							
							<c:when test="${empty cookie.username.value }">
								<a class="dropdown-item" href="login">Login</a>
							</c:when>
							</c:choose>
							
						</div></li>
					<li class="nav-item"><a class="nav-link"
						style="position: relative;" href="cart"> <img class="cart"
							src="${pageContext.request.contextPath}/static/img/cart.png"
							alt="cart"> <c:choose>
								<c:when test="${not empty soLuongMua }">
									<span class="count-item">${soLuongMua }</span>
								</c:when>
								<c:when test="${empty soLuongMua }">
									<span class="count-item">0</span>
								</c:when>
							</c:choose>
					</a></li>
				</div>
			</ul>
		</nav>
	</div>