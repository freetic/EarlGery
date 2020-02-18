package earlgrey.vo;

public class ReserveVO {
	private String userid;
	private String teachername;
	private String date;
	private String hour;
	private String datehour;
	public int recordid;
	public ReserveVO(String userid, String teachername, String date, String hour) {
	
		this.userid = userid;
		this.teachername = teachername;
		this.date = date;
		this.hour = hour;
	}
	public ReserveVO(String userid, String teachername,  String datehour) {
		this.userid = userid;
		this.teachername = teachername;
		this.date = date;
		this.datehour = datehour;
	}
	public String getuserid() {
		return userid;
	}
	public void setuserid(String userid) {
		this.userid = userid;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getDatehour() {
		return datehour;
	}
	public void setDatehour(String datehour) {
		this.datehour = datehour;
	}
	public int getRecordid() {
		return recordid;
	}
	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}
	@Override
	public String toString() {
		return "ReserveVO [userid=" + userid + ", teachername=" + teachername + ", date=" + date + ", hour=" + hour
				+ "]";
	}
	
	
}
