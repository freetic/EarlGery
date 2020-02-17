package earlgrey.view;
import java.sql.SQLException;
import java.util.Scanner;


import earlgrey.service.ReserveMgmtService;
import earlgrey.service.ReserveMgmtServiceImpl;
import earlgrey.vo.ReserveVO;




public class Search {
	private Scanner scan;
	private ReserveMgmtService service;
	
	public Search() {
		this.scan = new Scanner(System.in);
		this.service = new ReserveMgmtServiceImpl();
	}
	
	
	public ReserveVO search() throws SQLException {
		System.out.print("회원의 이메일 : ");
		String userid = this.scan.next();
		ReserveVO reserve = this.service.read(userid);
		return reserve;
		}
	
	public void display(ReserveVO reserve) {
		if(reserve == null) System.out.println("예약 찾지 못했습니다.");
		else if(reserve != null) System.out.println(reserve);
	}
}



