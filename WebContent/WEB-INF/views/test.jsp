<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="inqPost" value="<%=request.getAttribute("inqPost") %>"></c:set>
	
	${inqPost.글번호}
	${inqPost.제목}
	${inqPost.내용}
	${inqPost.생성일}
	
</body>
</html>