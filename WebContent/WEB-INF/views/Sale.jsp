<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
  <!--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   --> <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <!--  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/c00b702925.js" crossorigin="anonymous"></script>
     -->  
   <link rel="stylesheet" href="<%=request.getContextPath() %>/css/SalePage.css">
   <jsp:include page="../js/mainJs.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="./common/Top.jsp"></jsp:include>

    <div class="product-detail-container">
        <div class="product-image">
            <img src="./images/jacket.jpg" alt="">
        </div>
        <div class="product-info-container">
            <div class="seller-info">
                <div class="icon">무드글램</div>
                <div class="seller-title"><p>크레센도</p></div>
            </div>
            <div class="detail-title">
                <h1>[브랜디위크][인기재입고]비바 체크 하프자켓 코트</h1>
            </div>
            <div class="detail-price">
                <h1>35,200</h1>
            </div>
            <div class="detail-dcprice">
                <p>쿠폰적용가 29,200원</p>
            </div>
            <div class="review-info">
                <div class="score">
                    <p>❤❤❤❤❤</p> 
                </div>
                <div class="total-reviews">
                    <a href="#"><p>406개 리뷰 보기</p></a>
                </div>
            </div>
            <div class="goods-options-container">
                <select name="colorSelect" id="">
                    <option>사이즈를 선택하세요.</option>
                    <option value="S">S</option>
                    <option value="M">M</option>
                    <option value="L">L</option>
                    <option value="FREE">FREE</option>
                </select>
            </div>
            <div class="price-total-container">
                <div class="total-price-ko">
                    <p>총상품금액</p>
                </div>
                <div class="total-price">
                    <p>0원</p>
                </div>
            </div>
            
            
            <!-- 
   
                <div class="write" data-toggle="collapse" data-target="#demo">
                <a href="member/writeInquPage.do">
                	 <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo">문의하기</button>
                </a>
                </div>
          
             -->
            
            <div class="btn-purchase-container">
                <ul class="btn-purchase-items">
                    <a href="member/purchasePage.do"><li class="btn-purchase-1">
                        <button>바로구매</button>
                    </li></a>
                    <a href="member/cart.do"><li class="btn-purchase-1">
                        <button>장바구니</button>
                    </li></a>
                     <a href="member/writeInquPage.do"><li class="btn-purchase-1">
                        <button>문의하기</button>
                    </li></a>
                </ul>
            </div>
        </div>
    </div>
    
    <div class="tab-detail-info">
        <ul class="tab-details">
            <li class="tab-details-item">
                <a href="#">
                    상품정보
                </a>
            </li>
            <li class="tab-details-item">
                 <a href="#">
                    리뷰(423)
                </a>
            </li>
            <li class="tab-details-item">
                <a href="#">
                    Q&A(615)
                </a>
            </li>
            <li class="tab-details-item">
                <a href="#">
                    주문정보
                </a>
            </li>
        </ul>
    </div>
    
    <div class="product-description">
        <div class="description-title">
            <p>comment ::</p>
        </div>
        <div class="description">
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Magni adipisci praesentium illum aliquid neque sit omnis saepe velit dolore atque quae alias accusamus odio consequatur, inventore ratione. Rem, distinctio ratione?

            </p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Magni adipisci praesentium illum aliquid neque sit omnis saepe velit dolore atque quae alias accusamus odio consequatur, inventore ratione. Rem, distinctio ratione?
                
            </p>
        </div>

        <div class="product-img">
            <img src="../images/+detail_01 (1).jpg" alt="">
            <img src="../images/+detail_01.jpg" alt="">
        </div>
    </div>

    <!-- review -->
    <c:set var="data" value="<%=json %>"></c:set>
    <c:forEach items="${list}"></c:forEach>
    <div class="review-container">

        <div class="tab-review">
            리뷰
        </div>
        <div class="score-review">
            <div class="score-letter">
             
	           		<input id="content" type="text"><br>
	           		<input id="userid" type="text"><br>
	           		<input id="stars" type="text"><br>
	           		<button id="btn">등록</button>
          	   
    
             
            </div>
     
        </div>
    
        <div class="review-content-contaier">
            
          
        </div>
    </div>

    <!-- review paging -->
    <div class="review-page-container">
        <a href="#"><</a>
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">></a>
    </div>


    <!-- Q&A 테이블 -->

    <div class="qna-list-container">
        <table class="qun-list">
            <colgroup>
                <col style="width: 120px;">
                <col style="width: 90px;">
                <col>
                <col style="width: 120px;">
                <col style="width: 120px;">
            </colgroup>
            <thead>
                <tr class = "qna-list-topBar"> 
                    <th><h3>분류</h3></th>
                    <th><h3>처리상태</h3></th>
                    <th style ="text-align: center;"><h3>내용</h3></th>
                    <th><h3>작성자</h3></th>
                    <th><h3>작성일</h3></th>
                </tr>
            </thead>
            <tbody>
                <tr class = "qna-list-bottom">
                    <td><h3>상품문의</h3></td>
                    <td><h3>답변완료</h3></td>
                    <td class="qna-content">
                        <div class="wrap">
                            <i class="fas fa-lock"></i>
                            <h3>비밀글입니다.</h3>
                        </div>
                    </td>
                    <td><h3>jjj***</h3></td>
                    <td><h3>2020.09.19</h3></td>
                </tr>

                <tr>
                    <td><h3>상품문의</h3></td>
                    <td><h3>답변완료</h3></td>
                    <td class="qna-content">
                        <div class="wrap">
                            <i class="fas fa-lock"></i>
                            <h3>비밀글입니다.</h3>
                        </div>
                    </td>
                    <td><h3>jjj***</h3></td>
                    <td><h3>2020.09.19</h3></td>
                </tr>

                <tr>
                    <td><h3>상품문의</h3></td>
                    <td><h3>답변완료</h3></td>
                    <td class="qna-content">
                        <div class="wrap">
                            <i class="fas fa-lock"></i>
                            <h3>비밀글입니다.</h3>
                        </div>
                    </td>
                    <td><h3>jjj***</h3></td>
                    <td><h3>2020.09.19</h3></td>
                </tr>
            </tbody>
        </table>
    </div>

    
    <!-- qna paging -->
    <div class="qna-page-container">
        <a href="#"><</a>
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">></a>
    </div>

