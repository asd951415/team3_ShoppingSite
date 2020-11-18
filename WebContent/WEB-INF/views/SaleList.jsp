<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매글 목록</title>
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
        	<h1>판매글 목록</h1>
         </div>
	    <div class="pd_info_table">
	        <table>
	                <tr class="addProductBtn_table">
	                    <td>
	                        <div class="addProductBtn">
	                            <a href="/team3_ShoppingSite/seller/writeSalePage.do">
	                            	<button>판매글 게시하기</button>
	                            </a>
	                        </div>
	                    </td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                <tr>
	                    <th>메인 이미지</th>
	                    <th>제목</th>
	                    <th>카테고리</th>
	                    <th>생성일</th>
	                </tr>
	                <c:set var="salePostList" value='<%= request.getAttribute("salePostList") %>'/>
					<c:forEach var="salePost" items="${ salePostList }" varStatus="index">
						<c:if test="${salePost != null}">
							 <tr>
							 	<td><img src="/team3_ShoppingSite${ salePost.imageAddrs[0] }" style="width:100px"></td>
			                	<td>${ salePost.saleTitle }</td>
			                    <td>${ salePost.categoryNum == 61 ? 'TOP' : salePost.categoryNum == 62 ? 'PANTS' : salePost.categoryNum == 63 ? 'OUTER' : 'ETC' }</td>
			                    <td>${ salePost.saleCreatedAt }</td>
			                </tr>
						</c:if> 
					</c:forEach>
	            </table>
	        </div>
	</div>
</div>
</body>
</html>