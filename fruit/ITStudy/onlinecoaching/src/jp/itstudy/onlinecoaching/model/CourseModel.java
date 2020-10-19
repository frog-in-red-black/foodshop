package jp.itstudy.onlinecoaching.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

import jp.itstudy.onlinecoaching.db.BannerDb;
import jp.itstudy.onlinecoaching.db.CourseDb;
import jp.itstudy.onlinecoaching.db.CourseListDb;
import jp.itstudy.onlinecoaching.until.MysqlUnitl;

public class CourseModel {

	/*
	 * 根据用户id获取视频
	 * @pam userId 用户id
	 * @pam startIndex 数据的起始位置
	 * @pam count 获取的条数
	 * @pam order 根据什么字段排序
	 * @pam sort  desc 逆序，asc 正序
	 * @pam courseNmae 课程名
	 * @pam courseTypeId 课程分类id
	 * */
	public ArrayList<CourseListDb> getCourseByUserId(int userId,int startIndex,int count,String order,String sort,String courseName,int courseTypeId) {
		ArrayList<CourseListDb> resultList = new ArrayList<>();
		// 第一连接数据库
				Connection connection = MysqlUnitl.getConnection();

				// 第二步写sql
				String sql = "select a.id,a.courseName,c.courseTypeName,b.userTruename ,a.ctime, a.teacherId,a.courseTypeId, a.courseStatus,a.checked " + 
						" from oc_course a left join oc_user  b on a.teacherId = b.userId " + 
						" left join oc_course_type c on a.courseTypeId = c.courseTypeId  " + 
						" where b.userId = "+userId;
				
				//如果课程不为空则增加检索条件
				if(!courseName.isEmpty()) {
						sql += " and a.courseName like '%"+ courseName +"%' ";
				}
				
				//根据课程分类检索
				if(courseTypeId > 0) {
					sql += " and a.courseTypeId = " + courseTypeId;
				}
				
					  sql += " order by "+ order +"  " + sort + 
						" limit "+ startIndex +"," + count ;	
				System.out.println(sql);
				// 第三步生成一个数据库流
				PreparedStatement pStatement = null;

				try {
						pStatement = connection.prepareStatement(sql);

						// 第四步执行sql
						ResultSet resultSet = pStatement.executeQuery();// select 语句固定方法
						while (resultSet.next()) {
							CourseListDb courseListDb = new CourseListDb(resultSet.getInt("id"),resultSet.getString("courseName") ,resultSet.getString("courseTypeName") , resultSet.getString("userTruename"),resultSet.getString("ctime") ,resultSet.getInt("teacherId") , resultSet.getInt("courseTypeId"),resultSet.getByte("courseStatus") ,resultSet.getByte("checked") );
							resultList.add(courseListDb);
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
	
	/*
	 * 获热门视频根据订单
	 * @pam startIndex 数据的起始位置
	 * @pam count 获取的条数
	 * */
	public ArrayList<CourseDb> getHostCourse(int startIndex,int count) {
		ArrayList<CourseDb> resultList = new ArrayList<CourseDb>();

		// 第一连接数据库
		Connection connection = MysqlUnitl.getConnection();

		// 第二步写sql
		String sql = " SELECT * FROM onlinecoaching.oc_course as a , " + 
				" (SELECT courseId,count(*) total FROM onlinecoaching.oc_order " + 
				" group by courseId  ) as b " + 
				" where a.id = b.courseId and courseStatus = 2 " + 
				" order by total desc,courseId desc " + 
				" limit "+ startIndex +"," + count ;

		// 第三步生成一个数据库流
		PreparedStatement pStatement = null;

		try {
			pStatement = connection.prepareStatement(sql);

			// 第四步执行sql
			ResultSet resultSet = pStatement.executeQuery();// select 语句固定方法
			while (resultSet.next()) {
				CourseDb recommandCourseDb = new CourseDb();
				recommandCourseDb.setCourseTypeId(resultSet.getInt("courseTypeId"));
				recommandCourseDb.setCourseName(resultSet.getString("courseName"));
				recommandCourseDb.setTeacherId(resultSet.getInt("TeacherId"));
				recommandCourseDb.setLive(resultSet.getInt("live"));
				recommandCourseDb.setPrice(resultSet.getFloat("price"));
				recommandCourseDb.setCourseImg(resultSet.getString("courseImg"));
				recommandCourseDb.setIntroduction(resultSet.getString("introduction"));
				recommandCourseDb.setId(resultSet.getInt("id"));
				resultList.add(recommandCourseDb);
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
	
	
	/*
	 * 获取推荐课程
	 * @pam startIndex 数据的起始位置
	 * @pam count 获取的条数
	 * */
	public ArrayList<CourseDb> getRecommandCourseByCourseId(int startIndex,int count) {
		ArrayList<CourseDb> resultList = new ArrayList<>();
		
			
			// 第一连接数据库
			Connection connection = MysqlUnitl.getConnection();

			// 第二步写sql
			/*String sql = " select * from oc_course where id in (";
			for (int i=0;i<CourseIdList.length-1; i++) {
				
				sql+="'"+CourseIdList[i]+"'"+",";
			}
			sql+="'"+CourseIdList[CourseIdList.length-1]+"'"+")";*/
			String sql = "SELECT * FROM oc_course where recommand = 1 and courseStatus = 2";
			sql += " order by id desc  limit "+ startIndex +"," + count ;	
			
			
			// 第三步生成一个数据库流
					PreparedStatement pStatement = null;
					try {
						pStatement = connection.prepareStatement(sql);

						// 第四步执行sql
						ResultSet resultSet = pStatement.executeQuery();
						while (resultSet.next()) {
							CourseDb recommandCourseDb = new CourseDb();
							recommandCourseDb.setCourseTypeId(resultSet.getInt("courseTypeId"));
							recommandCourseDb.setCourseName(resultSet.getString("courseName"));
							recommandCourseDb.setTeacherId(resultSet.getInt("TeacherId"));
							recommandCourseDb.setLive(resultSet.getInt("live"));
							recommandCourseDb.setPrice(resultSet.getFloat("price"));
							recommandCourseDb.setCourseImg(resultSet.getString("courseImg"));
							recommandCourseDb.setId(resultSet.getInt("id"));
							
									resultList.add(recommandCourseDb);
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
	
	/*
	 * 获取登录用户的课程
	 * @pam uid 数据的起始位置
	 * @pam startIndex 数据的起始位置
	 * @pam count 获取的条数
	 * */
	public ArrayList<CourseDb> getCourseByUid(int uid,int startIndex,int count) {
		ArrayList<CourseDb> resultList = new ArrayList<>();
		
			
			// 第一连接数据库
			Connection connection = MysqlUnitl.getConnection();

			// 第二步写sql
			
			String sql = "SELECT * FROM oc_order as a left join oc_course as b on a.courseId = b.id " + 
					"where a.userId = "+uid+" order by a.ctime desc ";
			sql += " limit "+ startIndex +"," + count ;	
			
			
			// 第三步生成一个数据库流
					PreparedStatement pStatement = null;
					try {
						pStatement = connection.prepareStatement(sql);

						// 第四步执行sql
						ResultSet resultSet = pStatement.executeQuery();
						while (resultSet.next()) {
							CourseDb recommandCourseDb = new CourseDb();
							recommandCourseDb.setCourseTypeId(resultSet.getInt("courseTypeId"));
							recommandCourseDb.setCourseName(resultSet.getString("courseName"));
							recommandCourseDb.setTeacherId(resultSet.getInt("TeacherId"));
							recommandCourseDb.setLive(resultSet.getInt("live"));
							recommandCourseDb.setPrice(resultSet.getFloat("a.price"));
							recommandCourseDb.setCourseImg(resultSet.getString("courseImg"));
							recommandCourseDb.setId(resultSet.getInt("id"));
							
							resultList.add(recommandCourseDb);
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
	public ArrayList<CourseDb> getAllCourse(){
		ArrayList<CourseDb> resultList = new ArrayList<>();
		
		
		// 第一连接数据库
		Connection connection = MysqlUnitl.getConnection();

		// 第二步写sql
		String sql = " select * from oc_course ";
		
		if(!courseName.isEmpty()) {
			sql += " and a.courseName like '%"+ courseName +"%' ";
	}
	
	//根据课程分类检索
	if(courseTypeId > 0) {
		sql += " and a.courseTypeId = " + courseTypeId;
	}
	
		  sql += " order by "+ order +"  " + sort + 
			" limit "+ startIndex +"," + count ;	
	System.out.println(sql);
		
		// 第三步生成一个数据库流
				PreparedStatement pStatement = null;
				try {
					pStatement = connection.prepareStatement(sql);

					// 第四步执行sql
					ResultSet resultSet = pStatement.executeQuery();
					while (resultSet.next()) {
						CourseDb courseDb = new CourseDb();
						courseDb.setId(resultSet.getInt("id"));
						courseDb.setCourseName(resultSet.getString("courseName"));		
						courseDb.setMark(resultSet.getString("mark"));
						courseDb.setIntroduction(resultSet.getString("introduction"));
						courseDb.setPrice(resultSet.getFloat("price"));
								resultList.add(courseDb);
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
