package jp.itstudy.onlinecoaching.until;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUnitl {

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  //mysqljdbc驱动
	public static final String DB_URL = "jdbc:mysql://localhost:3306/onlinecoaching";//jdbc:mysql://ip:端口号/数据库名
    public static final String USER = "root";   //用户名
    public static final String PASS = "123456";   //密码
    
    private static Connection connection;
    
    /*
     * 为了初始化加载连接数据库，放在static方法区块
     * */
    static {
    	try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("连接数据成功");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    public static Connection getConnection() {
		return connection;
	}
    
    public static boolean closeConnection() {
		boolean result = false;
		if(connection != null) {
			try {
				connection.close();
				result = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
    
}
