<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import ="dao.ScoreDAO" %>
    <%@page import="bean.Student" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/GoodEduSystem/JS/jquery-1.10.2.js"></script>
<script type="text/javascript">
      $(document).ready(function(){
    	  $(":button").click(function(){
    		
    			  window.open(  "/GoodEduSystem/servlet/Stu_ExportScoresServlet");
    		  });
    	 
      })
</script>
</head>
<body>
         <%
                    Student student=(Student)session.getAttribute("student");
                    ScoreDAO cdao=new ScoreDAO();
                    ArrayList scores=cdao.getScoreByStuno(student.getStuNO());
                    session.setAttribute("myScores", scores);
             %>
             
               <table align="center" width=900 cellspacing=3 border=1>
                <tr><th colspan="5"  bgcolor="#B0E0E6">你选修了以下的课程：</th></tr>
                <tr bgcolor="#F0FFF0">
                    <td align="center">课程编号</td>
                    <td align="center">课程名称</td>
                   <td align="center">学生学号</td>
                    <td align="center">学生姓名</td>
                    <td align="center">成绩</td>        
                </tr>
                   <c:forEach items="${myScores }"  var="score">
                   <tr bgcolor="#F0FFF0">
                     <td align="center">${score.courseno}</td>
                     <td align="center">${score.courseName}</td>
                     <td align="center">${score.stuno}</td>
                     <td align="center">${score.stuName}</td>
                     <td align="center">${score.score }</td>                            
                 </tr>
                </c:forEach>
                <tr><td colspan=5 align="center"><input type="button" value="导出成绩表" >
           </table>
           <div id="result"></div>
</body>
</html>