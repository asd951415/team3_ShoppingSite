<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<script>

function inNumber(){
  if(event.keyCode<48 || event.keyCode>57){
     event.returnValue=false;
  }
}

const addProductBtn = document.getElementById("addProductBtn")
addProductBtn.addEventListener('click', async e=>{
  const pNameInput = document.getElementById("pNameInput")
  const pPriceInput = document.getElementById("pPriceInput")
  const pSizeInput = document.getElementById("pSizeInput")
  const pAmountInput = document.getElementById("pAmountInput")
  const pDescInput = document.getElementById("pDescInput")

  const json = {
    pName: pNameInput.value,
    pPrice: pPriceInput.value,
    pSize: pSizeInput.options[pSizeInput.selectedIndex].value,
    pAmount: pAmountInput.value,
    pDesc: pDescInput.value
  }
  const data = JSON.stringify(json)
  const res = await fetch("/team3_ShoppingSite/seller/productAdd.ajax", {
    method: "POST",
    headers: {
      'Content-Type': 'application/json'
    },
    body: data
  })
  
  const status = res.status
  if(status === 200){
    const result = await res.text()
    if(result ==='success'){
      alert('상품등록 완료')
      location.href = '/team3_ShoppingSite/seller/productList.do'
    } else {
      alert('상품등록 실패. 정보를 올바르게 입력했는지 다시 확인하세요.')
    }
  } else if(status == 404){
    alert('해당 요청을 찾을 수 없습니다.')
  } else {
    alert('서버 에러: 관리자에게 문의하십시오.')
  }
})

</script>