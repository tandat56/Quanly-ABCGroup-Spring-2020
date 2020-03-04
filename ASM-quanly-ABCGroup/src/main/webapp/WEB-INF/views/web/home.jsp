<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/common/taglib.jsp"%>
<html>

<head>

<meta charset="UTF-8">
<title>Trang chủ</title>

</head>

<body>

	<!-- Page Content -->
	<div class="container">

		<c:if test="${not empty bigimage}">
			<!-- Heading Row -->
			<div class="row align-items-center my-5">
				<div class="col-lg-7">
					<c:set var="image" value="/repository/${bigimage.photo}"/>
					<img class="img-fluid rounded mb-4 mb-lg-0" src="${image}" alt="" height="300px" width="300px">
				</div>
				<!-- /.col-lg-8 -->
				<div class="col-lg-5">
					<h1 class="font-weight-light">Tập đoàn ABC Group</h1>
					<p>uy tín tạo niềm tin</p>
					<a class="btn btn-primary" href="#">Info!</a>
				</div>
				<!-- /.col-md-4 -->
			</div>
			<!-- /.row -->
		</c:if>

		<!-- Call to Action Well -->
		<div class="card text-white bg-secondary my-5 py-4 text-center">
			<div class="card-body">
				<p class="text-white m-0">This call to action card is a great
					place to showcase some important information or display a clever
					tagline!</p>
			</div>
		</div>

		<!-- Content Row -->
		<div class="row">
			<c:forEach var="item" items="${staffs}">
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<div class="card-body">
							<h3 class="card-title">${item.name}</h3>
								<div class="col-lg-7">
								<c:set var="image" value="/repository/${item.photo}"/>
									<img class="img-fluid rounded mb-4 mb-lg-0" src="${image}" alt="" height="300px" width="300px">
								</div>
							<h5 class="card-title">${item.salary}</h5>
							<p class="card-text">${item.note}</p>
						</div>
						<div class="card-footer">
							<a href="#" class="btn btn-primary btn-sm">More Info</a>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

</body>

</html>