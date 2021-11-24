package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBConnect.Book;
import DBConnect.Card;
import DBConnect.bookDAO;

public class bookManage {
	public static ArrayList<Book> show_book() {
		Connection c = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        ArrayList<Book> res = new ArrayList<Book>();
		String sql = "select * from library_zzy.book";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				 "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
			while(result.next()) {
    			String bno = result.getString(1);
    			String category = result.getString(2);
    			String title = result.getString(3);
    		 	String press = result.getString(4);  
    		 	int year = result.getInt(5);
    		 	String author = result.getString(6);
    		 	float price = result.getFloat(7);
    		 	int total = result.getInt(8);
    		 	int stock = result.getInt(9);
    			Book book = new Book(bno,category,title,press,year,author,price,total,stock);
    			res.add(book);
    		}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
		return res;
	}
	
	public static void add_book(Book book) {
		Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet result = null;
		String sql = "select * from library_zzy.book where bno = '" + book.get_bno() + "'" ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				 "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		//新书入库
    		if(!result.next()) {
    			String bno = book.get_bno();
        		String cat = book.get_category();
        		String title = book.get_title();
        		String press = book.get_press();
        		int year = book.get_year();
        		String author = book.get_author();
        		float price = book.get_price();
        		int total = book.get_total();
        		int stock = book.get_stock();
    			sql = "insert into book(bno,category,title,press,year,author,price,total,stock) values('"+ bno +"','" + cat + "','" + title +"','" + press +"','" + year +"','" + author +"','" + price +"','" + total +"','" + stock + "')";
    			s = c.createStatement();
        		s.execute(sql);
        		// System.out.println(no);
        		JOptionPane.showMessageDialog(null, "Successfully！","",JOptionPane.INFORMATION_MESSAGE);
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "Unsucessfully!\nPlease try again！","",JOptionPane.INFORMATION_MESSAGE);
    		}		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
	}
	public static Book select_book(String no) {
		Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet result = null;
        Book book = null;
		String sql = "select * from library_zzy.book where bno = '" + no + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				 "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		if(result.next()) {
        		// System.out.println(no);
    			String bno = result.getString(1);
    			String cat = result.getString(2);
    			String title = result.getString(3);
    		 	String press = result.getString(4);  
    		 	int year = result.getInt(5);
    			String author = result.getString(6);
    			float price = result.getFloat(7);
    			int total = result.getInt(8);
    			int stock = result.getInt(9);
    			book = new Book(bno,cat,title,press,year,author,price,total,stock);
    		}
    		else
    			JOptionPane.showMessageDialog(null, "It is a new Book.\nPlease fill the following information","",JOptionPane.INFORMATION_MESSAGE);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
		return book;
	}
	public static Book select_book2(String no) {
		Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet result = null;
        Book book = null;
		String sql = "select * from library_zzy.book where bno = '" + no + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				 "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		if(result.next()) {
        		// System.out.println(no);
    			String bno = result.getString(1);
    			String cat = result.getString(2);
    			String title = result.getString(3);
    		 	String press = result.getString(4);  
    		 	int year = result.getInt(5);
    			String author = result.getString(6);
    			float price = result.getFloat(7);
    			int total = result.getInt(8);
    			int stock = result.getInt(9);
    			book = new Book(bno,cat,title,press,year,author,price,total,stock);
    		}
    		else
    			JOptionPane.showMessageDialog(null, "The book is not existed!\nPlease type again.","",JOptionPane.INFORMATION_MESSAGE);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
		return book;
	}
	public static boolean exist_book(String no) {
		Connection c = null;
        PreparedStatement ps = null;
        ResultSet result = null;
		String sql = "select * from library_zzy.book where bno = '" + no + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				 "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		if(result.next()) {
        		return true;}
    		else {
    			JOptionPane.showMessageDialog(null, "It is a new Book.\nPlease fill the following information","",JOptionPane.INFORMATION_MESSAGE);
    			return false;}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			return false;
		}catch (SQLException e) {
            e.printStackTrace();
            return false;
		}finally { 
            bookDAO.close(c, ps, result);
        }
	}
	
	public static Book add_old_book(String no, int increase) {
		Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet result = null;
        Book book = null;
		String sql = "select * from library_zzy.book where bno = '" + no + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				 "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		if(result.next()) {
        		// System.out.println(no);
    			int total = increase + result.getInt(8);
    			int stock = increase + result.getInt(9);
    			sql = "update book set total = '"+ total + "',stock = '" + stock + "'where(bno ='" +no+"')";
    			s = c.createStatement();
        		s.execute(sql);
        		JOptionPane.showMessageDialog(null, "Successfully！","",JOptionPane.INFORMATION_MESSAGE);
    		}
    		else
    			JOptionPane.showMessageDialog(null, "Unsucessfully!\nPlease try again！","",JOptionPane.INFORMATION_MESSAGE);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
		return book;
	}
	public static void delete_book(String no) {
		Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet result = null;
		String sql = "select * from library_zzy.card where cno = '" + no + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				 "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		if(result.next()) {
    			sql = "delete from card where cno = '"+ no + "'";
    			s = c.createStatement();
        		s.execute(sql);
        		// System.out.println(no);
        		JOptionPane.showMessageDialog(null, "删除成功！","",JOptionPane.INFORMATION_MESSAGE);
    		}
    		else
    			JOptionPane.showMessageDialog(null, "卡号不存在！","",JOptionPane.INFORMATION_MESSAGE);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
	}
	public static ArrayList<Book> query_book(String year1,String year2,String price1,String price2,String tit,String cat) {
		Connection c = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        ArrayList<Book> res = new ArrayList<Book>();
        String sql = "";
        int flag = 0;//1表示至少有一个填写了
        if(price1.equals(""))
        	price1 = "0";
        else
        	flag =1;
        
        if(price2.equals(""))
        	price2 = "9999";
        else
        	flag = 1;

        if(year1.equals(""))
        	year1 = "0000";
        else
        	flag = 1;
 
        if(year2.equals(""))
        	year2 = "9999";
        else flag = 1;
        
        sql = "select * from library_zzy.book where price between '"+price1+"' and '"+price2+"' and year between '"+year1+"' and '"+year2+"'";
        
        if(!tit.equals("")) {
        	sql = sql+" and title like '%"+tit+"%'";
        	flag = 1;}
        
        if(!cat.equals("")) {
        	sql = sql+" and category ='"+ cat +"'";
        	flag = 1;}
       
        if(flag == 0)
        	sql = "select * from library_zzy.book where price = -9999";
        
       /* if(!price1.equals("")) 
        	sql = "select * from library_zzy.book where price between'"+price1+"'and'"+price2+"'";
        if(!year1.equals(""))
        	sql = "select * from library_zzy.book where year between'"+year1+"'and'"+year2+"'";
        if(!tit.equals("")) 
        	//System.out.println("select * from library_zzy.book where title like '%"+tit+"%'");
        	sql = "select * from library_zzy.book where title like '%"+tit+"%'";
        if(!cat.equals(""))
        	sql = "select * from library_zzy.book where category ='"+ cat +"'";*/
        
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				"jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            System.out.println(sql);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
			while(result.next()) {
				System.out.println(sql);
    			String bno = result.getString(1);
    			String category = result.getString(2);
    			String title = result.getString(3);
    		 	String press = result.getString(4);  
    		 	int year = result.getInt(5);
    		 	String author = result.getString(6);
    		 	float price = result.getFloat(7);
    		 	int total = result.getInt(8);
    		 	int stock = result.getInt(9);
    			Book book = new Book(bno,category,title,press,year,author,price,total,stock);
    			res.add(book);
    		}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
		return res;
	}
	public static Object[][]data(ArrayList<Book> aa){
		Object[][] tmp = new Object[aa.size()][9];
		for(int i=0;i<aa.size();i++) {
			Book book = aa.get(i);
			Object[] cc = {book.get_bno(),book.get_category(),book.get_title(),book.get_press(),book.get_year(),book.get_author(),book.get_price(),book.get_total(),book.get_stock()};
			tmp[i] = cc;
		}
		return tmp;
	}
}
