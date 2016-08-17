<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Operation Panel For Teacher</title>
<script language="javascript" src="/GoodEduSystem/JS/jquery-1.10.2.js"></script>
<script type="text/javascript">
          
   var jq= $.noConflict();
    jq(document).ready(function($){
    //	  alert($==undefined);
    	    $(":button").click(function(){
    	    
    	       $(this).val("ssumit");
    	    	alert(this.value);
    	    	    
    	    });
    });
   
</script>
<style>
    a{ text-decoration:underline}
   tr{ height:50px})
   table{
       padding-left:0;
       padding-top:0;
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
                           <a href="/GoodEduSystem/servlet/Tea_QueryCourse1Servlet" target="iframe">查看课程</a>
                     </td>
                      <td rowspan="8"> <iframe width=100% height=405 name="iframe" frameborder="0" src="/GoodEduSystem/jsp/container.jsp"></iframe>  </td>
                    </tr>
                    <tr >
                       <td width=10%    align="center">
                             <a href="/GoodEduSystem/servlet/Tea_EntryScore1Servlet" target="iframe">录入成绩</a>
                        </td>
                     </tr>
                     <tr >
                         <td width=10%   align="center">
                                <a href="/GoodEduSystem/servlet/Tea_QueryScore1Servlet" target="iframe">成绩分布</a>
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
                                 <pre><font color="#556B2F">     ${type}:[${teacher.teaNO}]${teacher.name }                                                                   COPYRIGHT 2000-2010 BY  流殇  ALL RIGHTS RESERVED</font></pre> 
                                  </td>
                                </tr>
                                
                 </table>
          <!--         <input type="button" name="button"  id="btn" value="test"> -->
</body>
</html>