<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operation panel for Student</title>
<style>
    a{ text-decoration:underline}
   tr{ height:50px})
   table{
     
   }
</style>
</head>
<body>
       <table bgcolor="#cdf2e3"  border=1>
                <tr > 
                       <td  colspan="2">
                       <img  src="/GoodEduSystem/res/image/img01.jpg"  width="100%"  height=100  id="pic" ></img></td>
                 </tr >
                 <tr >
                     <td width=10%   align="center" id="qc">
                           <a href="/GoodEduSystem/servlet/Stu_SelectCourseServlet" target="iframe">网上选课</a>
                     </td>
                      <td rowspan="8"> <iframe width=100% height=405 name="iframe" frameborder="0" src="/GoodEduSystem/jsp/container.jsp"></iframe>  </td>
                    </tr>
                    <tr >
                       <td width=10%    align="center">
                             <a href="stu_querycourse.jsp" target="iframe">选课结果</a>
                        </td>
                     </tr>
                     <tr >
                         <td width=10%   align="center">
                                <a href="stu_queryscore.jsp" target="iframe">查看成绩</a>
                         </td>
                       </tr >
                       <tr  >
                         <td width=10% align="center">
                               <a href="/GoodEduSystem/jsp/modifyPwd.jsp" target="iframe">修改密码</a></td>  
                         </tr>
                         <tr  >
                            <td  width=10% align="center">
                                 <a href="＃" >培养方案</a></td>
                            </tr>
                           <tr>
                               <td width=10%  align="center">
                                    <a href="" >论坛</a></td>
                            </tr>
                            <tr  > 
                               <td   width=10% align="center">
                                   <a href="/GoodEduSystem/servlet/LogoutServlet" >退出</a></td>     
                              </tr>   
                              <tr ><td align="center"><a href="/GoodEduSystem/index.jsp">返回</a></td></tr>
                              <tr   >
                               <td   colspan=2>
                                 <pre><font color="#556B2F">     ${type}:[${student.stuNO}]${student.name }                                                                   COPYRIGHT 2000-2010 BY  流殇  ALL RIGHTS RESERVED</font></pre> 
                                  </td>
                                </tr>
                                
                 </table>
</body>
</html>