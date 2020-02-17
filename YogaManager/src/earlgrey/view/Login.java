package earlgrey.view;

import java.util.Scanner;

import earlgrey.service.MemberMgmtService;
import earlgrey.service.MemberMgmtServiceImpl;



public class Login {
	private Scanner scan;
	private MemberMgmtService service;
	
	public Login() {
		this.scan = new Scanner(System.in);
		this.service = new MemberMgmtServiceImpl();
	}
	
	public int login() {
		System.out.println("******Login Page******");
		System.out.print("���̵� : ");
		String userid = this.scan.next();
		System.out.print("��й�ȣ : ");
		String passwd = this.scan.next();
		return this.service.login(userid, passwd);

}
}