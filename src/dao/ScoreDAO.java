package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;







import bean.Score;
import bean.ScoreSession;

public class ScoreDAO  extends DAO{
       public ArrayList getScoreByCourseno(String courseno){
    	   ArrayList<Score> scores=new ArrayList<Score>();
    	    String sql="select C.coursename, A.stuno, A.score,B.stuname ,A.sort from t_score A join t_student B on A.stuno=B.stuno"
    	    		+ " join t_course C on C.courseno=A.courseno where A.courseno=?";
    	    try {
				PreparedStatement  ps=conn.prepareStatement(sql);
				ps.setString(1, courseno);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Score score=new Score();
					score.setCourseName(rs.getString(1));
					score.setStuno(rs.getString(2));
					score.setScore(rs.getFloat(3));
					score.setStuName(rs.getString(4));
					score.setType(rs.getString(5));
					score.setCourseno(courseno);
				   
					scores.add(score);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    super.releaseConn();
    	    return scores;
       }
       
       public ArrayList getScoreByStuno(String stuno){
    	   ArrayList<Score> scores=new ArrayList<Score>();
   	    String sql="select C.coursename, A.stuno, A.score,B.stuname ,C.courseno  from t_score A join t_student B on A.stuno=B.stuno"
   	    		+ " join t_course C on C.courseno=A.courseno where A.stuno=?";
   	    try {
				PreparedStatement  ps=conn.prepareStatement(sql);
				ps.setString(1, stuno);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Score score=new Score();
					score.setCourseName(rs.getString(1));
					score.setStuno(rs.getString(2));
					score.setScore(rs.getFloat(3));
					score.setStuName(rs.getString(4));
					score.setCourseno(rs.getString(5));
				
				   
					scores.add(score);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   	    super.releaseConn();
   	    return scores;
    	   
       }
       
       public ArrayList getScoreSessionByCourseno(String courseno){
    	   ArrayList<ScoreSession> sessions=new ArrayList<ScoreSession>();
    	   String sql ="select courseno,coursename, case when score between 0 and 60 then '0-60'"
    			   +" when score between 60 and 70 then '60-70'"
    			   +" when score between 70 and 80 then '70-80'"
    			   +" when score between 80 and 90 then '80-90'"
    			   +" else '90-100' end as 'session' ,count(*) 'number' from "
    			   +"(select B.courseno courseno,A.coursename coursename ,B.score score from "
    			   + "t_course A join t_score B on A.courseno=B.courseno where B.courseno=?) as se group by session";
    	   try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, courseno);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ScoreSession session=new ScoreSession();
				session.setCourseName(rs.getString("coursename"));
				session.setCourseNO(rs.getString("courseno"));
				session.setSession(rs.getString("session"));
				session.setNumber(rs.getInt("number"));
				sessions.add(session);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   super.releaseConn();
    	   return sessions;
       }
       
       public boolean insertScore(Score[] scores){
    	   String sql="insert into t_score (stuno,courseno,sort) values(?,?,?)";
    	   try {
			PreparedStatement ps=conn.prepareStatement(sql);
			for(int i=0;i<scores.length;i++){
				 
				  ps.setString(1, scores[i].getStuno());
				  ps.setString(2, scores[i].getCourseno());
				  ps.setString(3, "final");
				//  ps.executeUpdate();
				  ps.addBatch();
			}
			 int [] rs= ps.executeBatch();
			super.commit();
			super.releaseConn();
			if(rs.length==scores.length){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   return false;
       }
       
       public void updateScore(Score score){
    	   String sql="update t_score set score=?,state=? where courseno=? and stuno=?";
    	   try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setFloat(1,score.getScore());
			ps.setString(2, score.getState());
			ps.setString(3, score.getCourseno());
			ps.setString(4, score.getStuno());
			ps.executeUpdate();
			super.commit();
			super.releaseConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
}
