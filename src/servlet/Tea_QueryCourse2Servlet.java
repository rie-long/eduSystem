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

import dao.ScoreDAO;

/**
 * Servlet implementation class Tea_QueryCourse2Servlet
 */
@WebServlet("/Tea_QueryCourse2Servlet")
public class Tea_QueryCourse2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tea_QueryCourse2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseno=(String) request.getParameter("courseno");
	//	System.out.println("courseNO="+courseno);
		HttpSession session=request.getSession();
		ArrayList scores=null;
	
		ScoreDAO dao=new ScoreDAO();
		 scores=dao.getScoreByCourseno(courseno);
		session.setAttribute("t_scores", scores);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/teacher/tea_querycourse2.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
