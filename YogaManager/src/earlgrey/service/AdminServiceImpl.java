package earlgrey.service;

import java.sql.SQLException;
import java.util.ArrayList;

import earlgrey.dao.AdminDao;
import earlgrey.dao.AdminDaoImpl;
import earlgrey.vo.MemberVO;
import earlgrey.vo.TeacherVO;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao;
	public AdminServiceImpl() {
		this.dao = new AdminDaoImpl();
	}
	@Override
	public MemberVO readMember(String email) throws SQLException {
		MemberVO member = null;
		member = this.dao.selectMember(email);
		return member;
	}
	@Override
	public ArrayList<MemberVO> readAllMember() throws SQLException{
		ArrayList<MemberVO> list = null;
		list = this.dao.searchAllMember();
		return list;
	}
	@Override
	public TeacherVO readTeacher(int empno) throws SQLException {
		TeacherVO teacher = null;
		teacher= this.dao.selectTeacher(empno);
		return teacher;
	}
	@Override
	public ArrayList<TeacherVO> readAllTeacher() throws SQLException {
		ArrayList<TeacherVO> list = null;
		list = this.dao.searchAllTeacher();
		return list;
	}
	@Override
	public int updateMember(MemberVO member) throws SQLException {
		int row = 0;
		try {
			row = this.dao.updateMember(member);
		}catch(SQLException e) {
			System.out.println(e);
		}
		return row;
	}
	
	@Override
	public int insertTeacher(TeacherVO teacher) throws SQLException {
		int row = -1;
		row = this.dao.insertTeacher(teacher);
		return row;
	}
	@Override
	public int deleteTeahcer(int empno) throws SQLException {
		int row = -1;
		try {
			row = this.dao.deleteTeacher(empno);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}
	
}
