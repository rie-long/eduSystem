package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Teacher;

public class TeacherDAO extends DAO{
        public Teacher getTeacherByTeaNO(String teaNO){
        	Teacher teacher=null;
        	ResultSet rs=null;
        	String sql="select * from t_teacher where teano=?";
        	try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, teaNO);
				rs=ps.executeQuery();
			    if(rs.next()){
			    	teacher=new Teacher();
			    	 teacher.setTeaNO(rs.getString(1));
			    	 teacher.setPassword(rs.getString(2));
			    	 teacher.setName(rs.getString(3));
			    	 teacher.setSex(rs.getString(4));
			    	 teacher.setTitle(rs.getString(5));
			    }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	super.releaseConn();
        	return teacher;
        }
        
        public  boolean teacherUpdate(String password, String teaNo,String oldPassword){
        	int row=0;
        	String sql="update t_teacher set teapwd=? where teano=? and teapwd=?";
        	try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, password);
				ps.setString(2, teaNo);
				ps.setString(3, oldPassword);
				row=ps.executeUpdate();
				super.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	super.releaseConn();
        	if(row>0){
        		return true;
        	}else{
        		return false;
        	}
        }
}
