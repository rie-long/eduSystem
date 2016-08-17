<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript"  src="/GoodEduSystem/JS/jquery-1.10.2.js"></script>
<script type="text/javascript">

    jQuery().ready(function(){
    //	alert($("form").serialize());
    	$(":button").click(function(){
    		$.post('/GoodEduSystem/servlet/Tea_EntryScore2Servlet',$("form").serialize(),function(result){
    		      alert(result);
    		      $(":text").each(function(){    	
    		    	  $(this).val(""); //  or this.value=""; 
    		      })
    		});
 	 	});
    });
  
   
</script>

</head>
<body onload="">
        <form name="entryForm" action="/GoodEduSystem/servlet/Tea_EntryScore2Servlet" method="post"> 
           <table align="center" width=900 cellspacing=3 border=1>
                <tr><th colspan="5"  bgcolor="#B0E0E6">欢迎前来登分：</th></tr>
                <tr bgcolor="#F0FFF0">
                    <td align="center">课程编号</td>
                    <td align="center">课程名称</td>
                   <td align="center">学生学号</td>
                    <td align="center">学生姓名</td>       
                       <td align="center">分数</td>  
                </tr>
              
                   <c:forEach  items="${t_scores }"  var="score">
                   <tr bgcolor="#F0FFF0">
                     <td align="center">${score.courseno}<input type="hidden" name="courseno" value="${score.courseno }"></td>
                     <td align="center">${score.courseName}</td>
                     <td align="center">${score.stuno}<input type="hidden" name="stuno" value="${score.stuno }"></td>
                     <td align="center">${score.stuName}</td>
                      <td align="center"><input type="text" size=10 name="grade"></td>        
                 </tr>
                   </c:forEach>
                   <tr ><td align="center" colspan="5">
                               <input type="submit" name="commit" value="save">
                               <input type="button"  name="submit" value="submit">
                              </td>
                      </tr>    
                 
           </table>
           </form>
       
</body>
</html>