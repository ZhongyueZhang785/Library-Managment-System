package DBConnect;

public class Administratoe {
	private String ano;
	private String aname;
	private String password;
	private String contact;
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Administratoe(String ano, String aname, String password, String contact) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.password = password;
		this.contact = contact;
	}
	
	

}
