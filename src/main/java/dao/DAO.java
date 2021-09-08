package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	public static Connection connection;
	private String DB_URL = "jdbc:mysql://localhost:3306/bookshop?useUnicode=true&characterEncoding=utf8";
    private String USER_NAME = "root";
    private String PASSWORD = "root";
    
	public DAO() {
		if(connection==null) {
			try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
	        } catch(Exception e){
	            e.printStackTrace();
	        }
		}
	}

}
