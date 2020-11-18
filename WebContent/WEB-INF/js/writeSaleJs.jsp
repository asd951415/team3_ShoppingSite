<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<script>

let editor;
(async function () {
	//editor = await	
	editor = await ClassicEditor
			.create( document.querySelector( '#editor' ), {
				toolbar: [ 'heading', '|', 'bold', 'italic', 'link', 'bulletedList', 'numberedList', "alignment",
					   'blockQuote', 'insertTable', 'undo', 'redo' ],
				removePlugins: ['ImageUpload', 'MediaEmbed'],
				heading: { 
					options: [ 
						{ model: 'paragraph', title: 'Paragraph', class: 'ck-heading_paragraph' }, 
						{ model: 'heading1', view: 'h1', title: 'Heading 1', class: 'ck-heading_heading1' }, 
						{ model: 'heading2', view: 'h2', title: 'Heading 2', class: 'ck-heading_heading2' },
						{ model: 'heading3', view: 'h3', title: 'Heading 3', class: 'ck-heading_heading2' }
					] 
				},
				alignment: {
					options: [ 'left', 'right' ]
				}
			} )
			/*.then( editor => {
				//editor.setData('<p>aaa</p>')
			})*/
			.catch( error => {
			    console.error( error );
			});
	/*editor.model.document.on('change:data', () => {
						console.log('data changed')
					})*/
	
})()

const uploadeImageArr = [];

function setThumbnail(event) {
	  if(uploadeImageArr.length === 10) {
	    alert('이미지는 10개만')
	    return;
	  }
	  uploadeImageArr.push(event.target.files[0])
		for (var image of event.target.files) {
	    var reader = new FileReader();
	    reader.addEventListener('load', event => {
	      var img = document.createElement("img");
	      img.setAttribute("src", event.target.result);
	      document.getElementsByClassName('thumbnail')[uploadeImageArr.length - 1].appendChild(img);
	    })
		reader.readAsDataURL(image);
	}
}
	
document.getElementById('uploadFile').addEventListener('change', setThumbnail)

const writeSale = document.getElementById('writeSale')

writeSale.addEventListener('click', async e => {
  const titleInput = document.getElementById('titleInput')
  const categoryInput = document.getElementById('categoryInput')
  const products = document.getElementsByName('product')
  const pNums = [];
  for(let i = 0; i < products.length; i++){
    if(products[i].checked){
      pNums.push(products[i].value)
    }
  }
  const title = titleInput.value
  const content = editor.getData()
  const categoryNum = categoryInput.options[categoryInput.selectedIndex].value
  
  const data = new FormData();
  data.append('title', title)
  data.append('content', content)
  data.append('categoryNum', categoryNum)
  data.append('pNums', pNums)
  for(let i = 0; i < uploadeImageArr.length; i++){
    data.append(uploadeImageArr[i].name, uploadeImageArr[i]);
  }

  const res = await fetch('/team3_ShoppingSite/seller/writeSale.ajax', {
		method: 'post',
		body: data
	});
	const status = res.status
  if(status === 200){
    const result = await res.text()
    if(result ==='success'){
      alert('판매글 등록 완료')
      location.href = '/team3_ShoppingSite/member/myPage.do'
    } else {
      alert('판매글 등록 실패. 정보를 올바르게 입력했는지 다시 확인하세요.')
    }
  } else if(status == 404){
    alert('해당 요청을 찾을 수 없습니다.')
  } else {
    alert('서버 에러: 관리자에게 문의하십시오.')
  }
})

/*
let dragingImage;

document.addEventListener('dragstart', e => {
  if(e.target.className === 'uploadImage') {
	  console.log('dragstart')
    e.dataTransfer.setData('src', e.target.src)
    dragingImage = e.target
  } else {
    return
  }
})

// document.addEventListener("dragenter", (e) => {
//   this.applyDynamicEvent(e.target);
// }, false);

// document.addEventListener("dragleave", (e) => {
//   this.applyDynamicEvent(e.target);
// }, false);

document.addEventListener("dragover", (e) => {
  e.preventDefault();
});

document.addEventListener('drop', e => {
  e.preventDefault();
  //console.log('drop')
  console.log(e.target.className)
  const src = e.dataTransfer.getData('src')
  const img = document.createElement('img')
  img.src = src
  img.className = 'uploadImage'
  img.draggable = true
  if(e.target.className === 'thumbnail') {
    e.target.removeChild(e.target.lastChild)
    e.target.appendChild(img)
    dragingImage.parentNode.removeChild(dragingImage);
  }

})
*/


/*
document.getElementById("fileUploadBtn").addEventListener('click', async e => {
	console.log('click');
	const name = document.getElementById("name");
	//const inputs = document.getElementById("file1");
	const inputs = document.querySelectorAll('input[type="file"]');
	//const inputs = document.querySelector('#file1');
	const data = new FormData();
	console.log(inputs[0].files[0].name)
	console.log(inputs[1].files[0].name)
	data.append('file', inputs[0].files[0], inputs[0].files[0].name);
	data.append('file', inputs[1].files[0], inputs[1].files[0].name);
	data.append('categoryNum', 1234)
	data.append('title', "title value")
	data.append('content', "content values")
	data.append('pNums', [1,2,3])
	const response = await fetch('writeSale.ajax', {
		method: 'post',
		headers: {
		      //'Content-Type': 'multipart/form-data'
		    },
		body: data
	});
	const text = await response.text();
	console.log(text)
	console.log(response.status)
});
*/

</script>
