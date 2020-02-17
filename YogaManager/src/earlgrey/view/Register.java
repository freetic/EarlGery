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
		
		System.out.println("*****ȸ������������******");
		System.out.print("���̵� : ");
		String email = this.scan.next();
		System.out.print("��й�ȣ : ");
		String passwd = this.scan.next();
		System.out.print("��й�ȣ Ȯ��: ");
		String passwd2 = this.scan.next();
		System.out.print("�̸� : ");
		String name = this.scan.next();
		System.out.print("��ȭ��ȣ : ");
		String phone = this.scan.next();
//		 if(idCheck(email)) {
//	            System.out.println("�ߺ��� email�Դϴ�.");
	           
		
		MemberVO member = new MemberVO(email, passwd, name, phone);
		int row = this.service.register(member);
		if(row == 1) System.out.println("ȸ�� ���� ����");
		else System.out.println("ȸ�� ���� ����");
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
