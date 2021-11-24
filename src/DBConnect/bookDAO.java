package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class bookDAO {
	public static void close(Connection c, PreparedStatement ps, ResultSet result) {
		if (ps != null)
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (c != null)
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        if (result != null)
            try {
            	result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
	}
	public static String loginJudge(String cno, String pwd) {
		Connection c = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        Statement s = null;
		String sql = "select * from library_zzy.card where cno = '" + cno + "'and cpassword = '" + pwd + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				 "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
            s = c.createStatement();
    		System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		if(result.next()) {
    			String cname = result.getString(2);
    			System.out.println("Correct");
    			return cname;
    		}else {
    			System.out.println("Wrong");
    			return null;
    		}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            close(c, ps, result);
        }
		return null;
	}
	public static Administratoe loginJudge_admin(String ano, String pwd) {
		Connection c = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        Statement s = null;
		String sql = "select * from library_zzy.administrator where ano = '" + ano + "'and password = '" + pwd + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driven Successfully!");
            c = DriverManager
            		.getConnection(
            				 "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            System.out.println("Success! Connected Object: " + c);
            ps = c.prepareStatement(sql);
            s = c.createStatement();
    		System.out.println("Statement Object:" + s);
    		result = ps.executeQuery();
    		if(result.next()) {
    			Administratoe admin = new Administratoe(ano,result.getString(2),result.getString(3),result.getString(4));
    			System.out.println("Correct");
    			return admin;
    		}else {
    			System.out.println("Wrong");
    			return null;
    		}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            close(c, ps, result);
        }
		return null;
	}
	
}
