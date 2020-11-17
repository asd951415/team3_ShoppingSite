<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
index
<input type="button" id="sendAjax" value="send ajax">
<a href="mainPage.do">메인페이지</a>
<br>
<button id="btn">버튼</button>
</body>
<script>
document.getElementById('sendAjax').addEventListener('click', async e => {
	console.log('click')
	const jsonData = { id: 'jack', pwd: '1234' }
//	const jsonData = { products: [{id: 'jack'}, {id: 'jack2'}] }
//	const jsonData = [{pNum:2, pName:'하양모자', pAmount: 3, pPrice:50000, pSize:'F', saleNum:100, saleTitle:'모자, 셔츠, 바지 팝니다.', imageAddr:'test address1'},
//						{pNum:3, pName:'검은셔츠', pAmount: 2, pPrice:50000, pSize:'F', saleNum:100, saleTitle:'모자, 셔츠, 바지 팝니다.', imageAddr:'test address2'}]
	const data = JSON.stringify(jsonData);
//	const data = 'id=jack';
	const res = await fetch('seller/writeSale.ajax', {
	    method: 'POST',
	    headers: {
	      'Content-Type': 'application/json'
//	      'Content-Type': 'text/parameters'
	    },
	    redirect: 'follow',
	    referrerPolicy: 'no-referrer',
	    body: data
	  });
	console.log(res.status)
	console.log(res.text())
});




document.getElementById("btn").addEventListener("click", async e => { //비동기
	let data = {"saleNum" : "1"}; //body 에 들어갈 데이타
	console.log(data);		
	let response = await fetch("member/reviewList.ajax", { //요청 보낼 주소
		   method: 'POST',
		   body: JSON.stringify(data),
		   headers:{
		      'Content-Type' : 'application/json'
		   }
		});
	const jsonStr = await response.json(); //응답 json 객체로 받기
	console.log(jsonStr);
	console.log(typeof(jsonStr));
	
	var test = new Array(); 
	for(let i=0; i<7; i++){
		test[i]=JSON.parse(jsonStr[i]); //객체 안에 있는 key 값 String -> Object 변환
	}
	
	for(let i=0; i<7; i++){
		console.log(test[i].rev_content); //key안에 있는 value 출력
		// 여기서 뽑아온 값들을 html에다가 뿌리면 되요
	}
	
});

</script>
</html>