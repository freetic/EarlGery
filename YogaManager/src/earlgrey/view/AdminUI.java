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
			case 1: //ȸ�� ��ȸ�ϱ�
			case 2://���� ��ȸ�ϱ�
			case 3://��� ȸ�� ��ȸ�ϱ�
			case 4://��� ���� ��ȸ�ϱ�
			case 5://ȸ�� ���� ������Ʈ
			case 6://���� �߰�
			case 7://���� ����
			case 0: System.exit(0);
		}
	}
	
	
	
	public int showMenu() {
		System.out.println("1. ȸ�� ��ȸ�ϱ�\n" + 
				"2. ���� ��ȸ�ϱ�\n" + 
				"3. ��� ȸ�� ��ȸ�ϱ�\n" + 
				"4. ��� ���� ��ȸ�ϱ�\n" + 
				"5. ȸ�� ���� ������Ʈ\n"+
				"6. ���� �߰�\n"+
				"7. ���� ����\n"
				+ "0. ����\n");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
		
	}
	
}
