package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDAO;
import dao.TeacherDAO;

/**
 * Servlet implementation class ModifyTeacherPwdServlet
 */
@WebServlet("/ModifyTeacherPwdServlet")
public class ModifyPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		String oldPwd=request.getParameter("oldPwd");
		String pwd=request.getParameter("pwd");
		String newPwd=request.getParameter("newPwd");
	    String id= (String) session.getAttribute("type");
	    boolean done;
	    if(!pwd.equals(newPwd)){
	    	out.print("password didn't match");
	    	return;
	    }
	    
	    if(id.equals("ΩÃ ¶")){
	    	Teacher teacher=(Teacher) session.getAttribute("teacher");
	    	TeacherDAO tdao=new TeacherDAO();
			 done=tdao.teacherUpdate(pwd, teacher.getTeaNO(),oldPwd);
	    }else{
	    	Student student=(Student) session.getAttribute("student");
	    	StudentDAO sdao=new StudentDAO();
	    	done=sdao.updateStudent(pwd, student.getStuNO(), oldPwd);
	    }
		
		if(done){
			out.print("login success!");
		}else{
			out.print("login fail!");
		}
		
	}

}
