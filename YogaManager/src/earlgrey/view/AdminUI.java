package earlgrey.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import earlgrey.service.AdminService;
import earlgrey.service.AdminServiceImpl;
import earlgrey.vo.MemberVO;
import earlgrey.vo.TeacherVO;

public class AdminUI {
	private Scanner scan;
	private AdminService service;
	private boolean flag;
	public AdminUI() {
		this.service = new AdminServiceImpl();
	}
	public void init() throws SQLException {
		int choice = showMenu();
		switch(choice) {
			case 1:  System.out.println("�������� �̸����� �Է� : "); String email = scan.next();
				MemberVO member = this.service.readMember(email);
				if(member == null) {
					System.out.println("�ش��ϴ� �������� ã�� �� �����ϴ�.");
				}
				//ȸ�� ��ȸ�ϱ�
			case 2: System.out.println("������ ����� �Է�:"); int empno = scan.nextInt();
				TeacherVO teacher = this.service.readTeacher(empno);
				//���� ��ȸ�ϱ�
				if(teacher == null) {
					System.out.println("�ش��ϴ� ���縦 ã�� �������ϴ�.");
				}
			case 3: 
				ArrayList<MemberVO>list = this.service.readAllMember();
				if(list.isEmpty()) {
					System.out.println("ȸ�� ������ �����ϴ�.");
				}
				//��� ȸ�� ��ȸ�ϱ�
			case 4: 
				ArrayList<TeacherVO>list1 =this.service.readAllTeacher();
				if(list1.isEmpty()) {
					System.out.println("���� ������ �����ϴ�.");
				}
				//��� �� ��ȸ�ϱ�
			case 5:  
				System.out.println("<<������Ʈ �ϰ��� �ϴ� �������� ������ �Է�  >>");
				System.out.println("�̸��� :");String email1 = scan.next();
				MemberVO mb = this.service.readMember(email1);
			    System.out.println("<<�ٲ� ���� �Է�>>");
				System.out.println("�̸� : ");String name = scan.next();
				System.out.println("  ��й�ȣ : ");String phone = scan.next();
				MemberVO member1= new MemberVO(email1, name, phone);
				int row = 	this.service.updateMember(member1);
				if(row==-1) {
					System.out.println("�ش� �������� ������Ʈ�� �����Ͽ����ϴ�.  ");
				}
				//ȸ�� ���� ������Ʈ
			case 6://���� �߰�	this.empno = empno;
				//this.name = name;
				//this.phone = phone;
				System.out.println("<<���� �߰�>>");
				System.out.println("��� �Է�:  "); int empno1 = scan.nextInt();
				System.out.println("�̸� �Է� : "); String name1 = scan.next();
				System.out.println("��ȭ��ȣ :  "); String phone1 = scan.next();
				TeacherVO teacher1 = new TeacherVO(empno1, name1, phone1);
				row = this.service.insertTeacher(teacher1);
				if(row == 1) {
					System.out.println("���� �߰� ����  ");
					
				}else {System.out.println("���� �߰��� �����Ͽ����ϴ�.");}
				
			case 7:System.out.println("������ ������ ����� �Է� : ");
			int empno2 = scan.nextInt();
			row = this.service.deleteTeahcer(empno2);
			if(row == 1) {
				System.out.println("���� ���� ����  ");
				
			}else {System.out.println("���� ������ �����Ͽ����ϴ�.");}
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
