package earlgrey.service;


import java.sql.SQLException;
import java.util.List;

import earlgrey.vo.ReserveVO;



public interface ReserveMgmtService {
	int insertReserve(ReserveVO reserve) throws SQLException;
	ReserveVO read(String userid) throws SQLException;
	List<ReserveVO> selectAllReserve() throws SQLException;
	int deleteReserve(String emaill) throws SQLException;
	int reservation(int userid) throws SQLException;
	
}
