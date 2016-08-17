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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import bean.ScoreSession;
import dao.ScoreDAO;

/**
 * Servlet implementation class Tea_QueryScore2Servlet
 */
@WebServlet("/Tea_QueryScore2Servlet")
public class Tea_QueryScore2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tea_QueryScore2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String courseno=(String) request.getParameter("courseno");
			
			HttpSession session=request.getSession();
			String graphURL= "";
			
			ScoreDAO dao=new ScoreDAO();
			ArrayList sessions=dao.getScoreSessionByCourseno(courseno);
			String courseName="";
			   DefaultCategoryDataset dataset=new DefaultCategoryDataset();
			  for(int i=0;i<sessions.size();i++){
				ScoreSession ss=(ScoreSession) sessions.get(i);
				dataset.addValue(ss.getNumber(), ss.getSession(), ss.getSession());
				courseName=ss.getCourseName();
			   
			  JFreeChart chart=ChartFactory.createBarChart3D(courseName+"成绩分布","成绩" , "人数", dataset, PlotOrientation.VERTICAL, true, false, false);
			 chart.setAntiAlias(true);
			  String fileName=ServletUtilities.saveChartAsPNG(chart, 700, 350, session);
			  graphURL="/GoodEduSystem/servlet/DisplayChart?filename="+fileName;
			  session.setAttribute("URL", graphURL);
		    }
			
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/teacher/tea_queryscore2.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
