package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Student;

public class StudentDAO extends DAO{

	public Student getStudentByStuNO(String account) {
		Student student=null;
		String sql="select * from t_student where stuno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				student=new Student();
				student.setName(rs.getString("stuname"));
				student.setPassword(rs.getString("stupwd"));
				student.setSex(rs.getString("stusex"));
				student.setStuNO(rs.getString("stuno"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
   
	public boolean updateStudent(String password,String stuNo,String oldPassword){
		String sql="update t_student set stupwd =? where stuno=? and stupwd=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, stuNo);
			ps.setString(3,oldPassword);
			int result=ps.executeUpdate();
			super.commit();
			super.releaseConn();
			if(result>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
