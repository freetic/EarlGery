package earlgrey.view;

import java.sql.SQLException;
import java.util.Scanner;

import earlgrey.dao.AdminDao;
import earlgrey.dao.AdminDaoImpl;
import earlgrey.vo.TeacherVO;

public class AdminUI {
	public static void main(String[] args) throws SQLException {
		AdminDao ad = new AdminDaoImpl();
		TeacherVO tc = ad.selectTeacher(1);
		System.out.println(tc);
		
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
