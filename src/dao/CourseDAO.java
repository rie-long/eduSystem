package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Course;

public class CourseDAO extends DAO {
           public ArrayList<String> getAllCourseName(){
        	   ArrayList<String>  nameList=new ArrayList<String>();
        	   String sql="select coursename from t_course";
        	   try {
				    Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			        ResultSet rs=st.executeQuery(sql);
			        while (rs.next()) {
						  nameList.add(rs.getString(1).trim());
						
					}
        	   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   super.releaseConn();
        	   return nameList;
           }
           
           public ArrayList<Course> getAvailableCourse(String stuno){
        	   ArrayList<Course> courses=new ArrayList<Course>();
        	   String sql="select * from t_course A join t_teacher B on A.teano=B.teano"
        			              +" where A.courseno not in (select courseno from t_score where stuno=?)";
        	   try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1,stuno);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Course course=new Course();
					course.setCoursename(rs.getString("coursename"));
					course.setCourseno(rs.getString("courseno"));
					course.setCredit(rs.getFloat("credit"));
					course.setTeano(rs.getString("teano"));
					course.setTeaname(rs.getString("teaname"));
					courses.add(course);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   super.releaseConn();
        	   return courses;
           }
           
           public Course getCourseByCourseno(String courseNO){
        	   Course course=new Course();
        	   String sql="select * from t_course A join t_teacher B on A.teano=B.teano where A.courseno=?";
        	   try {
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1, courseNO);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					
					course.setCoursename(rs.getString("coursename"));
					course.setCourseno(rs.getString("courseno"));
					course.setCredit(rs.getFloat("credit"));
					course.setTeano(rs.getString("teano"));
					course.setTeaname(rs.getString("teaname"));
				 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	      super.releaseConn();
	        	   return course;
           }
           
           public ArrayList<Course> getCourseByStuno(String stunno){
        	   ArrayList<Course> courses=new ArrayList<Course>();
        	   String sql="select * from t_course A join t_score B on  A.courseno=B.courseno "
        	   		+ " join t_teacher C on A.teano=C.teano where B.stuno=?";
        	   try {
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1, stunno);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					Course course=new Course();
					course.setCoursename(rs.getString("coursename"));
					course.setCourseno(rs.getString("courseno"));
					course.setCredit(rs.getFloat("credit"));
					course.setTeano(rs.getString("teano"));
					course.setTeaname(rs.getString("teaname"));
					courses.add(course);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   super.releaseConn();
        	   return courses;
           }
           
           public ArrayList getCourseByTeano(String teano){
        	   ArrayList<Course> courses=new ArrayList<Course>();
        	   String sql="select * from t_course A join t_teacher B on A.teano=B.teano where B.teano=?";
        	   try {
				PreparedStatement st=conn.prepareStatement(sql);
				st.setString(1, teano);
				ResultSet rs=st.executeQuery();
				while(rs.next()){
					Course course=new Course();
					course.setCoursename(rs.getString("coursename"));
					course.setCourseno(rs.getString("courseno"));
					course.setCredit(rs.getFloat("credit"));
					course.setTeano(rs.getString("teano"));
					course.setTeaname(rs.getString("teaname"));
					courses.add(course);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   super.releaseConn();
        	   return courses;
        	   
           }
         
}
