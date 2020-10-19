package jp.itstudy.onlinecoaching.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.itstudy.onlinecoaching.db.OrderDb;
import jp.itstudy.onlinecoaching.until.MysqlUnitl;

public class OrderModel {

	public int cancelOrder(int orderId) {
		OrderDb orderDb = new OrderDb();
		int result=0;
		
		//连接数据库
		Connection connection = MysqlUnitl.getConnection();
		
		//sql
		String sql="update oc_order set orderStatus=5 where orderId="+orderDb.getOrderId();
		
		//生成数据流
		PreparedStatement pStatement = null;		
		
		try {
			pStatement = connection.prepareStatement(sql);
			
	    //执行sql
		result =  pStatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(pStatement != null) {
				try {
					pStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
		return result;
		
	}		
	
	
	
	
}
