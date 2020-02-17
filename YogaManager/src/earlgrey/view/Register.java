package earlgrey.view;

import java.util.Scanner;

import earlgrey.service.MemberMgmtService;
import earlgrey.service.MemberMgmtServiceImpl;
import earlgrey.vo.MemberVO;



public class Register {
	private Scanner scan;
	private MemberMgmtService service;
	
	public Register() {
		this.scan = new Scanner(System.in);
		this.service = new MemberMgmtServiceImpl();
	}
	
	public void register() {
		
		System.out.println("*****회원가입페이지******");
		System.out.print("아이디 : ");
		String email = this.scan.next();
		System.out.print("비밀번호 : ");
		String passwd = this.scan.next();
		System.out.print("비밀번호 확인: ");
		String passwd2 = this.scan.next();
		System.out.print("이름 : ");
		String name = this.scan.next();
		System.out.print("전화번호 : ");
		String phone = this.scan.next();
//		 if(idCheck(email)) {
//	            System.out.println("중복된 email입니다.");
	           
		
		MemberVO member = new MemberVO(email, passwd, name, phone);
		int row = this.service.register(member);
		if(row == 1) System.out.println("회원 가입 성공");
		else System.out.println("회원 가입 실패");
	}
//	 private MemberVO FindById(String id) {
//	        MemberVO memberDTO;
//	            if(memberDTO.getEmail().equals(id)) {
//	                return memberDTO;
//	            }
//	        }
//	        return null;
//	    }
//	 private boolean idCheck(String email) {
//	        boolean check = true;
//	        MemberVO member = FindById(email);
//	        if(member == null)
//	            check = false;
//	        return check;
//	    }
}
