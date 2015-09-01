<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			*{
				margin:0px;
				padding:0px;
			}
			body{
				width:900px;
				margin:0 auto;
				background:url("http://c2down.cyworld.co.kr/download?fid=64222e0ad628ad41ee6f2e36b288460b&name=45181_11.jpg"); 
				background-attachment:fixed;
			}
			#page-wrapper{
				background-color: #E1E1E1;
				margin:40px 0px;
				padding:10px 20px;
				border-radius:10px;
			}
			header{
				border-radius:10px;
				background-color:#A5A5A5;
				margin-bottom: 10px;
				padding:5px;
			}
			nav{
				display:flex;
				flex-dereciton:row;
				border-top: 1px solid #C8C8C8;
				border-bottom: 1px solid #C8C8C8;
			}			
			.menu{
				width:70px;
				margin:5px;
				
			}
			#content{
				height:400px;
				display:flex;
				flex-direction:row;
			}
			aside{
				height:400px;
				width:250px;
				border-right: 1px solid #C8C8C8;
				overflow:scroll;
			}
			section{
				height:400px;
				flex:1;
			}
			iframe{
				border:0px solid white;
			}
			footer{
				height:50px;
				border-top:1px solid #C8C8C8;
			}
			#category>a{
					margin:5px;
					width:220px;
					background-color: #6C9FFF;
					border-radius:10px;
					display:block;
					line-height:20px;
					text-align:center;
					height:100%;
					text-decoration:none;
					color:white;					
			}
			#category>a:hover{
				background-color:#1266FF;
			}
		</style>
	</head>
	
	<body>
		<div id="page-wrapper">
			<header>
				<h1>JspProgramming</h1>
			</header>
			<nav>
				<div class="menu">Menu1</div>
				<div class="menu">Menu2</div>
				<div class="menu">Menu3</div>
				<div class="menu">Menu4</div>
				<div class="menu">Menu5</div>
			</nav>
			<div id="content">
				<aside>
					<div id="category">
						<p class="chapter">[Ch04 : 서블릿]</p>
						<a href="HelloWorldServlet1" target="iframe">3.0 방식으로 등록</a>
						<a href="HelloWorldServlet2" target="iframe">이전 방식으로 등록</a>
						<a href="HelloWorldServlet3" target="iframe">load on startup</a>
						<a href="HelloWorldServlet4" target="iframe">외부 정보 받기</a>
						<a href="ch04/service_get_post.jsp" target="iframe">요청 방식별 처리</a>
						<a href="LoginServlet" target="iframe">요청 처리 및 응답 보내기</a>
					
						<p class="chapter">[Ch05 : JSP 기초 문법]</p>
						<a href="ch05/comment.jsp" target="iframe">주석</a>
						<a href="ch05/directives/index.jsp" target="iframe">지시어</a>
						<a href="ch05/action/index.jsp" target="iframe">표준 액션</a>
						<a href="ch05/dec_express/scriptlet1.jsp" target="iframe">스크립트릿1</a>
						<a href="ch05/dec_express/scriptlet2.jsp" target="iframe">스크립트릿2</a>
						<a href="ch05/dec_express/calc3.jsp" target="iframe">선언문</a>
						
						<p class="chapter">[Ch06 : JSP 내장 객체]</p>
						<a href="ch06/builtin_object.jsp" target="iframe">JSP 내장 객체 개요</a>
						<a href="ch06/request/index.jsp" target="iframe">request</a>
						<a href="ch06/response/index.jsp" target="iframe">response</a>
						<a href="ch06/cookie/index.jsp" target="iframe">cookie</a>
						<a href="ch06/session/index.jsp" target="iframe">session</a>
						<a href="ch06/application/index.jsp" target="iframe">application</a>
						<a href="ch06/homework1/login.jsp" target="iframe">기본실습1</a>
						<a href="ch06/homework2/twitter_login.jsp" target="iframe">응용실습1</a>
						
						<p class="chapter">[Ch07 : JSP 자바 빈즈]</p>
						<a href="ch07/dto.jsp" target="iframe">DTO 이용 방법</a>
						<a href="ch07/dto_auto_setting.jsp" target="iframe">DTO 값 저장</a>
						<a href="ch07/bean_scope.jsp" target="iframe">빈의 사용 범위</a>
						<a href="ch07/database_form.jsp" target="iframe">데이터베이스 연동</a>

						<p class="chapter">[Ch10 : 표현 언어]</p><br/>
						
						<p class="chapter">[Ch11 : JSTL]</p>
						<a href="ch11/forEach.jsp" target="iframe">&lt;c : forEach&gt;</a>
						
						<p class="chapter">[실습01 : 게시판]</p>
						<a href="exam01/list.jsp" target="iframe">게시판 목록</a>
						
						<p class="chapter">[실습02 : 상품게시판]</p>
						<a href="exam02/list.jsp" target="iframe">게시판 목록</a>
						
						<p class="chapter">[실습03 : MVC 게시판]</p>
						<a href="mvc/board?action=list" target="iframe">게시판 목록</a>

					</div>
				</aside>
				<section >
					<iframe name="iframe" width="100%" height="100%">
							
					</iframe>
				</section>
			</div>
			<footer>
				An SaeEun
			</footer>
		</div>
	</body>
</html>