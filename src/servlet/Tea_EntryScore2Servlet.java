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

import org.jfree.data.category.DefaultCategoryDataset;

import bean.Score;
import dao.ScoreDAO;

/**
 * Servlet implementation class Tea_EntryScore2Servlet
 */
@WebServlet("/Tea_EntryScore2Servlet")
public class Tea_EntryScore2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tea_EntryScore2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String courseno=(String) request.getParameter("courseno");
		
			HttpSession session=request.getSession();
			ArrayList scores=(ArrayList) session.getAttribute("t_scores");
			if(scores==null){
			ScoreDAO dao=new ScoreDAO();
			 scores=dao.getScoreByCourseno(courseno);
			session.setAttribute("t_scores", scores);
			}
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/teacher/tea_entryscore2.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setCharacterEncoding("utf-8");
		  String[] courseNos=request.getParameterValues("courseno");
		  String[] stunos=request.getParameterValues("stuno");
		  String[] scores=request.getParameterValues("grade");
	//	  System.out.println(stunos.length);
		  String operate=request.getParameter("commit");
		  if(operate==null){
			  operate="temp";
		  }
		  ScoreDAO dao=new ScoreDAO();
		  for(int i=0;i<scores.length;i++){
			  Score grade=new Score();
			  grade.setCourseno(courseNos[i]);
			  grade.setScore(Float.parseFloat(scores[i]));
			  grade.setState(operate);
			  grade.setStuno(stunos[i]);
			  dao.updateScore(grade);
		  }
	    PrintWriter out=response.getWriter();
	    out.print("数据上传完成�");
	}

}
