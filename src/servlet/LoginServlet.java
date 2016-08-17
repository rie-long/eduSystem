package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import bean.Student;
import bean.Teacher;
import dao.DAO;
import dao.StudentDAO;
import dao.TeacherDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
	//	request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		String codeimg=request.getParameter("code");
		String url="";
	   
	     
		 PrintWriter out=response.getWriter();
		 HttpSession session=request.getSession();
		
		 String randStr=(String) session.getAttribute("randStr");
			if(!codeimg.equalsIgnoreCase(randStr)){
				out.print("F:<script>alert('验证码不正确！')</script>");
				return;
			}
			
			if(id.equals("teacher")){
				
				TeacherDAO teaDAO=new TeacherDAO();
				Teacher teacher=teaDAO.getTeacherByTeaNO(account);
				if(teacher!=null && teacher.getPassword().equals(password)){
					url="jsp/teacher/tea_ope.jsp";
					session.setAttribute("teacher", teacher);
					session.setAttribute("type", "教师");
				}else{
					out.print("F:<script>alert('密码错误！')</script>");
					   return;
				}
			}else if(id.equals("student")){
				StudentDAO stuDAO=new StudentDAO();
				Student student=stuDAO.getStudentByStuNO(account);
				if(student!=null && student.getPassword().equals(password)){
					session.setAttribute("student", student);
					session.setAttribute("type", "学生");
				    url="jsp/student/stu_ope.jsp";
				}else{
				out.print("F:<script>alert('密码错误！')</script>");
				   return;
			}
			}
		out.print(url);
	//	response.sendRedirect("/GoodEduSystem"+url);
		//ServletContext application=this.getServletContext();
		// RequestDispatcher rd=application.getRequestDispatcher(url);
	    //  rd.forward(request, response);
	}

}
