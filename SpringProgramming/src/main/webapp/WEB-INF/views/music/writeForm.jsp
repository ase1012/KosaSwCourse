<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body {
				font-size: small;
				color: white;
			}
			
			input {
				font-size: 12px;
			}
		</style>
	</head>
	
	<body>
		<h4>노래 등록</h4>
		<form method="post" action="write" enctype="multipart/form-data">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"/></td>
				</tr>
				<tr>
					<td>가수</td>
					<td><input type="text" name="singer"/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="number" name="price"/></td>
				</tr>
				<tr>
					<td>노래 설명</td>
					<td><textarea name="content" rows="5" cols="50"></textarea></td>
				</tr>
				
				<tr>
					<td>앨범사진</td>
					<td><input type="file" name="attach"/></td>
				</tr>
				
				<tr>
					<td colspan="2" style="text-align: center;">
						<br/>
						<input type="submit" value="노래올리기"/>
						<input type="reset" value="다시작성"/>	
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>