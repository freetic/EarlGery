package earlgrey.view;

import java.sql.SQLException;
import java.util.Scanner;

import earlgrey.service.AdminService;
import earlgrey.service.AdminServiceImpl;
import earlgrey.service.MemberMgmtService;
import earlgrey.service.MemberMgmtServiceImpl;
import earlgrey.vo.ReserveVO;



public class MemberUI {
	private Scanner scan;
	private MemberMgmtService service;
	private AdminService service1;

	private boolean flag;

	public MemberUI() throws SQLException {
		this.scan = new Scanner(System.in);
		this.service = new MemberMgmtServiceImpl();
		this.service1 = new AdminServiceImpl();
		this.flag = false;
		while (!flag) {
			this.init();
		}
		
	}

	public void init() throws SQLException { 
		System.out.println("(1)Login       (2)Register       (3)Exit ");
		System.out.print("선택 >> ");
		switch(this.scan.nextInt()) {
			case 1 : 
				Scanner scan = new Scanner(System.in);
				
				while(true) {
					System.out.println("ID :"); String email = scan.next();
					System.out.println("Password");String pwd = scan.next();
					int number = this.service.login(email, pwd);
					if(number == -1) System.out.println("그런 아이디는 존재하지 않습니다.");
					else if(number == 0) System.out.println("비밀번호가 일치하지 않습니다.");
					else if(number == 1) {
						System.out.println("Login Success");
						this.flag = true;
						break;
					}
					if(email.equals("admin@aaa.com")) {
						AdminUI adservice = new AdminUI();
						adservice.init();
					}
					else{ 
					int choice = showMenu();
					switch (choice) {
					case 1:
						Reservation reservation = new Reservation();
						reservation.reservation();
						break;
					case 2:
						Search search = new Search();//예약내역 보기
						ReserveVO reserve = search.search(email);
						search.display(reserve);
						break;
					case 3:
//						Search search2 = new Search();
						//sacnnner 
//						ReserveVO reserve1 = search2.delete(email,);
//						search2.display(reserve1);
//						System.out.print("정말 삭제하시겠습니까(y/n) ? : ");
//						if(this.scan.next().toUpperCase().equals("Y")) {
//							if(this.service.deleteReserve(reserve1.getuserid()) == 1) {
//								System.out.println("예약이 잘 삭제되었습니다.");//email 
//							}
//						}
						break;
						
					case 4:
						System.out.println("이용해 주셔서 감사합니다");
						System.exit(0);
						break;
					}
					
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
