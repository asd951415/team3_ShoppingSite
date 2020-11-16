<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/RegistSellerPage.css">
</head>
<body>
<div class="top_container">
	<jsp:include page="./common/Top.jsp"></jsp:include>
</div>
<div class="sideBar_content_container">
	<div class="sideBar_container">
		<jsp:include page="./common/MyPageMenu.jsp"></jsp:include>
	</div>
	<div class="sellerForm_container">
		 <form action="#" style="border:1px solid #ccc">
        <div class="container">
          <h1>판매자등록</h1>
          <p>아래의 내용을 작성하시오</p>
          <hr>
      
          <label for="email"><b>이메일</b></label>
          <input type="text" placeholder="Enter Email" name="email" required>
      
          <label for="psw"><b>계좌번호</b></label>
          <input type="text" placeholder="Enter Password" name="accountNum" required>
      
          <label for="psw-repeat"><b>사업자번호</b></label>
          <input type="text" placeholder="Repeat Password" name="regisNum" required>
          
          
          
          <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
      
          <div class="clearfix">
            <button type="button" class="cancelbtn">취소하기</button>
            <button type="submit" class="signupbtn">등록하기</button>
          </div>
        </div>
      </form>
	</div>
</div>
	 
</body>
</html>