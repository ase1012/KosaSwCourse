<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<form method="post" action="write.jsp">
			<table>
				<tr>
					<td>상품이름</td>
					<td><input type="text" name="name"/></td>
				</tr>
				
				<tr>
					<td>가격</td>
					<td><input type="number" name="price"/></td>
				</tr>
				
				<tr>
					<td>재고</td>
					<td><input type="number" name="stock"/></td>
				</tr>
				
				<tr>
					<td>상품설명</td>
					<td><textarea name="detail" rows="5" cols="50"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="상품업로드"/>
			<input type="reset" value="다시작성"/>
		</form>
	</body>
</html>