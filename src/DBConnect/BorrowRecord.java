package DBConnect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowRecord {
	private String ano;
	private String cno;
	private String bno;
	private String borrow_time;
	private String return_time = null;
	private String return_deadline = null;
	private String category;
	private String title;
	private String year;
	private String press;
	private String author;
	private String price ;
	private String total;
	private String stock;
	

	/*public BorrowRecord(String ano, String cno, String bno, String borrow_time,String return_time) throws ParseException {
		super();
		this.ano = ano;
		this.cno = cno;
		this.bno = bno;
		this.borrow_time = borrow_time;
		this.return_time = return_time;
		if(return_time==null) {//若没归还则计算归还时间
			String s1 = borrow_time;
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
	        Date dat =ft.parse(s1);
	        dat.setDate(dat.getDate()+30);
	        System.out.println(dat);
	        String s3 = ft.format(dat);
			System.out.println(s3);
			this.return_deadline = s3;	
		}
		

	}*/
	


	public BorrowRecord(String ano, String cno, String bno, String borrow_time, String return_time,
			String category, String title, String press,String year, String author, String price, String total, String stock) throws ParseException {
		super();
		this.press = press;
		this.ano = ano;
		this.cno = cno;
		this.bno = bno;
		this.borrow_time = borrow_time;
		this.return_time = return_time;
		this.category = category;
		this.title = title;
		this.year = year;
		this.author = author;
		this.price = price;
		this.total = total;
		this.stock = stock;
		if(return_time==null) {//若没归还则计算归还时间
			String s1 = borrow_time;
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
	        Date dat =ft.parse(s1);
	        dat.setDate(dat.getDate()+30);
	        System.out.println(dat);
	        String s3 = ft.format(dat);
			System.out.println(s3);
			this.return_deadline = s3;	
		}
		
	}

	public String getPress() {
		return press;
	}

	public String getAno() {
		return ano;
	}



	public void setAno(String ano) {
		this.ano = ano;
	}



	public String getCno() {
		return cno;
	}



	public void setCno(String cno) {
		this.cno = cno;
	}



	public String getBno() {
		return bno;
	}



	public void setBno(String bno) {
		this.bno = bno;
	}



	public String getBorrow_time() {
		return borrow_time;
	}



	public void setBorrow_time(String borrow_time) {
		this.borrow_time = borrow_time;
	}






	public String getReturn_time() {
		return return_time;
	}



	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}



	public String getReturn_deadline() {
		return return_deadline;
	}



	public void setReturn_deadline(String return_deadline) {
		this.return_deadline = return_deadline;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getYear() {
		return year;
	}



	public void setYear(String year) {
		this.year = year;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getTotal() {
		return total;
	}



	public void setTotal(String total) {
		this.total = total;
	}



	public String getStock() {
		return stock;
	}



	public void setStock(String stock) {
		this.stock = stock;
	}



	
	

}
