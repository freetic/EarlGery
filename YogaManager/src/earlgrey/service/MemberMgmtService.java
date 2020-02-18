package earlgrey.service;


import earlgrey.vo.MemberVO;

public interface MemberMgmtService {
	int register(MemberVO member);
	int login(String userid, String passwd);
//	int insertReservation(int row);
//	MemberVO read(String email);
	int deleteReservation(int recordid);

}
