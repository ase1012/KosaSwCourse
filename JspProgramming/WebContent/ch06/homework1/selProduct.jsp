<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>selProduct.jsp</title>
	</head>
	<body>
		<%
		//HTML 폼에서 전달된 데이터의 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//session에 username 이름으로 HTML 폼의 <input type = "text"
		//name= "username"/>에 입력된 값을 저장함
		session.setAttribute("username",request.getParameter("username"));
		%>
		<center>
			<h2>상품 선택</h2>
			<hr>
			<%=session.getAttribute("username") %>님이 로그인한 상태입니다.
			<hr>
			<form name="form1" method = "POST" action = "add.jsp">
				<select name = "product">
					<option>사과</option>
					<option>귤</option>
					<option>파인애플</option>
					<option>자몽</option>
					<option>레몬</option>
					<option>포도</option>
					<option>딸기</option>
					<option>바나나</option>
				</select>
				<input type= "submit" value = "추가"/>
			</form>
			<a href = "checkOut.jsp">계산</a>
		</center>
	</body>
</html>