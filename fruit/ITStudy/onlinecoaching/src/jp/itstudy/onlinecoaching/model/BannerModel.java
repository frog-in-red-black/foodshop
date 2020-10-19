package jp.itstudy.onlinecoaching.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.itstudy.onlinecoaching.db.BannerDb;
import jp.itstudy.onlinecoaching.until.MysqlUnitl;

public class BannerModel {

	/* 获取广告
	 * @pam startIndex 起始位置
	 * @pam count 显示条数
	 * @return ArrayList<BannerDb> 多条广告
	 * id 倒叙 
	 * */
	public ArrayList<BannerDb> getBanner(int startIndex,int count) {
		ArrayList<BannerDb> resultList = new ArrayList<>();
		// 第一连接数据库
		Connection connection = MysqlUnitl.getConnection();

		// 第二步写sql
		String sql = "SELECT * FROM oc_banner where bannerStatus = 1 order by bannerId desc limit  "+ startIndex +"," + count;

		// 第三步生成一个数据库流
		PreparedStatement pStatement = null;

		try {
				pStatement = connection.prepareStatement(sql);

				// 第四步执行sql
				ResultSet resultSet = pStatement.executeQuery();// select 语句固定方法
				while (resultSet.next()) {
					BannerDb result = new BannerDb();
					result.setBannerId(resultSet.getInt("bannerId")); // resultSet.getInt("数据库的列名")
					result.setBannerName(resultSet.getString("bannerName"));
					result.setBannerUrl(resultSet.getString("bannerUrl"));
					result.setBannerCtime(resultSet.getString("bannerCtime"));
					result.setBannerStatus(resultSet.getByte("bannerStatus"));
					resultList.add(result);
				}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} finally {
			if (pStatement != null) {
				try {
					pStatement.close();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//end pStatement
		}//end try
		return resultList;
	}
	
	
}
