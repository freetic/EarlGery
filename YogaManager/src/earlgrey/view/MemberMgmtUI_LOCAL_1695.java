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
		System.out.print("���� >> ");
		switch(this.scan.nextInt()) {
			case 1 : 
				Login login = null;
				while(true) {
					login = new Login();
					int number = login.login();  //-1, 0, 1
					if(number == -1) System.out.println("�׷� ���̵�� �������� �ʽ��ϴ�.");
					else if(number == 0) System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
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
				System.out.print("���� �����Ͻðڽ��ϱ�(y/n) ? : ");
				if(this.scan.next().toUpperCase().equals("Y")) {
					System.out.println("�̿��� �ּż� �����մϴ�");
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
			System.out.print("���� �����Ͻðڽ��ϱ�(y/n) ? : ");
			if(this.scan.next().toUpperCase().equals("Y")) {
				if(this.service.deleteReserve(reserve1.getuserid()) == 1) {
					System.out.println("�л��� �� �����ƽ��ϴ�.");
				}
			}
			break;
			
		case 4:
			System.out.println("�̿��� �ּż� �����մϴ�");
			System.exit(0);
			break;
		}
	}

	public int showMenu() {
		System.out.println("[ȸ�� �α���]");
		System.out.println("1. ���� �ϱ�");
		System.out.println("2. ���� ����");
		System.out.println("3. ���� ���");
		System.out.println("4. �����ϱ�");
		System.out.print("���� >> ");
		return this.scan.nextInt();
	}
}