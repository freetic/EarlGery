package earlgrey.view;

import java.util.Scanner;

public class AdminUI {
	public static void main(String[] args) {
		AdminUI adu = new AdminUI();
		adu.showMenu();
		
		
	}
	public int showMenu() {
		System.out.println("1. 회원 조회하기\n" + 
				"2. 강사 조회하기\n" + 
				"3. 회원 정보 업데이트\n" + 
				"4. 강사 정보 업데이트\n" + 
				"5. 프로그램 업데이트\n"+
				"6.프로그램 삭제\n"+
				"0.프로그램 종료");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
		
	}
}
