package earlgrey.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import earlgrey.vo.ReserveVO;

public class ReserveMgmtDaoImpl implements ReserveMgmtDao {

	@Override
	public int insertReserve(ReserveVO reserve) throws SQLException {
		Connection conn = DBConnection.getConnection("mariadb.properties"); //3
		String sql = "{   call  _insertreserve_sp(?, ?,?)   }";
		CallableStatement cstmt = conn.prepareCall(sql);   //4. 
		cstmt.setString(1,teachername );
		cstmt.setString(2, date);
		cstmt.setString(3, hour);
		int row = cstmt.executeUpdate();
		DBClose.close(conn, cstmt);  //6.
		return row;
	}

	@Override
	public ReserveVO selectReserve(String userid) throws SQLException {
		ReserveVO reserve = null;
		Connection conn = DBConnection.getConnection("mariadb.properties");  //3.
		String sql = "{  call reserve_select_sp(?, ?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, userid);
		cstmt.registerOutParameter();
		cstmt.execute();  
		ResultSet rs = (ResultSet)cstmt.getObject(2);
		if(rs.next()) { 
			reserve = new ReserveVO(rs.getString("userid"), rs.getString("teachername"),
					 rs.getString("date"),rs.getString("hour"));
		}
		DBClose.close(conn, cstmt, rs);
		return reserve;
	}

	@Override
	public List<ReserveVO> selectAllReserve() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteReserve(String userid) throws SQLException {
		int row = -1;
		Connection conn = DBConnection.getConnection("mariadb.properties");  //3.
		String sql = "{ call reserve_delete_sp(?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);  //4.
		cstmt.setString(1,userid);
		row = cstmt.executeUpdate();
		DBClose.close(conn, cstmt);  //6.
		return row;
	}

	@Override
	public int reservation(int userid, int hour) throws SQLException {
		int row = -1;
		return row;
	}
	
}
