package earlgrey.view;

import java.util.Scanner;

public class AdminUI {
	public static void main(String[] args) {
		AdminUI adu = new AdminUI();
		adu.showMenu();
		
		
	}
	public int showMenu() {
		System.out.println("1. ȸ�� ��ȸ�ϱ�\n" + 
				"2. ���� ��ȸ�ϱ�\n" + 
				"3. ȸ�� ���� ������Ʈ\n" + 
				"4. ���� ���� ������Ʈ\n" + 
				"5. ���α׷� ������Ʈ\n"+
				"6.���α׷� ����\n"+
				"0.���α׷� ����");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
		
	}
}