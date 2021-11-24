package manage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBConnect.Book;
import DBConnect.BorrowRecord;
import DBConnect.Card;
import DBConnect.bookDAO;

public class borrowManage {
	public static boolean borrow_book(String no) {
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
            				"jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		if(result.next()) {
        		// System.out.println(no);
    			int stock = result.getInt(9);
    			if(stock > 0) {
    				stock = stock - 1;
    				sql = "update book set stock = '" + stock + "'where(bno ='" +no+"')";
        			s = c.createStatement();
            		s.execute(sql);
            		JOptionPane.showMessageDialog(null, "Borrow successfully!","",JOptionPane.INFORMATION_MESSAGE);
            		return true;
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Borrow Unsuccessfully!\nThe stock is empty.","",JOptionPane.INFORMATION_MESSAGE);
    				return false;}
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "Book does not exist！","",JOptionPane.INFORMATION_MESSAGE);
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
	public static void return_book(String no) {
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
            				"jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		if(result.next()) {
        		// System.out.println(no);
    			int stock = result.getInt(9);
				stock = stock + 1;
				sql = "update book set stock = '" + stock + "'where(bno ='" +no+"')";
    			s = c.createStatement();
        		s.execute(sql);
        		JOptionPane.showMessageDialog(null, "Returning Successfully！","",JOptionPane.INFORMATION_MESSAGE);
    		}
    		else
    			JOptionPane.showMessageDialog(null, "The book dose not exist！\nPlease try again.","",JOptionPane.INFORMATION_MESSAGE);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
	}
	//归还：记录添加归还日期
	public static boolean return_record(String bno, String cno,String return_time) {
		Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet result = null;
		String sql = "select * from library_zzy.borrow where bno = '" + bno + "'and cno ='"+cno+"'";
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
    			if(result.getString(5)==null)
				{sql = "update borrow set return_time = '" + return_time + "' where bno = '" + bno + "'and cno ='"+cno+"'";
				System.out.println(sql);
    			s = c.createStatement();
        		s.execute(sql);
        		return true;}
    			else {
    				JOptionPane.showMessageDialog(null, "Returning unsuccessfully\nThe record dose not exist.","",JOptionPane.INFORMATION_MESSAGE);
        			return false;
    			}
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "Returning unsuccessfully\nThe record dose not exist.","",JOptionPane.INFORMATION_MESSAGE);
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

public static ArrayList<BorrowRecord> borrowRecord(String bno) throws ParseException {
	Connection c = null;
    PreparedStatement ps = null;
    Statement s = null;
    ResultSet result = null;
    ArrayList<BorrowRecord> res = new ArrayList<BorrowRecord>();
	String sql = "select * from borrow,book where borrow.bno = book.bno and borrow.bno ='"+bno+"'";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("Driven Successfully!");
        c = DriverManager
        		.getConnection(
        				"jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC",
                        "root","zhangzhongyue123");
        //System.out.println("Success! Connected Object: " + c);
        ps = c.prepareStatement(sql);
		//System.out.println("Statement Object:" + s);
		result = ps.executeQuery();
		while(result.next()) {
    		// System.out.println(no);
			String ano = result.getString(1);
			String cno = result.getString(2);
			String borrow_time = result.getString(4);
			String return_time = result.getString(5);
			String category = result.getString(7);
			String title = result.getString(8);
			String press = result.getString(9);
			String year = result.getString(10);
			String author = result.getString(11);
			String price = result.getString(12);
			String total = result.getString(13);
			String stock = result.getString(14);
			BorrowRecord record = new BorrowRecord(ano, cno, bno, borrow_time, return_time,category,  title,  press, year, author,  price, total, stock);
			res.add(record);
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
public static boolean borrow_record(String ano,String cno,String bno,String borrow_time) throws ParseException {
	Connection c = null;
    PreparedStatement ps = null;
    Statement s = null;
    ResultSet result = null;
    ArrayList<BorrowRecord> res = new ArrayList<BorrowRecord>();
	String sql = "INSERT INTO `borrow` VALUES ('" + ano + "','" + cno + "','" + bno + "','" + borrow_time + "',NULL)";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("Driven Successfully!");
        c = DriverManager
        		.getConnection(
        				"jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                        "root","zhangzhongyue123");
        System.out.println(sql);
        ps = c.prepareStatement(sql);
        ps.execute(sql);
        return true;
        //JOptionPane.showMessageDialog(null, "Borrow Successfully！","",JOptionPane.INFORMATION_MESSAGE);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Borrow Unsuccessfuly！\nPleae check the information again.","",JOptionPane.INFORMATION_MESSAGE);
		return false;
	}catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Borrow Unsuccessfuly！\nPleae check the information again.","",JOptionPane.INFORMATION_MESSAGE);
        return false;
	}finally { 
        bookDAO.close(c, ps, result);
    }

	}

	public static ArrayList<BorrowRecord> Record(String cno) throws ParseException {
		Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet result = null;
        ArrayList<BorrowRecord> res = new ArrayList<BorrowRecord>();
		String sql = "select * from borrow,book where borrow.bno = book.bno and borrow.cno ='"+cno+"'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				"jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC",
                            "root","zhangzhongyue123");
            //System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
    		//System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		int flag = 0;
    		while(result.next()) {
        		// System.out.println(no);
    			String ano = result.getString(1);
    			String bno = result.getString(3);
    			String borrow_time = result.getString(4);
    			String return_time = result.getString(5);
    			String category = result.getString(7);
    			String title = result.getString(8);
    			String press = result.getString(9);
    			String year = result.getString(10);
    			String author = result.getString(11);
    			String price = result.getString(12);
    			String total = result.getString(13);
    			String stock = result.getString(14);
				BorrowRecord record = new BorrowRecord(ano, cno, bno, borrow_time, return_time,category,  title,  press, year, author,  price, total, stock);
				res.add(record);
				flag = 1;
    		}
    		if(flag == 0) {
    			JOptionPane.showMessageDialog(null, "The borrowing record of this card ID dose not exist!\nPleae check the information again.","",JOptionPane.INFORMATION_MESSAGE);
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

	public static Object[][]data(ArrayList<BorrowRecord> aa){
		Object[][] tmp = new Object[aa.size()][6];
		for(int i=0;i<aa.size();i++) {
			BorrowRecord record = aa.get(i);
			Object[] cc = {record.getAno(), record.getCno(), record.getBno(),record.getCategory(),record.getTitle(),record.getTotal(),record.getStock()
					,record.getBorrow_time(),record.getReturn_time(),record.getReturn_deadline()};
			tmp[i] = cc;
		}
		return tmp;
	}
	public static Object[][]data2(ArrayList<BorrowRecord> aa){
		Object[][] tmp = new Object[aa.size()][6];
		for(int i=0;i<aa.size();i++) {
			BorrowRecord record = aa.get(i);
			Object[] cc = {record.getAno(), record.getCno(), record.getBorrow_time(),record.getReturn_time(),record.getReturn_deadline()};
			tmp[i] = cc;
		}
		return tmp;
	}
}
