<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript" src="/GoodEduSystem/JS/jquery-1.10.2.js"></script>
<script type="text/javascript">
         $(document).ready(function(){
        	
        	 $(":button").click(function(){
        		$.post('/GoodEduSystem/servlet/Stu_SelectCourseServlet',$("form").serialize(),function(data){
        			 alert(data);
        	     });          
    		 });
        		$.ajaxError(function(event,jqXhr,opts){
           		 alert(jqXhr.status);
           	      });		
        		
         });
</script>
</head>
<body>
             <form >
               <table align="center" width=900 cellspacing=3 border=1>
                <tr><th colspan="6"  bgcolor="#B0E0E6">你可选修以下的课程：</th></tr>
                <tr bgcolor="#F0FFF0">
                    <td align="center">课程编号</td>
                    <td align="center">课程名称</td>
                   <td align="center">学分</td>
                    <td align="center">职工号</td>
                    <td align="center">授课老师</td>
                    <td align="center">选课</td>        
                </tr>
                   <c:forEach items="${availableCourses }"  var="course">
                   <tr bgcolor="#F0FFF0">
                     <td align="center">${course.courseno}</td>
                     <td align="center">${course.coursename}</td>
                     <td align="center">${course.credit}</td>
                     <td align="center">${course.teano }</td>
                     <td align="center"><a href="/GoodEduSystem/servlet/Tea_QueryCourse2Servlet?courseno=${course.courseno}">${course.teaname }</a></td>   
                       <td align="center"> <input  type="checkbox"  name="class" value="${course.courseno }"> </td>         
                 </tr>
                </c:forEach>
                <tr><td align="center"  colspan=6><button id="submit"  type="button">提交选课</button><input type="button" value="Selections">
                                  <input type="submit">
           </table>
         </form>
</body>
</html>