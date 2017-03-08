<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link href="<c:url value="/resources/css/header.css"/>" rel="stylesheet"
	type="text/css" />

<header>

	<nav id="myNavbar"
		class="navbar navbar-default navbar-inverse navbar-fixed-top header_inner"
		role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbarCollapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"
					style="color: white; font-weight: bold; font-size: 1.5em;">Spring
					Boot Couchbase</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="nav navbar-nav">
					<li id="homeTab" class=""><a href="${pageContext.request.contextPath}/welcome"><span
							class="glyphicon glyphicon-home"
							style="font-size: 18px; padding-right: 8px"></span> Home</a></li>
					<li id="bookTab"><a href="${pageContext.request.contextPath}/books"><span
							class="glyphicon glyphicon-user"
							style="font-size: 18px; padding-right: 8px"></span> Book</a></li>
				</ul>
			</div>
		</div>
	</nav>
</header>



