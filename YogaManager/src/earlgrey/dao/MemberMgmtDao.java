package earlgrey.dao;

import java.sql.SQLException;
import earlgrey.vo.MemberVO;

public interface MemberMgmtDao {
	int register(MemberVO member) throws SQLException;
	int login(String userid, String passwd) throws SQLException;
//	int insertReservation(String teachername,String date,String hour) throws SQLException;
//	MemberVO selectReservation(String email) throws SQLException;
//	int deleteReservation(String email) throws SQLException;
}
