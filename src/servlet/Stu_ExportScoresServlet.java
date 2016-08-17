package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Score;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class Stu_ExportScoresServlet
 */
@WebServlet("/Stu_ExportScoresServlet")
public class Stu_ExportScoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Stu_ExportScoresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String msg="成绩�";
          Rectangle r=new Rectangle(PageSize.A4);
          r.setBackgroundColor(BaseColor.WHITE);
          Document doc=new Document(r);
          String realPath=this.getServletContext().getRealPath("/res/report");
     //     System.out.print(realPath);
          try {
			PdfWriter.getInstance(doc,new FileOutputStream(realPath+"/MyGradeForm.pdf"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          //创建中文字体
          BaseFont bf;
          Font font=null;
		try {
			bf = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
			  font=new Font(bf,20,Font.NORMAL);
	           //输出中文
	           Paragraph par=new Paragraph(msg,font);
	           par.setAlignment(Element.ALIGN_CENTER);
	           
	           doc.open();
	           doc.add(par);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
          
          PdfPTable table=new PdfPTable(5);
         
          table.setHorizontalAlignment(Element.ALIGN_CENTER);
          table.setSpacingBefore(10);
          table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
          table.getDefaultCell().setPadding(5);
          font.setSize(15);
          
          table.addCell(new Phrase("课程编号",font));
          table.addCell(new Phrase("课程名称",font));
          table.addCell(new Phrase("学生姓名",font));
          table.addCell(new Phrase("学生学号",font));
          table.addCell(new Phrase("成绩",font));
         
          
          font.setSize(10);
          HttpSession session=request.getSession();
          ArrayList al=(ArrayList) session.getAttribute("myScores");
          for(int i=0;i<al.size();i++){
       	   Score score=(Score) al.get(i);
              table.addCell(new Phrase(score.getCourseno(),font));
              table.addCell(new Phrase(score.getCourseName(),font));
              table.addCell(new Phrase(score.getStuName(),font));
              table.addCell(score.getStuno());
              table.addCell(String.valueOf(score.getScore()));
          }
          
         table.setSpacingAfter(10);
          try {
			doc.add(table);
			doc.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
          //告诉客户端出现下载提示框，并指定下载提示框中的文件名
          response.setHeader("Content-Disposition", "attachment;filename=MyGradeForm.pdf");
          //指定文件类型
          response.setContentType("application/pdf");
          response.setHeader("Cache-Control", "no-cache");
          RequestDispatcher rd=request.getRequestDispatcher("/res/report/MyGradeForm.pdf");
          rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
