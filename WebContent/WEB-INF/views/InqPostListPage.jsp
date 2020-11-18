<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 목록확인 페이지</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/InqPostListPage.css">
</head>
<body>
<div class="top_container">
	<jsp:include page="./common/MyPageTop.jsp"></jsp:include>
</div>
<div class="sideBar_content_container">
	<div class="sideBar_container">
		<jsp:include page="./common/MyPageMenu.jsp"></jsp:include>
	</div>
	<div class="productList_container">
        <div class="productList_title">
            <h1>문의글목록</h1>
        </div>

            <div class="pd_info_table">
                <table>
                    <tr>
                        <!-- 글번호,  -->
                        <th>글번호</th>
                        <th>글제목</th>
                        <th>판매자번호</th>
                        <th>등록날짜</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    <tr>
                        <td>
                            <div class="pd_info_wrap">
                                <div class="pd_title">
                                1
                                </div>
                            </div> 
                        </td>
                        <td>글제목</td>
                        <td>1</td>
                        <td>2020.10.11</td>
                        <td>
                            <button>수정</button>
                        </td>
                        <td>
                            <button>삭제</button>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="pd_info_wrap">
                                <div class="pd_title">
                                    <h2>글번호</h2>
                                </div>
                            </div> 
                        </td>
                        <td>글제목</td>
                        <td>판매자번호</td>
                        <td>등록날짜</td>
                        <td>
                            <button>수정</button>
                        </td>
                        <td>
                            <button>삭제</button>
                        </td>
                    </tr>
                </table>
            </div>

    </div>

</div>
 

<!--  
<div class="inqlist" max-width="1200px", max-height="960px">사이드바 인클루드-->
<!--  
<tbody>
<c:set var="list" value="${requestScope.list}"/>
<c:forEach var="list2" items="${list}">
<tr onmouseover="this.style.backgroundColor='gray'" onmouseout="this.style.backgroundColor='white'">
-->
<!--
Inqnum salenum inqtitle inqcontent inqcreatedat
-->
<!--  
<td>${list2.inqnum}</td>
<td>${list2.salenum}</td>
<td>${list2.inqtitle}</td>
<td>${list2.inqcontent}</td>
</tr>
</c:forEach>
</tbody>
<div>
-->
</body>
</html>