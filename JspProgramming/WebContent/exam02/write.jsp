<%@ page contentType="text/html; charset=UTF-8"%>

<%--클라이언트가 보낸 데이터를 Board 객체에 저장 --%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="product" class="dto.Product" >
	<jsp:setProperty name="product" property="*"/>
</jsp:useBean>

<%--application 범위의 BoardService 객체 사용 --%>
<jsp:useBean 
	id="productService" 
	class="service.ProductService"
	scope="application"/>
	
<%-- BoardService의 add() 메소드를 호출 --%>
<%productService.add(product); %>

<%-- BoardService의 add() 메소드를 호출 --%>
<%response.sendRedirect("list.jsp");%>