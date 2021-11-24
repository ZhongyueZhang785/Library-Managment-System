package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test_JDBC {
	public static void main(String[] arg0) {
		Connection c = null;
        Statement s = null;
        ResultSet result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driven Successfully!");
            c = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/library_zzy?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8",
                            "root","zhangzhongyue123");
            System.out.println("Success! Connected Object: " + c);
    		s = c.createStatement();
    		System.out.println("Statement Object:" + s);
    		String sql = "select * from book";
    		result = s.executeQuery(sql);
    		while(result.next()) {
    			String name = result.getString("title");
        		System.out.println(name);
    		}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
            e.printStackTrace();
		}finally { 
            if (s != null)
                try {
                    s.close();
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
	}
}
