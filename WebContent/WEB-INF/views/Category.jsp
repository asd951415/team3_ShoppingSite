<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/Main.css">
</head>
<body>
<jsp:include page="./common/Top.jsp"></jsp:include>
<button id="btn">aaaaaaa</button>
<div id="categoryContent" class="item-list-container">

	<c:set var="salePostList" value='<%= request.getAttribute("salePostList") %>'/>
	<c:forEach var="salePost" items="${ salePostList }" varStatus="index">
		<c:if test="${salePost != null}">
			 <div class="item">
				<img src="<%=request.getContextPath() %>/images/19309420_1598777941_image1_M.jpg" alt="">
				<div class="Product-saleTitle">
					<p>${salePost.saleTitle}</p>
				</div>
				<div class="product-price">
					<p>${salePost.salPrice}원</p>
				</div>
			</div>
		</c:if> 
	</c:forEach>
	
</div>

</body>
<jsp:include page="../js/categoryJs.jsp"></jsp:include>
</html>