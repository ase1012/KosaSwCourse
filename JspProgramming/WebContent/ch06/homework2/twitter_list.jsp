<%@page contentType="text/html; charset=UTF-8"%>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>

<%
	// 한글 캐릭터셋 변환
	request.setCharacterEncoding("UTF-8");
	//HTML 폼에서 username으로 전달된 값을 가지고 옴
	String username  = request. getParameter("username");
	
	//username이 null이 아닌 경우 세션에 값을 지정
	if(username !=null) {
		session.setAttribute("user", username);
	}
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>twitter</title>
	</head>
	<body>
		<div align=center>
			<h3>My Simple Twitter!!</h3>
			<hr>
			<form action = "tweet.jsp" method= "POST">
			<!-- 세션에 저장된 이름 출력 -->
			@<%=session.getAttribute("user") %> 
				<input type = "text" name = "msg">
				<input type = "submit" value = "Tweet">
			</form>
			<hr>

		<div align="left">
			<ul>
				<%
					//application 내장객체를 통해 msgs 이름으로 저장된 ArrayList를 가지고 옴
					ArrayList<String>msgs= (ArrayList<String>)application.getAttribute("msgs");
					
					//msgs가 null이 아닌 경우에만 목록 출력
					if(msgs !=null) {
						for(String msg : msgs) {
							out.println("<li>" + msg + "</li>");
						}
					}
				%>
			</ul>
		</div>
		</div>	
	</body>
</html>