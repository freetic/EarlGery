package earlgrey.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import earlgrey.dao.DBClose;
import earlgrey.dao.DBConnection;
import earlgrey.vo.Lecture;
import earlgrey.vo.MemberVO;
import earlgrey.vo.TeacherVO;

public class AdminDaoImpl implements AdminDao {

	@Override
	public MemberVO selectMember(String email) throws SQLException {// 이메일로 멤버 검색
		Connection conn = DBConnection.getConnection("config/mariadb.properties");
		String sql = "{   call  member_select_sp(?)   }"; //mysql로 수정
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, email);
		int row = cstmt.executeUpdate();
		ResultSet rs = cstmt.executeQuery();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO member = null;
		while(rs.next()) {
				member = new MemberVO(rs.getString("email"),
				rs.getString("name"),rs.getString("pwd"),
				rs.getString("phone"));
			
		}
		DBClose.close(conn, cstmt);  

		return member;
	}

	@Override
	public TeacherVO selectTeacher(int empno) throws SQLException {//특정  empno로 선생님 검색
		Connection conn = DBConnection.getConnection("config/mariadb.properties");
		String sql = "{   call  sp_teacher_select(?)   }"; //mysql로 수정
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, empno);
		ResultSet rs = cstmt.executeQuery();
		TeacherVO teacher = null;
		while(rs.next()) {
				teacher = new TeacherVO(rs.getInt("empno"),
				rs.getString("name"), rs.getString("phone"));
		}
		DBClose.close(conn, cstmt);  
		return teacher;
	}

	@Override
	public int updateMember(MemberVO member) throws SQLException { //멤버의 이메일로 select한 다음,
		//멤버형으로 매개변수를 가져옴. 이메일을 받아 이름, 핸드폰 번호를 수정함. 비밀번호 제외
		int row = -1;
		Connection conn = DBConnection.getConnection("config/mariadb.properties");  
		String sql = "{ call sp_member_update(?,?,?)  }"; //name, phone, email
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, member.getName());
		cstmt.setString(2, member.getPhone());
		cstmt.setString(3, member.getEmail()); 
		DBClose.close(conn, cstmt);  
		return row;
	}
		

	@Override
	public int insertTeacher(TeacherVO teacher) throws SQLException {
		//UI teacher정보를 받아와서
		//teacher만들고, teacher를 insert하는 메서드
		int row = -1;
		Connection conn = DBConnection.getConnection("config/mariadb.properties");  //3.
		String sql = "{ call sp_teacher_insert(?,?,?)  }"; 
		CallableStatement cstmt = conn.prepareCall(sql);  
		cstmt.setInt(1, teacher.getEmpno());
		cstmt.setString(2, teacher.getName());
		cstmt.setString(3, teacher.getPhone());
		row = cstmt.executeUpdate();
		DBClose.close(conn, cstmt);
		return row;
	}

	@Override
	public int deleteTeacher(int empno) throws SQLException {
		int row = -1;
		Connection conn = DBConnection.getConnection("oracle.properties");  //3.
		String sql = "{ call sp_teacher_delete(?)  }";
		CallableStatement cstmt = conn.prepareCall(sql);  //4.
		cstmt.setInt(1, empno);
		row = cstmt.executeUpdate();
		DBClose.close(conn, cstmt);  //6.
		return row;
	}

	@Override
	public ArrayList<MemberVO> searchAllMember() throws SQLException {
		Connection conn = DBConnection.getConnection("config/mariadb.properties"); 
		String sql = "{    call sp_search_all_member()  }";
		CallableStatement cstmt = conn.prepareCall(sql);   
		cstmt.execute();   
		ResultSet rs = (ResultSet)cstmt.getObject(1);
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		while(rs.next()) {
			MemberVO member = new MemberVO(rs.getString("email"), 
					rs.getString("name"), rs.getString("password"), rs.getString("phone"));
			list.add(member);
		}
		DBClose.close(conn, cstmt, rs);   
		return list;
		
	}

	@Override
	public ArrayList<TeacherVO> searchAllTeacher() throws SQLException {
		Connection conn = DBConnection.getConnection("config/mariadb.properties"); 
		String sql = "{    call sp_search_all_teacher()  }";
		CallableStatement cstmt = conn.prepareCall(sql);  
		cstmt.execute();   //매우 중요함.   5.
		ResultSet rs = (ResultSet)cstmt.getObject(1);
		ArrayList<TeacherVO> list = new ArrayList<TeacherVO>();
		while(rs.next()) {
			TeacherVO member = new TeacherVO(rs.getInt("empno"), 
					rs.getString("name"), rs.getString("phone"));
			list.add(member);
		}
		DBClose.close(conn, cstmt, rs);   //7.
		return list;
		
	}
	
//	@Override
//	public Lecture selectLecture(int lectureid) {
//		Connection conn = DBConnection.getConnection("config/mariadb.properties");
//		String sql = "{   call  lecture_select_sp(?)   }"; //mysql로 수정
//		CallableStatement cstmt = conn.prepareCall(sql);
//		cstmt.setString(1, email);
//		int row = cstmt.executeUpdate();
//		ResultSet rs = cstmt.executeQuery();
//		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
//		MemberVO member = null;
//		while(rs.next()) {
//				member = new MemberVO(rs.getString("email"),
//				rs.getString("name"),rs.getString("pwd"),
//				rs.getString("phone"));
			
		}
//	@Override
//	public int insertLecture(Lecture lecture) throws SQLException {
//		Connection conn = DBConnection.getConnection("config/oracle.properties");  //3.
//		String sql = "{ call lecture_insert_sp(?,?,?) }";
//		CallableStatement cstmt = conn.prepareCall(sql);   //4.
//		//int empno, String lectureTime, int capacity
//		cstmt.setInt(1, lecture.getEmpno());
//		cstmt.setString(2,  lecture.getLectureTime());
//		cstmt.setInt(3, lecture.getCapacity());
//		int row = cstmt.executeUpdate();
//		DBClose.close(conn, cstmt);
//		return row;
//	}
//	
//	public int updateLecture(String empno) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteLecture(String empno) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//

