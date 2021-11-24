package DBConnect;

public class Book {
	private String bno;
	private String category;
	private String title;
	private String press;
	private int year;
	private String author;
	private float price;
	private int total;
	private int stock;
	


	@Override
	public String toString() {
		return "Book [bno=" + bno + ", category=" + category + ", title=" + title + ", press=" + press + ", year="
				+ year + ", author=" + author + ", price=" + price + ", total=" + total + ", stock=" + stock + "]";
	}
	public Book(String bno,String category,String title,String press,int year,String author,float price,int total,int stock) {
		super();
		this.bno = bno;
		this.category = category;
		this.title = title;
		this.press = press;
		this.year = year;
		this.author = author;
		this.price = price;
		this.total = total;
		this.stock = stock;
	}
	public String get_bno() {
		return bno;
	}
	public String get_category() {
		return category;
	}
	public String get_title() {
		return title;
	}
	public String get_press() {
		return press;
	}
	public int get_year() {
		return year;
	}
	public String get_author() {
		return author;
	}
	public float get_price() {
		return price;
	}
	public int get_total() {
		return total;
	}
	public int get_stock() {
		return stock;
	}
}