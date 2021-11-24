package manage;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DBConnect.Card;
import DBConnect.bookDAO;

public class studentManage {
	public static ArrayList<Card> show_stu() {
		Connection c = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        ArrayList<Card> res = new ArrayList<Card>();
		String sql = "select * from library_zzy.card";
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
    			String cno = result.getString(1);
    			String cname = result.getString(2);
    			String dpt = result.getString(3);
    			int type = result.getInt(4);
    		 	String pwd = result.getString(5);  
    			Card card = new Card(cno,cname,dpt,type,pwd);
    			res.add(card);
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
	public static void add_stu(String no, String name, String dpt, int type,String pwd) {
		Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet result = null;
		String sql = "select cno from library_zzy.card where cno = '" + no + "'" ;
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
    		if(!result.next()) {
    			sql = "insert into card (cno,cname,department,type,cpassword) values('"+ no +"','" + name + "','" + dpt +"',"+type+",'" + pwd + "')";
    			s = c.createStatement();
        		s.execute(sql);
        		// System.out.println(no);
        		JOptionPane.showMessageDialog(null, "Successfully£¡","",JOptionPane.INFORMATION_MESSAGE);
    		}
    		else
    			JOptionPane.showMessageDialog(null, "The Card has existed£¡\nPlease try another CardID","",JOptionPane.INFORMATION_MESSAGE);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "The input information is not right.\nPlease try again.","",JOptionPane.INFORMATION_MESSAGE);
		}catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "The input information is not right.\nPlease try again.","",JOptionPane.INFORMATION_MESSAGE);
		}finally { 
            bookDAO.close(c, ps, result);
        }
	}
	public static Card select_stu(String no) {
		Connection c = null;
        PreparedStatement ps = null;
        Statement s = null;
        ResultSet result = null;
        Card card = null;
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
        		// System.out.println(no);
    			String cno = result.getString(1);
    			String cname = result.getString(2);
    			String dpt = result.getString(3);
    			int type = result.getInt(4);
    		 	String pwd = result.getString(5);  
    		 	card = new Card(cno, cname, dpt,type, pwd);
    		}
    		else
    			JOptionPane.showMessageDialog(null, "The card number does not exist!","",JOptionPane.INFORMATION_MESSAGE);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
		return card;
	}
	public static void delete_stu(String no) {
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
        		JOptionPane.showMessageDialog(null, "Delete Successfully£¡","",JOptionPane.INFORMATION_MESSAGE);
    		}
    		else
    			JOptionPane.showMessageDialog(null, "The Card ID dose not exist£¡","",JOptionPane.INFORMATION_MESSAGE);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            bookDAO.close(c, ps, result);
        }
	}
	public static Object[][]data(ArrayList<Card> aa){
		Object[][] tmp = new Object[aa.size()][5];
		for(int i=0;i<aa.size();i++) {
			Card card = aa.get(i);
			String type = null;
			switch(card.get_type()) {
			case 1: type = "Undergraduate";break;
			case 2: type = "Graduate";break;
			case 3: type = "Teacher";break;
			case 4: type = "Other";break;
			}
			Object[] cc = {card.get_cno(), card.get_cname(), card.get_dpt(), type,card.get_pwd()};
			tmp[i] = cc;
		}
		return tmp;
	}
}
