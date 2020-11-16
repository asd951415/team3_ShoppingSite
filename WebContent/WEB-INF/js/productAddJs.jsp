<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<script>

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
  console.log(json)
  const data = JSON.stringify(json)
  const response = await fetch("/team3_ShoppingSite/seller/productAdd.ajax", {
    method: "POST",
    headers: {
      'Content-Type': 'application/json'
    },
    body: data
  })
  const result = await response.text()
  console.log(result)
})

</script>