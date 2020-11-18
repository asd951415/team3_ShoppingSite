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
      alert('��ǰ��� �Ϸ�')
      location.href = '/team3_ShoppingSite/seller/productList.do'
    } else {
      alert('��ǰ��� ����. ������ �ùٸ��� �Է��ߴ��� �ٽ� Ȯ���ϼ���.')
    }
  } else if(status == 404){
    alert('�ش� ��û�� ã�� �� �����ϴ�.')
  } else {
    alert('���� ����: �����ڿ��� �����Ͻʽÿ�.')
  }
})

</script>