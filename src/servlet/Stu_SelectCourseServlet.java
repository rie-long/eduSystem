package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Course;
import bean.Score;
import bean.Student;
import dao.CourseDAO;
import dao.ScoreDAO;

/**
 * Servlet implementation class Stu_SelectCourseServlet
 */
@WebServlet("/Stu_SelectCourseServlet")
public class Stu_SelectCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stu_SelectCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("student");
		
		CourseDAO dao=new CourseDAO();
		 ArrayList<Course> list=dao.getAvailableCourse(student.getStuNO());
	   // System.out.print("This mothed has been executed!");
		session .setAttribute("availableCourses", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/student/stu_selectcourse.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("utf-8");
		String [] courseno=request.getParameterValues("class");
		  Student student=(Student) request.getSession().getAttribute("student");
		  Score[] scores=new Score[courseno.length];
		//  System.out.println(courseno.length);
		  for(int i=0;i<courseno.length;i++){
			  Score score=new Score();
			  score.setCourseno(courseno[i]);
			  score.setStuno(student.getStuNO());
			  scores[i]=score;
		  }
		  
		  ScoreDAO sdao=new ScoreDAO();
		  boolean info=sdao.insertScore(scores);
		  PrintWriter out=response.getWriter();
		  if(info){
			  out.print("选课成功!");
		  }else{
			  out.print("选课失败,请重新选课!");
			  
		  }
	}

}
