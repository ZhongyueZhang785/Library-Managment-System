package DBConnect;

public class Card {
	private String cno;
	private String cname;
	private String dpt;
	private int type;
	private String pwd;

	public Card(String cno,String cname,String dpt,int type,String pwd) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.dpt = dpt;
		this.type = type;
		this.pwd = pwd;
	}
	public String get_cno() {
		return cno;
	}
	public String get_cname() {
		return cname;
	}
	public String get_dpt() {
		return dpt;
	}
	public int get_type() {
		return type;
	}
	public String get_pwd() {
		return pwd;
	}
}
