package earlgrey.service;

import java.sql.SQLException;
import java.util.List;


import earlgrey.dao.MemberMgmtDao;

import earlgrey.dao.MemberMgmtDaoImpl;
import earlgrey.vo.MemberVO;

public class MemberMgmtServiceImpl implements MemberMgmtService {

private MemberMgmtDao dao;
	
	public MemberMgmtServiceImpl() {
		this.dao = new MemberMgmtDaoImpl();
	}
	
	@Override
	public int register(MemberVO member) {
		int row = -1;
		try {
			row = this.dao.register(member);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}

	@Override
	public int login(String email, String password) {
		int number = -2;
		try {
			number= this.dao.login(email, password);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return number;
	}

	
}
