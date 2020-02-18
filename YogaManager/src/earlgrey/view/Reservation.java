package earlgrey.view;

import earlgrey.service.ReserveMgmtService;
import earlgrey.service.ReserveMgmtServiceImpl;

import java.util.Scanner;




public class Reservation {
	private Scanner scan;
	private ReserveMgmtService service;
	public Reservation() {
		this.scan = new Scanner(System.in);
		this.service = new ReserveMgmtServiceImpl();
	}
	public int reservation() {
		System.out.println("**예약 하기 **");
		System.out.print("1.김선생님 2.이선생님 3.박선생님");
		int userid = this.scan.nextInt();
		switch(this.scan.nextInt()) {
		case 1: break;
		case 2:break;
		case 3:break;
		}
		System.out.print("날짜를 입력(yyyy-mm-dd) : ");
		String date = this.scan.next();
	
		System.out.print("1.09:00 2.10:00 3.17:00");
		int hour = this.scan.nextInt();
		switch(this.scan.nextInt()) {
		case 1: break;
		case 2:break;
		case 3:break;
		}
		
		return this.service.reservation(userid);
	}
}
	