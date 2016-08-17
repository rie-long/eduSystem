<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
 <%@ page import="java.awt.*" 
          import="java.awt.image.BufferedImage" 
          import= "java.util.*"
          import="javax.imageio.ImageIO"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title></title>
</head>
<body>
    <%
       response.setHeader("Cache - Control", "no - cache");
       int width=70,height=25;
       BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
       Graphics g=image.getGraphics();
       g.setColor(new Color(200,200,200));
       g.fillRect(0, 0, width, height);
       
       String code="";
       for(int i=0;i<4;i++){
       int randNum=(int)(Math.random()*26+97);
       if(Math.random()>0.5){
    	   randNum-=32;
       }
       char c=(char)randNum;
        code=code+c;
       }
   //    String randStr=String.valueOf(code);
       
       session.setAttribute("randStr", code);
       
       g.setColor(Color.red);
       g.setFont(new Font("",Font.PLAIN,20));
       g.drawString(code, 10, 20);
       
       Random rnd=new Random();
       for(int i=0;i<50;i++){
    	   g.setColor(new Color(rnd.nextInt(225),rnd.nextInt(225),rnd.nextInt(225)));
    	   int x=(int)(Math.random()*width);
    	   int y=(int)(Math.random()*height);
    	   g.drawOval(x, y, 3, 2);
       }
       //输出图像到页面
       ImageIO.write(image,"JPEG",response.getOutputStream());
       out.clear();
       out=pageContext.pushBody();
       
    %>
</body>
</html>