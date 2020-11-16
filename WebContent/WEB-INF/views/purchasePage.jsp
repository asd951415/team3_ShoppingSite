<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/PurchasePage.css">
</head>
<body>
    <div class="purchase_title">
        <h1>주문하기</h1>
    </div>

    <div class="pd_info_container">
        <div class="pd_info_title">
            <h2>주문상품정보</h2>
        </div>
        
        
        <div class="pd_info_table">
            <table>
                <tr>
                    <th>판매자이름</th>
                    <th>쿠폰적용</th>
                    <th>주문금액</th>
                </tr>
                <tr>
                    <td>
                        <div class="pd_info_wrap">
                            <div class="pd_info_img">
                                <img src="/images/다운로드 (1).jpg" alt="">
                            </div>
                            <div class="pd_info_detail">
                                <ul>
                                    <li>상품명</li>
                                    <li>사이즈</li>
                                    <li>수량</li>
                                </ul>
                            </div>
                        </div>
                    </td>
                    <td>쿠폰적용</td>
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
                                    <li>상품명</li>
                                    <li>사이즈</li>
                                    <li>수량</li>
                                </ul>
                            </div>
                        </div>
                    </td>
                    <td>쿠폰적용</td>
                    <td>30000</td>
                </tr>
            </table>
        </div>
        <div class="total_price">
            <h1>총주문금액: 300000</h1>
        </div>

        <div class="member_info_title">
            <h1>주문자정보</h1>
        </div>
    </div>

    <div class="member_info_container">
        <table>
            <tr>
                <td>이름</td>
                <td></td>
            </tr>
            <tr>
                <td>휴대폰</td>
                <td></td>
            </tr>
            <tr>
                <td>이메일</td>
                <td></td>
            </tr>
        </table>
    </div>

    <div class="address_info_container">
        <div class="address_info_title">
            <h1>배송지정보</h1>
        </div>
        <div class="address_info_table">
            <table>
                <tr>
                    <td>수령인</td>
                    <td></td>
                </tr>

                <tr>
                    <td>핸드폰</td>
                    <td></td>
                </tr>

                <tr>
                    <td>배송주소</td>
                    <td></td>
                </tr>

                <tr>
                    <td>배송메모</td>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
    
    <div class="pay_btn">
        <a href="">결제하기</a>
    </div>
</body>
</html>