<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {
				font-family: "돋움";
				font-size: 12px;
				color: white;
			}
			span {
				display: inline-block;
				margin: 2px 10px;
			}
			
			span.title {
				margin: 2px 10px;
				border: 1px solid darkgray;
				background: lightgray;
				width: 70px;
				text-align: center;
				color: black;
			}
			
			pre {
				margin: 10px;
				border: 1px solid darkgray;
				padding: 10px;
				width: 90%;
				height: 100px;
				font-size: 12px;
			}
			
			#part1 {
				display: flex;
			}
			#part1_1 {
				flex: 1;
			}
			#part1_2 {
				width: 120;
				margin-right: 10px;
				text-align: center;
			}
			#part1_2 img {
				display: block;
				padding: 10px;
			}
			
			#buttonGroup {
				margin: 10px;
				text-align: center;
			}
			
			#buttonGroup a {
				display:inline-block;
				width: 70px;
				line-height: 30px;
				text-decoration: none;
				font-size: small;
				color: white;
				border: 1px solid darkgray;
				background-color: gray;
				font-weight: bold;
			}
			
			#buttonGroup a:hover {
				color: black;
				background-color: lightgray;
			}
			
		</style>
	</head>
	
	<body>
		<h4>노래 보기</h4>
		<div id="part1">
			<div id="part1_1">	
				<span class="title">번호:</span> 
				<span class="content">${music.no}</span> <br/>
				
				<span class="title">제목:</span> 
				<span class="content">${music.title}</span> <br/>
				
				<span class="title">가수:</span> 
				<span class="content">${music.singer}</span> <br/>
				
				<span class="title">가격:</span> 
				<span class="content">${music.price}</span> <br/>
								
				<span class="title">첨부:</span> 
				<span class="content">${music.originalFileName}</span> <br/>
			</div>
			
			<div id="part1_2">
				<img src="${pageContext.request.contextPath}/resources/uploadfiles/${music.filesystemName}" width="100px" height="100px"/>
				<button>다운로드</button>
			</div>
		</div>
		
		<div id="part2">
			<span class="title">내용:</span> <br/>
			<pre>${music.content}</pre>
		</div>
		
		<div><br/><br/>
			<h4>댓글</h4>
			<div>
				<table>
					<c:forEach var="comment" items="${list}">
						<tr>
							<td>${comment.writer}</td>
							<td>${comment.date}</td>
						</tr>
						<tr>
							<td>${comment.content}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div>
				<form method="post" action="write" enctype="multipart/form-data">
					<table>
						<tr>
							<td><input type="text" name="writer" style="width:100px;"/></td>
						</tr>
						<tr>
							<td><textarea name="content" rows="3" cols="85"></textarea></td>
							<td><input type="submit" value="댓글등록" style="height:60px;"/></td>					
						</tr>
					</table>
				</form>
			</div>
		</div>
		
		<div id="buttonGroup">
			<a href="list?pageNo=${pageNo}">목록</a>
		</div>		
	</body>
</html>