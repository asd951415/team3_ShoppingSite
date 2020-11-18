<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>

const registSellerBtn = document.getElementById('registSellerBtn')

registSellerBtn.addEventListener('click', async e => {
  console.log('click')
  const emailInput = document.getElementById('emailInput')
  const registNumInput = document.getElementById('registNumInput')
  const accountInput = document.getElementById('accountInput')

  const json = {
    email: emailInput.value,
    registNum: registNumInput.value,
    account: accountInput.value
  }
  const data = JSON.stringify(json)
  const res = await fetch('/team3_ShoppingSite/member/registSeller.ajax', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    body: data
  })
  const status = res.status
  if(status === 200){
    const result = await res.text()
    if(result ==='success'){
      alert('판매자 등록 완료')
      location.href = '/team3_ShoppingSite/member/myPage.do'
    } else {
      alert('판매자 등록 실패. 정보를 올바르게 입력했는지 다시 확인하세요.')
    }
  } else if(status == 404){
    alert('해당 요청을 찾을 수 없습니다.')
  } else {
    alert('서버 에러: 관리자에게 문의하십시오.')
  }

})

</script>
