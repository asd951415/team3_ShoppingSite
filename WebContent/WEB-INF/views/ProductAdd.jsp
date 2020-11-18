<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>In</title>
</head>
<body>
상품등록페이지
<jsp:include page="./common/Top.jsp"></jsp:include>
<%--  <jsp:include page="./common/MyPageMenu.jsp"></jsp:include> --%>

<div class="ProductAdd_container">
	상품명<input type="text" id="pNameInput">
	가격<input type="text" id="pPriceInput" onkeypress="inNumber()">
	<!-- 사이즈<input type="text" id="pSizeInput"> -->
	사이즈<select id="pSizeInput">
		<option value="F">F</option>
		<option value="S">S</option>
		<option value="M">M</option>
		<option value="L">L</option>
	</select>
	수량<input type="text" id="pAmountInput" onkeypress="inNumber()">
	상품설명<input type="text" id="pDescInput">
	<button id="addProductBtn">상품등록</button>
</div>

</body>
<jsp:include page="../js/productAddJs.jsp"></jsp:include>
</html>