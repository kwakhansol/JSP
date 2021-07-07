<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- page지시어 : 현재 JSP페이지를 처리하는데 필요한 각종 속성을 기술하는 부분 -->
  
  <%  
    	String name = (String) request.getAttribute("name");
    	String age = (String) request.getAttribute("age");
    	String city = (String) request.getAttribute("city");
    	String height = (String) request.getAttribute("height");
    	String gender = (String) request.getAttribute("gender");
    	String food = (String) request.getAttribute("food");
    	String recommendation = (String)request.getAttribute("recommendation");		
    	// 형변환 해주는이유는 반환값이 오브젝트이기 때문
   %>
    <!-- scriptlet, 자바 코드를 넣는곳 -->
    <!-- 화면기반페이지에 자바 코드를 넣는것 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	h2{color:red;}
	span.name{color:orange; font-weight:bold;}
	span.gender{color:yellow; font-weight:bold; background: black;}
	span.age{color:green; font-weight:bold;}
	span.city{color:blue; font-weight:bold;}
	span.height{color:navy; font-weight:bold;}
	span.food{color:purple; font-weight:bold;}

</style>
<title>개인 취향 테스트 결과 </title>
</head>
<body>
	<h2>개인 취향 테스트 결과 (POST)</h2>
	<span class='name'><%= name %></span>님은  <%-- %s = name이 들어가야하기 때문에 변경함  %= 을 표현식으로 부를껀데
	 표현식은 뭘할꺼냐면, 자바에있는 name을 가져와서 화며 브라우저에 출력하기위해 표현식을 써주는 것 --%>
	 <!-- 아무한테도 안보여주고, 코드로만 보여주고 싶은 주석은 <%-- --%> 을 사용하면 된다. -->
	 
	<span class='age'><%= age %></span>이시며  <!-- %s = age -->
	<span class='city'><%= city %></span>에 사는  <!-- %s = city -->
	키는 <span class='height'><%= height %></span>cm인  <!-- %s = height -->
	<span class='gender'><%= gender %></span>입니다.  <!-- %s = gender -->
	좋아하는 음식은<span class='food'><%= food%></span> 입니다. 
	
	
	<h3><%= age %>에 맞는 선물 추천</h3>
	'<%= recommendation %>' 선물은 어떠신가요?
	
	<!-- page not found exception은 action 부분과 servlet부분  -->
</body>
</html>