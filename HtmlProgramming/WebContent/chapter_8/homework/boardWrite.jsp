<%@ page contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String title = request.getParameter("title");
String username = request.getParameter("username");
String content = request.getParameter("content");
String sex=request.getParameter("sex");
String password=request.getParameter("password");
String open=request.getParameter("open");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
제목 : <%=title%> <br/>
		글쓴이 : <%=username%> <br/>
		내용 : <%=content%> <br/>
		성별 : <%=sex%> <br/>
		비밀번호 : <%=password%> <br/>
		공개여부 : <%=open%> <br/>
</body>
</html>