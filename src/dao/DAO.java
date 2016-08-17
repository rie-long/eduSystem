package dao;


import java.sql.*;
public class DAO {
	
	
	String url="jdbc:mysql://localhost/goodedu";
	String userName="root";                          
	String passWord ="long";                         
	Connection conn=null;                            
	Statement stmt=null;                             
	ResultSet rs=null;                                
	
	public DAO() {
		
        try {
        	Class.forName("org.gjt.mm.mysql.Driver");
			conn=DriverManager.getConnection(url,userName,passWord);
			                                                    
			conn.setAutoCommit(false) ;                           
			
			
			System.out.println("connect database successful");
	
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                   ResultSet.CONCUR_UPDATABLE);
        	
		} catch (SQLException e) {
			System.out.println("SQLException "+e.getMessage());
			                                                     
			e.printStackTrace();   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
	}
	
	public boolean validate(String No ,String password,String id){
		String sql="";
		PreparedStatement pt;
		ResultSet rs=null;
		if(id.equals("teacher")){
			
				sql="select count(*) from t_teacher where  teano=? and  teapwd=? ";
				
		}else if(id.equals("student")){
			
			    sql="select count(*) from t_student where  stuno=? and  stupwd=? ";
		
		}else{
			return false;
		}
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1, No);
			pt.setString(2, password);
			rs=pt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			 rs.next();
			int count=rs.getInt(1);
			if(count>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * @return ResultSet*/
	public ResultSet executeQuery(String sql) throws SQLException{
		try{
			
			  rs=stmt.executeQuery(sql);       
			  
		}catch(SQLException e){
			System.out.println("SQLException"+e.getMessage());
			conn.rollback();     //  
			
			e.printStackTrace();    //
			throw e;
		}
		return rs;
	}
	
	/*
	 * @throws SQLException */
	public int executeUpdate(String sql ) throws SQLException{
		int count=0;
		try {
			
			count=stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println("SQLException "+e.getMessage());
			
			conn.rollback();          //
			e.printStackTrace();      //
		}
		return count;
	}
	
	/**
	 * @throws SQLException */
	public void commit() throws SQLException {
		try {
			conn.commit();          //
		} catch (SQLException e) {
            System.out.println("SQLException "+e.getMessage());
			
			conn.rollback();          //
			e.printStackTrace();      //
		}finally{
	//		releaseConn();           //
		}
	}
	
	/***/
    public void releaseConn(){
    	try {
			stmt.close();            //
			if(conn!=null){
				conn.close();        //
			}
		} catch (SQLException e) {
			
            System.out.println(e.getMessage());
			
			e.printStackTrace();      //
		
		}
    }
 	public static void main(String arg[]){
		
		
		DAO connection=new DAO();
		try {
		     ResultSet result=connection.executeQuery("show tables");
			 while(result.next()){
				 
				 System.out.println(result.getString(1));
			
					
				}
			boolean  b=  connection.validate("0009","1212", "teacher");
			System.out.println(b);
		//	connection.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
