package jp.itstudy.onlinecoaching.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.itstudy.onlinecoaching.db.CourseTypeDb;
import jp.itstudy.onlinecoaching.until.MysqlUnitl;

public class CourseTypeModel {

	/*
	 * 获取所有分类
	 * */
	public ArrayList<CourseTypeDb> getTypeAll() {
		ArrayList<CourseTypeDb> resultList = new ArrayList<>();
		
			
			// 第一连接数据库
			Connection connection = MysqlUnitl.getConnection();

			// 第二步写sql
			String sql = " select * from oc_course_type ";
			
			// 第三步生成一个数据库流
					PreparedStatement pStatement = null;
					try {
						pStatement = connection.prepareStatement(sql);

						// 第四步执行sql
						ResultSet resultSet = pStatement.executeQuery();
						while (resultSet.next()) {
							CourseTypeDb courseTypeDb = new CourseTypeDb(resultSet.getInt("courseTypeId"),
									resultSet.getString("courseTypeName"),resultSet.getInt("pid"));
									resultList.add(courseTypeDb);
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
						}
					}
				
		
		return resultList;
	}
}
