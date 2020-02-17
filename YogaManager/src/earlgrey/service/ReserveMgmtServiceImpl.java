package earlgrey.service;

import java.sql.SQLException;
import java.util.List;

import earlgrey.dao.ReserveMgmtDao;
import earlgrey.dao.ReserveMgmtDaoImpl;
import earlgrey.vo.ReserveVO;

public class ReserveMgmtServiceImpl implements ReserveMgmtService {
	private ReserveMgmtDao dao;
	
	public ReserveMgmtServiceImpl() {
		this.dao = new ReserveMgmtDaoImpl();
	}
	@Override
	public int insertReserve(ReserveVO reserve) {
		int row = -1;
		try {
			row = this.dao.insertReserve(reserve);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}
	

	@Override
	public ReserveVO read(String userid) throws SQLException {
		ReserveVO reserve= null;
		try {
			reserve = this.dao.selectReserve(userid);
		}catch(SQLException ex) {
			System.out.println(ex);
		}
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
		try {
			row = this.dao.deleteReserve(userid);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}
	


//	public int reservation(int userid, int hour) {
//		int row = -1;
//		try {
//			row = this.dao.insertReserve(reserve);
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//		return row;
 }
