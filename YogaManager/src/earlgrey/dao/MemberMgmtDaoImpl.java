package earlgrey.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import earlgrey.service.MemberMgmtServiceImpl;
import earlgrey.vo.MemberVO;

public class MemberMgmtDaoImpl implements MemberMgmtDao {
	
	@Override
	public int register(MemberVO member) throws SQLException {
		Connection conn = DBConnection.getConnection("config/oracle.properties"); //3
		String sql = "{   call  member_insert_sp(?, ?,?,?)   }";
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
		Connection conn = DBConnection.getConnection("config/oracle.properties"); //3.
		String sql = "{ call member_login_sp(?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4.
		cstmt.setString(1, userid);
		//cstmt.registerOutParameter(2, OracleTypes.CURSOR);
		cstmt.execute();      
		ResultSet rs = (ResultSet)cstmt.getObject(2);
		int number = -2;
		if(!rs.next()) {  
			number = -1;
		}else {  
			String dbPwd = rs.getString("passwd").trim();
			if(dbPwd.equals(passwd))   number = 1;
			else number = 0;
		}
		DBClose.close(conn, cstmt, rs);  //7.
		return number;
	}
}
	