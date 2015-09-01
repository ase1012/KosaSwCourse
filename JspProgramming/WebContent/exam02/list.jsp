<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*,java.util.*" %>


<jsp:useBean id="productService" 
class="service.ProductService" 
scope="application">
</jsp:useBean> 

<%
List<Product> list=productService.getPage(1,10);
%>

<!DOCTYPE html>
	<html>
	<head> 
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table{
				width:100%;
				border-collapse:collapse;
				font-size: small;
			}
			table, th, td{
				border : 1px solid black;
				text-align:center;
				
			}
			th{
				background-color: #B2EBF4;
			}
			#buttonGroup{
				text-align:center;
				margin:10px;
			}
		</style>
	</head>
	
	<body>
		<h4>상품 목록</h4>
		<table>
			<tr>
				<th style="width:80px">상품번호</th>
				<th>상품이름</th>
				<th style="width:100px">가격</th>
				<th style="width:90px">재고</th>
			</tr>
			<%for(Product product : list) {%>
			<tr> 
				<td><%=product.getNo()%></td>
				<td><a href="detail.jsp?product_no=<%=product.getNo()%>"><%=product.getName()%></a></td>
				<td><%=product.getPrice()%></td>
				<td><%=product.getStock()%></td>
			</tr>
			<%} %>
		</table>
		<div id="buttonGroup">
			<a href="write_form.jsp"><img src="../common/images/board/write.gif"/></a>
		</div>
	</body>
</html>