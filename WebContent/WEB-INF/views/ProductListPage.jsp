<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/ProductList.css">
</head>
<body>
<div class="top_container">
	<jsp:include page="./common/MyPageTop.jsp"></jsp:include>
</div>
<div class="sideBar_content_container">
	<div class="sideBar_container">
		<jsp:include page="./common/MyPageMenu.jsp"></jsp:include>
	</div>
	<c:set var="list" value="<%=request.getAttribute(name) %>"></c:set>
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
	                    <td>
	
	                    </td>
	                    <td>
	
	                    </td>
	                </tr>
	                <tr>
	                    <th>상품이미지</th>
	                    <th>재고</th>
	                    <th>가격</th>
	                </tr>
	                <tr>
	                    <td>
	                        <div class="pd_info_wrap">
	                            <div class="pd_info_img">
	                                <img src="/images/다운로드 (1).jpg" alt="">
	                            </div>
	                            <div class="pd_info_detail">
	                                <ul>
	                                    <div class="pd_title">
	                                        <li>상품명</li>
	                                        <li>슬랙스7부바지</li>
	                                    </div>
	                                </ul>
	                            </div>
	                        </div>
	                    </td>
	                    <td>20개</td>
	                    <td>30000</td>
	                </tr>
	                <tr>
	                    <td>
	                        <div class="pd_info_wrap">
	                            <div class="pd_info_img">
	                                <img src="/images/다운로드 (1).jpg" alt="">
	                            </div>
	                            <div class="pd_info_detail">
	                                <ul>
	                                    <div class="pd_title">
	                                        <li>상품명</li>
	                                        <li>슬랙스7부바지</li>
	                                    </div>
	                                </ul>
	                            </div>
	                        </div>
	                    </td>
	                    <td>20개</td>
	                    <td>30000</td>
	                </tr>
	
	            </table>
	        </div>
   
	</div>
</div>
</body>
</html>