package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpServletRequest : 웹 브라우저에서 사용자가 요청한 내용을 받아주는 용도
		// HttpServletResponse : 처리한 결과를 사용자에게 보여주기 위한 용도
		String name = request.getParameter("name"); // 반환값은 스트링값이다
		System.out.println("이름은 무엇 입니까? : " + name);
		
		String gender = request.getParameter("gender");
		System.out.println("성별은 무엇입니까? : " + gender);
		
		String age = request.getParameter("age");
		System.out.println("연령대는 어떻게 됩니까? : ");
		
		String city = request.getParameter("city");
		System.out.println("사는 도시는 어디입니까? : " + city);
				
		String height = request.getParameter("height");
		System.out.println("키는 몇입니까? : " + height);
		
		String[] foodArr = request.getParameterValues("food");
		
		for(int i=0; i< foodArr.length; i++) {
			System.out.println("foodArr["+ i + "] : " + foodArr[i]);
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
		// 이거에 대해서 화면에 다시 뿌려줄거에요 > 응답할거임
		// response.getWriter(); // 화면에 받아온 데이터를 새로 보내줄것 얘의 반환값 print writer
		PrintWriter pw = response.getWriter();
		// 구조 새로 짜주는것
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>개인정보출력화면</title>");
		pw.println("<style>");
		pw.println("h2{color:red;}");
		pw.println("span.name{color:orange; font-weight:bold;}");
		pw.println("span.gender{color:yellow; font-weight:bold;}");
		pw.println("span.age{color:green; font-weight:bold;}");
		pw.println("span.city{color:blue; font-weight:bold;}");
		pw.println("span.height{color:navy; font-weight:bold;}");
		pw.println("span.food{color:purple; font-weight:bold;}");
		pw.println("</style>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h2>개인 취향 테스트 결과 (GET)</h2>");
		pw.printf("<span class='name'>%s</span>님은",name);
		pw.printf("<span class='age'>%s</span>이시며",age);
		pw.printf("<span class='city'>%s</span>에 사는", city);
		pw.printf("키 <span class='height'>%s</span>cm인", height);
		pw.printf("<span class='gender'>%s</span>입니다." ,gender);
		pw.printf("좋아하는 음식은<span class='food'>");
		for(int i=0; i < foodArr.length; i++) {
			if(i == 0) {
				pw.printf("%s", foodArr[i]);
			} else {
				pw.printf(",%s", foodArr[i]);
			}
		}
		pw.println("</span>입니다.");
		pw.println("</body>");
		pw.println("</html>");
		
	}
	
	
	
	
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	//우리가 겟방식을 보냈기때문에 우리가 제출한 정보들이 쿼리스트링에 담긴다.
	// 쿼리스트링에는 name으로 담긴다. 우리는 이제 그 name안에 들어가는 애들을 파라믹터값이라고 부를거다.

}
