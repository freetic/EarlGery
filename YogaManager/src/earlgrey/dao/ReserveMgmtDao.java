package earlgrey.dao;

import java.sql.SQLException;
import java.util.List;

import earlgrey.vo.ReserveVO;





public interface ReserveMgmtDao {
	int insertReserve(ReserveVO reserve) throws SQLException;
	ReserveVO selectReserve(String emaill) throws SQLException;
	List<ReserveVO> selectAllReserve() throws SQLException;
	int deleteReserve(String emaill) throws SQLException;
	int reservation(int userid, int hour) throws SQLException;
}
