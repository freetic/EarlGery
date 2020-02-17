package earlgrey.view;

import java.sql.SQLException;
import java.util.Scanner;

import earlgrey.service.AdminService;
import earlgrey.service.AdminServiceImpl;
import earlgrey.vo.MemberVO;
import earlgrey.vo.TeacherVO;

public class AdminUI {
	private Scanner scan;
	private AdminService service;
	private boolean flag;
	public AdminUI() {
		this.service = new AdminServiceImpl();
	}
	public void init() throws SQLException {
		int choice = showMenu();
		switch(choice) {
			case 1:  System.out.println("수강생의 이메일을 입력 : "); String email = scan.next();
				this.service.readMember(email);
				//회원 조회하기
			case 2: System.out.println("강사의 사번을 입력:"); int empno = scan.nextInt();
				this.service.readTeacher(empno);
				//강사 조회하기
			case 3: this.service.readAllMember();
				//모든 회원 조회하기
			case 4: this.service.readAllTeacher();
				//모든 사 조회하기
			case 5:  
				System.out.println("<<업데이트 하고자 하는 수강생의 정보를 입력  >>");
				System.out.println("이메일 :");String email1 = scan.next();
				MemberVO mb = this.service.readMember(email1);
			    System.out.println("<<바꿀 정보 입력>>");
				System.out.println("이름 : ");String name = scan.next();
				System.out.println("  비밀번호 : ");String phone = scan.next();
				MemberVO member = new MemberVO(email1, name, phone);
				int row = 	this.service.updateMember(member);
				if(row==-1) {
					System.out.println("해당 수강생의 업데이트에 실패하였습니다.  ");
				}
				//회원 정보 업데이트
			case 6://강사 추가	this.empno = empno;
				//this.name = name;
				//this.phone = phone;
				System.out.println("<<강사 추가>>");
				System.out.println("사번 입력:  "); int empno1 = scan.nextInt();
				System.out.println("이름 입력 : "); String name1 = scan.next();
				System.out.println("전화번호 :  "); String phone1 = scan.next();
				TeacherVO teacher = new TeacherVO(empno1, name1, phone1);
				row = this.service.insertTeacher(teacher);
				if(row == 1) {
					System.out.println("강사 추가 성공  ");
					
				}else {System.out.println("강사 추가에 실패하였습니다.");}
				
			case 7:System.out.println("삭제할 강사의 사번을 입력 : ");
			int empno2 = scan.nextInt();
			row = this.service.deleteTeahcer(empno2);
			if(row == 1) {
				System.out.println("강사 삭제 성공  ");
				
			}else {System.out.println("강사 삭제에 실패하였습니다.");}
			case 0: System.exit(0);
		}
	}
	
	
	
	public int showMenu() {
		System.out.println("1. 회원 조회하기\n" + 
				"2. 강사 조회하기\n" + 
				"3. 모든 회원 조회하기\n" + 
				"4. 모든 강사 조회하기\n" + 
				"5. 회원 정보 업데이트\n"+
				"6. 강사 추가\n"+
				"7. 강사 삭제\n"
				+ "0. 종료\n");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
		
	}
	
}
