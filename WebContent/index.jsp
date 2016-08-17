<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务网络管理系统</title>
<script src="JS/jquery-1.10.2.js" type="text/javascript"></script>
<script type="text/javascript">
  
        $(document).ready(function(){
    /*    	$.ajaxSetup({contentTpye:"application/x-www-form-urlencoded;charset=utf-8"});
	        $("input[type='text']").css("background-color","#cdf2e3");
	        $(":text").focus(function(){
	        	alert('you have the focus!');
	        }); */
	          $(":button").click(function(){
		   /**       var id=$("select").val();
		          var account=$("input[name='account']").val();
		          var password=$("input[name='password']").val();
		          var code=$("input[name='code']").val(); */
		    $.post('/GoodEduSystem/servlet/LoginServlet',$("form").serialize(),function(result,status,hrx){
		    	                       content=hrx.responseText;
		    	                       msg=content.split(":");
		    	                       if(msg.length>1){
		                          	      $('#result').html(msg[1]);
		    	                       }else{
		    	                    //	   alert(content);
		    	                    	   location.href=content;
		    	                       }
		         });   
		     
	       }) ;  
	          $("input[name='code']").keypress(function(event){
	        	  if(event.keyCode==13){
	        		 
	        		  $(":button").click();
	        	  }
	          });
	        	  
	          
	      //    alert($("form").serialize());
    });
  
  
     function screenWidth(){
    	 var  image=(document.images)[0];
    	   image.width= window.innerWidth;
     }
     
     function refresh(){
    	 var n=Math.floor(Math.random()*1000);
    	 document.loginForm.codeimg.src="/GoodEduSystem/res/validateCode/imageCode.jsp?arg="+n;
     }
     
</script>
<style type="text/css">
    #pic{
          width:100%
    }
    #bg{
        background-image: url(/GoodEduSystem/res/image/part02.jpg);
        background-position:100%;
        background-repeat:no-repeat;
    }
</style>
</head>
<body  onload ="">
      
        <div id="result"></div>
         <table bgcolor="#cdf2e3"  width="100%"  height="80%"> 
                <tr> 
                       <td  >
                       <img  src="/GoodEduSystem/res/image/part01.jpg"  width=""  height=256  id="pic" ></img></td>
                 </tr >
                 <tr  id="bg">
                    <td >
                             <form action="/GoodEduSystem/servlet/LoginServlet" method="post" name="loginForm">
                                    <table align="center">
                                          <tr>
                                               <td><div align="left">身份</div>
                                                       <select  name="id"  > 
                                                          <option value="student"  selected>学生</option>
                                                          <option value="teacher">教师</option>
                                                       </select></td>
                                                </tr>
                                                <tr>       
                                                       <td>
                                                         <div align="left" >帐号</div><input type="text"  name="account">
                                                         </td>
                                                    </tr>
                                                    <tr>     
                                                         <td>
                                                           <div align="left">密码</div><input type="password" name="password">
                                                           </td>    
                                                      </tr>
                                                      <tr>       
                                                           <td>
                                                                <div align="left">验证码</div><input type="text"  name="code" size="10">
                                                                  <a href="#" onclick="refresh()">看不清,换一张</a>
                                                            </td>
                                                         </tr>  
                                                            <tr>
                                                            <td><div  align="center">
                                                            <img src="/GoodEduSystem/res/validateCode/imageCode.jsp" name="codeimg">
                                                            </div></td>
                                                            </tr>
                                                            <tr>
                                                            <td align="center"><input type="reset" value="重置"> 
                                                                      <input type="button"  value="登陆">
                                                                      </td>
                                                            </tr>             
                                    </table>
                             </form>
                    </td>
                  
                 </tr>
                 
                 <tr>
                      <td><img alt="" src="/GoodEduSystem/res/image/part03.jpg" id="pic"></td>
                  </tr>
         </table>
</body>
</html>