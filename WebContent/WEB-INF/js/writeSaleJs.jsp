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
				console.log('editor')
				//editor.setData('<p>aaa</p>')
				editor1 = editor
				editor.model.document.on('change:data', () => {
					console.log('data changed')
				})
				//$('style').append('.ck-content { min-height: ' + $('textarea[name="content"]').height() + 'px !important; }');
			})*/
			.catch( error => {
			    console.error( error );
			});
	/*editor.model.document.on('change:data', () => {
						console.log('data changed')
					})*/
	
})()
/*
document.getElementById('dd').addEventListener('click', e => {
	console.log(editor1.getData())
})
*/

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
	      console.log(document.getElementsByClassName('thumbnail')[uploadeImageArr.length - 1])
	      document.getElementsByClassName('thumbnail')[uploadeImageArr.length - 1].appendChild(img);
	    })
		console.log(image);
		reader.readAsDataURL(image);
	}
}
	
document.getElementById('uploadFile').addEventListener('change', setThumbnail)

const writeSale = document.getElementById('writeSale')

writeSale.addEventListener('click', async e => {
  console.log('click')
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
