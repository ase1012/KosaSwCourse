package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceGetPostServlet extends HttpServlet{

/*	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		//요청 방식과 상관없이 항상 동일한 응답을 제공할 경우
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청 방식이 GET일 경우에 응답을 제공할 경우
		System.out.println("Get 방식으로 요청하셨네요.");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청 방식이 POST일 경우에 응답을 제공할 경우
		System.out.println("Post 방식으로 요청하셨네요.");

	}
}
