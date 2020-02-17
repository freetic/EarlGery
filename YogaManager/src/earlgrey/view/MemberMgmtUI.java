package earlgrey.view;

import java.sql.SQLException;
import java.util.Scanner;


public class MemberMgmtUI {
	private Scanner scan;

	private boolean flag;

	public MemberMgmtUI() throws SQLException {
		this.scan = new Scanner(System.in);
	
		this.flag = false;
		while (!flag) {
			this.init();
		}
		int choice = -1;
		while (true) {
			choice = this.showMenu();
			this.process(choice);
		}
	}

	private void init() { 
		System.out.println("(1)Login       (2)Register       (3)Exit ");
		System.out.print("선택 >> ");
		switch(this.scan.nextInt()) {
			case 1 : 
				Login login = null;
				while(true) {
					login = new Login();
					int number = login.login();  //-1, 0, 1
					if(number == -1) System.out.println("그런 아이디는 존재하지 않습니다.");
					else if(number == 0) System.out.println("비밀번호가 일치하지 않습니다.");
					else if(number == 1) {
						System.out.println("Login Success");
						this.flag = true;
						break;
					}
				}
				break;
			case 2 :
				Register register = new Register();
				register.register();
				break;
			case 3 : 
				System.out.print("정말 종료하시겠습니까(y/n) ? : ");
				if(this.scan.next().toUpperCase().equals("Y")) {
					System.out.println("이용해 주셔서 감사합니다");
					System.exit(0);
				}
				break;
		}
	}

	private void process(int choice) throws SQLException {
		switch (choice) {
		case 1:
			Reservation reservation = new Reservation();
			reservation.reservation();
			break;
		case 2:
			Search search = new Search();
			ReserveVO reserve = search.search();
			search.display(reserve);
			break;
		case 3:
			Search search2 = new Search();
			ReserveVO reserve1 = search2.search();
			search2.display(reserve1);
			System.out.print("정말 삭제하시겠습니까(y/n) ? : ");
			if(this.scan.next().toUpperCase().equals("Y")) {
				if(this.service.deleteReserve(reserve1.getuserid()) == 1) {
					System.out.println("학생이 잘 삭제됐습니다.");
				}
			}
			break;
			
		case 4:
			System.out.println("이용해 주셔서 감사합니다");
			System.exit(0);
			break;
		}
	}

	public int showMenu() {
		System.out.println("[회원 로그인]");
		System.out.println("1. 예약 하기");
		System.out.println("2. 예약 내역");
		System.out.println("3. 예약 취소");
		System.out.println("4. 종료하기");
		System.out.print("선택 >> ");
		return this.scan.nextInt();
	}
}