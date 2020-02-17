package earlgrey.view;

import java.util.Scanner;

import earlgrey.service.AdminService;
import earlgrey.service.AdminServiceImpl;

public class AdminUI {
	private Scanner scan;
	private AdminService service;
	private boolean flag;
	public AdminUI() {
		this.service = new AdminServiceImpl();
	}
	public void init() {
		int choice = showMenu();
		switch(choice) {
			case 1: //회원 조회하기
			case 2://강사 조회하기
			case 3://모든 회원 조회하기
			case 4://모든 강사 조회하기
			case 5://회원 정보 업데이트
			case 6://강사 추가
			case 7://강사 삭제
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
