<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<article>
   <input id="title" type="text"> <!-- 제목 -->
   <input id="content" type="text"> <!-- 내용 -->
</article>
   
   
   
</body>
<script type="text/javascript">
fetch('member/writeInqu.ajax', {
     method: 'POST',
     headers: { 'Content-Type': 'application/json; charset=UTF-8' },
     body: JSON.stringify({
       title: document.getElementId("title"),
       content: document.getElementId("content"),
       }),
     })
     .then((response) => {
       return res.json(); //응답 json 파싱
     })
     .then((response) => {
       console.log(data); //전송되었는지 확인
     });
</script>
</body>
</html>