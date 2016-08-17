package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.CourseDAO;

/**
 * Servlet implementation class Tea_EntryScore1Servlet
 */
@WebServlet("/Tea_EntryScore1Servlet")
public class Tea_EntryScore1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tea_EntryScore1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
	     ArrayList courses= null;
	     
		CourseDAO dao=new CourseDAO();
		 Teacher teacher=(Teacher) session.getAttribute("teacher");
		 courses=dao.getCourseByTeano(teacher.getTeaNO());
		session.setAttribute("t_courses", courses);
	     
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/teacher/tea_entryscore1.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}