<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/GoodEduSystem/JS/jquery-1.10.2.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	$("a").click(function(){
    		   var n=Math.floor(Math.random()*1000);
    		 $("img").attr("src","/GoodEduSystem/res/validateCode/imageCode.jsp?index="+n);
    	});
    	
   /* 	$("input[name='oldPwd']").blur(function(){
    		    if(this.value==""){
    		    	alert("请输入旧密码！")
    		    }
    	});
    	
    	$("input[name='pwd']").blur(function(){
    		    if(this.value==""){
    		    	alert("请输入新密码！")
    		    }
    	});
    	
    	$("input[name='newPwd']").blur(function(){
		    if(this.value==""){
		    	alert("请再次输入新密码！")
		    }
	    }); */
    	
    	$(":button").click(function(){
    		var oldPwd=$("input[name='oldPwd']").val();
    		var pwd=$("input[name='pwd']").val();
    		var newPwd=$("input[name='newPwd']").val();
    		if(oldPwd=="" ){
    			alert("请输入旧密码！");
    			$("input[name='oldPwd']").focus();
    			return;
    		}else if(pwd==""){
    			   $("input[name='pwd']").focus();
    				alert("请输入新密码！");
    				return;
    		}else if(newPwd==""){
    			$("input[name='newPwd']").focus();
    			alert("请再次输入新密码！");
    			return;
    		}	
    		
    		$.post("/GoodEduSystem/servlet/ModifyPwdServlet",$("form").serialize(),function(data){
    			   alert(data);
    			   $(":reset").click();
    		});
    	});
    	
    	
    });
</script>
<style type="text/css">
     span{
           
             font-size:larger;
             color:purple;
     }
     caption{
          font-size:20pt;
          color : purple;
     }
     #text{
         text-align:right;
     }
</style>
</head>
<body>
        <br><br><br><br>
           <center>
                      <form>
                        <table >
                                   <caption>修改密码</caption>
                                   <tr><td id="text"><span>请输入原密码：</span></td><td><input type="password"  name="oldPwd" size=20></td></tr>
                                     <tr><td id="text"><span>请输入新密码：</span></td><td><input type="password" name="pwd"  size=20></td></tr>
                                       <tr><td id="text"><span>再次输入新密码：</span></td><td><input type="password"  name="newPwd" size=20></td></tr>
                                       <tr><td id="text"><span>验证码：</span></td><td><input type="password" size=10>
                                                        <a href="#" >看不清，换一张</a></td></tr>
                                       <tr><td colspan=2 align="center"><img alt="" src="/GoodEduSystem/res/validateCode/imageCode.jsp"></td></tr>
                                    <tr><td colspan=2 align="center"><input type="reset" value="重置"><input type="button" value="提交"></td></tr>
                        </table>
                                      
                        </form>
           </center>
</body>
</html>