</body>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		 // 리스트 생성
		 $("#btn").click(function(){
			 var testList = new Array() ;
	            // 객체 생성
	            let data = new Object() ;
	             
	            data.salePostnum = 1 ;
	            
	            
	            data.id = $("#userid").val(); //아이디 세션
	            data.stars =$("#stars").val(); //별갯수
	            data.content = $("#content").val(); //내용
	             
	             
	            // 리스트에 생성된 객체 삽입
	            
	     
	         
	        // String 형태로 변환
	        var jsonBody = JSON.stringify(data) ;
	        alert(jsonBody) ;
	        
	        $.ajax({
	            type: "POST", 
	            url: "member/review.ajax",
	            contentType: "application/json",
	            data: jsonBody,
	            dataType: "json",
	            success: function(json, status){
	                if (status != "success") { //실패시
	                	 console.log("Error loading datas");
	                    return;
	                }
	                console.log("Data loaded!");
	            },
	            error: function(result, status, err) { //에러시
	                console.log("Error loading data");
	                return;
	            }
	        });
		 })
		 
		 document.getElementById("btn").addEventListener("click", async e => {
				let data = {"saleNum" : "1"}; //body 에 들어갈 데이타
				console.log(data);		
				let response = await fetch("member/reviewList.ajax", { //요청 보낼 주소
					   method: 'POST',
					   body: JSON.stringify(data), //데이타 json 파싱
					   headers:{
					      'Content-Type' : 'application/json' //타입 읽는 방식
					   }
					})
				const jsonStr = await response.json();
				console.log(jsonStr);
				
			});
		 for(let key in index){
			 console.log(jsonStr[key]);
		 }
		 
	});
	
</script>
</html>