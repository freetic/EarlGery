package earlgrey.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import earlgrey.vo.MemberVO;
import earlgrey.vo.ReserveVO;

public class MemberMgmtDaoImpl implements MemberMgmtDao {
	
	@Override
	public int register(MemberVO member) throws SQLException {
		Connection conn = DBConnection.getConnection("config/mariadb.properties"); //3
		String sql = "{   call  sp_member_insert(?, ?,?,?)   }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4. 
		cstmt.setString(1, member.getEmail());
		cstmt.setString(2, member.getPwd());
		cstmt.setString(3, member.getName());
		cstmt.setString(4, member.getPhone());
		int row = cstmt.executeUpdate();
		DBClose.close(conn, cstmt);  //6.
		return row;
	}
	@Override
	public int login(String userid, String passwd) throws SQLException {
		Connection conn = DBConnection.getConnection("config/mariadb.properties"); //3.
		String sql = "{ call sp_member_login_email(?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4.
		cstmt.setString(1, userid);
		ResultSet rs = cstmt.executeQuery();
		
		int iNumber=0;
		int number = -2;
		rs.next();
			if(rs.getInt("success")==1) {
				 iNumber = 1;
			}else  iNumber = 0;
		
		sql = "{ call sp_member_login_pwd(?)  }";
		cstmt = conn.prepareCall(sql);   //비밀번호 비교 추가
		cstmt.setString(1, passwd);
		rs = cstmt.executeQuery();
		int pNumber = 0;	
		rs.next();
		if(rs.getInt("success")==1) {
			pNumber = 1;}else pNumber =0;
		
		
		if(pNumber ==1&& iNumber ==1) {
			number = 1;
		}else if(iNumber == 0) {
			number = -1;
		}else if(pNumber == 0) {
			number = 0;
		}
		//		int number = -2;
//		if(!rs.next()) {  
//			number = -1;
//		}else {  
//			String dbPwd = rs.getString("pwd").trim();
//			if(dbPwd.equals(passwd))   number = 1;
//			else number = 0;
//		}
		DBClose.close(conn, cstmt, rs);
		
		
		//7.
		return number;
	}
<<<<<<< HEAD
	
	@Override
	public int deleteReservation(int recordid) throws SQLException {
		Connection conn = DBConnection.getConnection("config/mariadb.properties");
		int row = -1;
		String sql = "{ call sp_reservation_cancel(?) }";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, recordid);
		row = cstmt.executeUpdate();
		DBClose.close(conn, cstmt);
		return row;
	}
}
	
=======
//	public ArrayList<ReserveVO> list(String email){
//		Connection conn = DBConnection.getConnection("config/mariadb.properties"); //3.
//		String sql = "{ call sp_member_search_reservation(?)}";
//		CallableStatement cstmt = conn.prepareCall(sql);   //4. 
//		cstmt.setString(1,email);
//		ResultSet rs = cstmt.executeQuery();
//		rs.next();
//		int lectureid = rs.getInt("letureid");
//		sql = "SELECT empno, leturetime FROM lecture";
//		Statement stmt = null;
//		ArrayList<ReserveVO> list = new<ReserveVO> ArrayList();
////		\
////		Statement stmt = null;
////		ResultSet rs = null;
////		Connection conn = null;
////		try {	
////			conn = DBConnection.getConnection("oracle.properties");
////			stmt = DBConnection.conn.createStatement();
////			rs = stmt.executeQuery(sql);//5.
////			
////			
////			while(rs.next()) {//6.
////				System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\t\n",
////						rs.getInt("employee_id"), rs.getString("last_name"), rs.getString("email"), 
////						rs.getDate("hire_date"), rs.getString("department_name"), rs.getString("city"));
////			}
////		}catch (SQLException e) {
////			System.out.println("Connection Faliure");
////			e.printStackTrace();
////		}finally {
////			DBClose.close(conn, stmt, rs);
////		}
////	
//		
//		return list;
//	}
		
//	
//	public int reserve(ReserveVO reservation) {
//		Connection conn = DBConnection.getConnection("config/mariadb.properties"); //3.
//		String sql = "{ call sp_get_empno_from_name(?)}";
//		CallableStatement cstmt = conn.prepareCall(sql);   //4. 
//		cstmt.setString(1, reservation.getTeachername());
//		ResultSet rs = cstmt.executeQuery();
//		rs.next();
//		int empno = rs.getInt("empno");
//		sql = "{ sp_teacher_search_lecture(?) }";
//		java.util.Date dt = new java.util.Date();
//		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////		String currentTime = sdf.format(dt);
////		
////		CallableStatement cstmt = conn.prepareCall(sql);   //4.
////		cstmt.setString(1, userid);
////		
////		 sql = "{ call sp_member_reserve(?,?)  }";
////		
////	}
////	
//	}
}
>>>>>>> bb2c636c4e73ce9c66884e35d24efc077808b9a4
