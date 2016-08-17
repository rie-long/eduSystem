<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
     function exportPDF(){
    	 window.open("/GoodEduSystem/servlet/Tea_ExportScoreServlet");
     }
</script>
</head>
<body>
        <table align="center" width=900 cellspacing=3 border=1>
                <tr><th colspan="5"  bgcolor="#B0E0E6">课程信息如下：</th></tr>
                <tr bgcolor="#F0FFF0">
                    <td align="center">课程编号</td>
                    <td align="center">课程名称</td>
                   <td align="center">学生学号</td>
                    <td align="center">学生姓名</td>       
                       <td align="center">分数</td>  
                </tr>
                   <c:forEach  items="${t_scores }"  var="score">
                   <tr bgcolor="#F0FFF0">
                     <td align="center">${score.courseno}</td>
                     <td align="center">${score.courseName}</td>
                     <td align="center">${score.stuno}</td>
                     <td align="center">${score.stuName}</td>
                      <td align="center">${score.score}</td>        
                 </tr>
                   </c:forEach>
                   <tr ><td align="center" colspan="5"><button id="export" onclick="exportPDF()">导出</button></td></tr>
           </table>
</body>
</html>