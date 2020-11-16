<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://cdn.ckeditor.com/ckeditor5/23.1.0/classic/ckeditor.js"></script>
<style>
	.editContent {
		width: 80%;
		margin: 0 auto;
	}
	
	.ck-content {
		height: 500px;
		overflow: scroll;
	}
	/*.editorContainer{
		width: 50%;
	}*/
	table{
		width: 100%;
	}
	
	.image_container {
		width: 100%;
		height: 100%;
		display: grid;
		grid-template-columns: repeat(5, 1fr);
		grid-template-rows: repeat(2, 1fr);
	}
	
	.image_file{
		width: 100%;
		height: 100%;
	}
	
	@media screen and (max-width: 768px) {
		.image_container {
			width: 100%;
			display: grid;
			grid-template-columns: repeat(2, 1fr);
			grid-template-rows: repeat(5, 1fr);
		}
	}
	
</style>
</head>
<body>
<jsp:include page="./common/Top.jsp"></jsp:include>
<div class="editContent">
	<!-- 
	 <button id="dd">dd</button>	
	 -->
	제목<input type="text" id="titleInput">
	카테고리<select name="categoryInput">
		<option value="61">TOP</option>
		<option value="62">PANTS</option>
		<option value="63">OUTER</option>
		<option value="64">ETC</option>
	</select>
	<button id="writeSale">작성</button>
	<div class="editorContainer">
		<div id="editor" class="_editor"></div>	
	</div>
	<input type="file" id="uploadFile" name="filename1" multiple/>
	<div class="image_container">
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>메인 이미지</p>
				</div>
				<!--  <img class="uploadImage" src="../images/400.jpg" style="width:100%" draggable="true"> -->
			</div>
		</div>
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>2번째 이미지</p>
				</div>
			</div>
		</div>
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>3번째 이미지</p>
				</div>
			</div>
		</div>
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>4번째 이미지</p>
				</div>
			</div>
		</div>
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>5번째 이미지</p>
				</div>
			</div>
		</div>
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>6번째 이미지</p>
				</div>
			</div>
		</div>
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>7번째 이미지</p>
				</div>
			</div>
		</div>
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>8번째 이미지</p>
				</div>
				
			</div>
		</div>
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>9번째 이미지</p>
				</div>
				
			</div>
		</div>
		<div class="col-md-4 image_file">
			<div class="thumbnail">
				<div class="caption">
					<p>10번째 이미지</p>
				</div>
				
			</div>
		</div>
	</div>
	<!-- 
	</div>
	 -->

	<!-- 
		<table border="1">
			<tr>
				<td>1</td><td>2</td><td>3</td><td>4</td><td>5</td>
			</tr>
			<tr>
				<td></td><td></td><td></td><td></td><td></td>
			</tr>
			<tr>
				<td>6</td><td>7</td><td>8</td><td>9</td><td>10</td>
			</tr>
			<tr>
				<td></td><td></td><td></td><td></td><td></td>
			</tr>
		</table>
	 -->
</div>
</body>
<jsp:include page="../js/writeSaleJs.jsp"></jsp:include>
</html>