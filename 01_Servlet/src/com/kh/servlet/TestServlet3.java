package com.kh.servlet ;
import   java.io.* ;
import   javax.servlet.* ;
import   javax.servlet.http.* ;

public class TestServlet3 extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
      //  post방식일때  인코딩 설정
      request.setCharacterEncoding("UTF-8");
      
      String    name = request.getParameter("name") ;
      String    gender = request.getParameter("gender") ;
      String    age = request.getParameter("age")  ;
      String    city = request.getParameter("city") ;
      String    height = request.getParameter("height") ;
      String[] foodArr = request.getParameterValues("food") ; // values 배열로가져오는것
      String    recommendation = "" ;
      
      
      switch(age) {
       case "00대" : recommendation="곰인형"; break;
       case "10대" : recommendation="텀블러"; break;
       case "20대" : recommendation="스위치"; break;
       case "30대" : recommendation="초콜릿"; break;
       case "40대" : recommendation="화장품"; break;
       case "50대" : recommendation="마사지"; break;
      }
      
//      response.setContentType("text/html; charset=UTF-8") ;
//      PrintWriter out = response.getWriter() ;
//      out.println("<html>") ;
//      out.println("<head>") ;
//      out.println("<title>개인정보 출력화면</title>");
//      out.println("</head>") ;
//      out.println("<body>") ;
//      out.println("</body>") ;
//      out.println("</html>") ;
      
      request.setAttribute("name", name) ;
      request.setAttribute("gender", gender) ;
      request.setAttribute("age", age) ;
      request.setAttribute("city", city) ;
      request.setAttribute("height", height) ;
      String  food = String.join(",", foodArr) ;
      request.setAttribute("food", food) ;
      request.setAttribute("recommendation", recommendation) ;
      
//      현재 request라는 객체에 담긴 "~~~" 정보를 저장하고 있다가 그 다음 페이지에 해당 정보를 볼 수 있게 하는 기능 : RequestDispatcher 클래스
      RequestDispatcher view = request.getRequestDispatcher("servlet/testServlet3End.jsp") ; // 내가 보내기 위한 수단을 그냥 꺼내놓기만 하고 보내주는게 아님...
      view.forward(request,response) ;
      // ㄴ> 내가 view에게 보낼 값이 있으면, RequestDispatcher을 사용한다.
      
      
      // 응답하는것 2가지 sendRedirect , RequestDispatcher
      // 같은일을 하는데 두가지로 나뉜 이유는? 결국에 다른일을 한다 
      // sendRedirect : 아무것도 안들고 그냥 단순 페이지 이동만 한다.
     
      // 이전에 많은 데이터를 만들어 놨더라도 전에 데이터를 request에 담아놨다고 한들
      // 새로받은 페이지에서 request객체와 response객체를 새로 만들기 때문에,
      // 데이터를 아무리 담아봤자 의미가 없고 그저 이동만한다고 생각하면 된다.
      // ex) 정보를 서블릿에게 주고 > DB로 넘어가서 INSERT하면, INT값을 반환...(JDBC복습..좀..하기..)
      
      // 내가 돌아갈때 값이 있냐 없냐에 따라 sendRedirect/RequestDispatcher 를 사용할 수 있다
      
      // RequestDispatcher : request라는 객체를  가지고 원하는 쪽으로 이동을 한다.
      
     
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   { doGet(request,response); }
}