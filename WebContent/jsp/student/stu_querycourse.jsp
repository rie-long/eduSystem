<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="dao.CourseDAO"%>
 <%@ page  import="java.util.*" %>
 <%@page import="bean.Student" %>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看选课结果</title>
</head>
<body>
             <%
                    Student student=(Student)session.getAttribute("student");
                    CourseDAO cdao=new CourseDAO();
                    ArrayList courses=cdao.getCourseByStuno(student.getStuNO());
                    session.setAttribute("selectedCourses", courses);
             %>
             
               <table align="center" width=900 cellspacing=3 border=1>
                <tr><th colspan="5"  bgcolor="#B0E0E6">你选修了以下的课程：</th></tr>
                <tr bgcolor="#F0FFF0">
                    <td align="center">课程编号</td>
                    <td align="center">课程名称</td>
                   <td align="center">学分</td>
                    <td align="center">职工号</td>
                    <td align="center">授课老师</td>        
                </tr>
                   <c:forEach items="${selectedCourses }"  var="course">
                   <tr bgcolor="#F0FFF0">
                     <td align="center">${course.courseno}</td>
                     <td align="center">${course.coursename}</td>
                     <td align="center">${course.credit}</td>
                     <td align="center">${course.teano }</td>
                     <td align="center"><a href="/GoodEduSystem/servlet/Tea_QueryCourse2Servlet?courseno=${course.courseno}">${course.teaname }</a></td>   
                                    
                 </tr>
                </c:forEach>
           </table>
</body>
</html>