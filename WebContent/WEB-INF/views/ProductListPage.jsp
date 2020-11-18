<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/team3_ShoppingSite/css/ProductList.css">
</head>
<body>
<div class="top_container">
	<jsp:include page="./common/MyPageTop.jsp"></jsp:include>
</div>
<div class="sideBar_content_container">
	<div class="sideBar_container">
		<jsp:include page="./common/MyPageMenu.jsp"></jsp:include>
	</div>
	<div class=productList_container>
		 <div class="productList_title">
        	<h1>상품목록</h1>
         </div>
	    <div class="pd_info_table">
	        <table>
	                <tr class="addProductBtn_table">
	                    <td>
	                        <div class="addProductBtn">
	                            <a href="/team3_ShoppingSite/seller/productAddPage.do">
	                            	<button>상품등록하기</button>
	                            </a>
	                        </div>
	                    </td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th>상품명</th>
	                    <th>가격</th>
	                    <th>사이즈</th>
	                    <th>재고</th>
	                    <th>설명</th>
	                </tr>
	                <c:set var="productList" value='<%= request.getAttribute("productList") %>'/>
					<c:forEach var="product" items="${ productList }" varStatus="index">
						<c:if test="${product != null}">
							 <tr>
			                	<td>${ product.pName }</td>
			                    <td>${ product.pPrice }</td>
			                    <td>${ product.pSize }</td>
			                    <td>${ product.pAmount }</td>
			                    <td>${ product.pDescription }</td>
			                </tr>
						</c:if> 
					</c:forEach>
	            </table>
	        </div>
	</div>
</div>
</body>
</html>