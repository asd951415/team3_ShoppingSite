<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/Top.css">
<!-- 배너 -->
<div class="banner">
    <img src="<%=request.getContextPath() %>/images/bannerImage_199507_1602477265.jpg" alt="배너이미지">
</div>
	
<div class="topnav-container">
    <div class="logo">
        <a href=""><img src="<%=request.getContextPath() %>/images/logo@3x.png"></a>
    </div>
</div>

   <!-- category menu -->
<c:set var="id" value='<%= (String)session.getAttribute("memberId") %>'/>
<div class="category-container">
    <ul class="category-menu">
        <li class="category-menu-item"><a href ="/team3_ShoppingSite/mainPage.do">HOME</a></li>
        
        <li class="category-menu-item"><a href ="/team3_ShoppingSite/category.do?categoryNum=61">TOP</a></li>
        <li class="category-menu-item"><a href ="/team3_ShoppingSite/category.do?categoryNum=62">PANTS</a></li>
        <li class="category-menu-item"><a href ="/team3_ShoppingSite/category.do?categoryNum=63">OUTER</a></li>
        <li class="category-menu-item"><a href ="/team3_ShoppingSite/category.do?categoryNum=64">ETC</a></li>
        <li class="category-menu-item"><a href="/team3_ShoppingSite/member/cart.do">CART</a></li>
        <li class="category-menu-item"><a href ="/team3_ShoppingSite/member/myPage.do">MYPAGE</a></li>
        <li class="category-menu-item">
        <c:choose>
       		<c:when test="${id == null}">
            	<a href="/team3_ShoppingSite/signInPage.do">SIGN IN</a></li>
            </c:when>
            <c:otherwise>
            	<a href="/team3_ShoppingSite/signOut.do">SIGN OUT</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
   
   