package jp.itstudy.onlinecoaching.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.User;

import jp.itstudy.onlinecoaching.db.UserDb;
import jp.itstudy.onlinecoaching.db.UserListDb;
import jp.itstudy.onlinecoaching.until.MysqlUnitl;

public class UserModel {
	/**
	 * 查找用户
	 * 日期 20200925
	 * 作者 木木丸子
	 * 对应登陆方法
	 */
	public UserDb getUser(String  userPhone ,String userPassword) {
		UserDb result =new UserDb();
		Connection connection=MysqlUnitl.getConnection();
	
		String sql="select * from oc_user where userPhone = '"+userPhone  +"' and userPassword ='"+userPassword +"' ";
		PreparedStatement pStatement=null;
		try {
			pStatement= connection.prepareStatement(sql);
			ResultSet resultSet= pStatement.executeQuery();
			while (resultSet.next()) {
				result.setUserId(resultSet.getInt("userId"));
				result.setUserHeadimage(resultSet.getString("userHeadimage"));
				result.setUserTruename(resultSet.getString("userTruename"));
				result.setUserNickname(resultSet.getString(" userNickname"));
				result.setUserPassword(resultSet.getString(" userPassword"));
				//result.setUserCkpassword(resultSet.getString("userCkpassword"));
				result.setUserEmail(resultSet.getString("userEmail"));
				result.setUserPhone(resultSet.getString("userPhone"));
				result.setUserWechat(resultSet.getString("userWechat"));
				result.setUserLine(resultSet.getString("userLine"));
				result.setUserIntro(resultSet.getString(" userIntro"));
				result.setUserRole(resultSet.getByte("userRole"));
				result.setUserStatus(resultSet.getByte("userStatu"));
				result.setUserCtime(resultSet.getString("userCtime"));
				result.setUserChecknumber(resultSet.getString("userChecknumber"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pStatement!=null) {
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
	/**
	 * 
	 * 作者木木丸子
	 * 时间0925
	 * 方法 名 增加用户 对应 注册
	 * 返回值 int
	 * @return
	 */
	public int addUser(UserDb userDb) {
		int result=0;
		Connection connection=MysqlUnitl.getConnection();
		String sql="insert into oc_user( userHeadimage , userTruename, userNickname,userPassword,, userCkpassword,userEmail ,userPhone,  userWechat, userLine,userIntro,  userRole,  userStatus,userCtime,  userChecknumber values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pStatement=null;
		try {
			pStatement= connection.prepareStatement(sql);
			pStatement.setString(1, userDb.getUserHeadimage());
			pStatement.setString(2,userDb.getUserTruename());
			pStatement.setString(3, userDb.getUserNickname());
			pStatement.setString(4, userDb.getUserPassword());
			//pStatement.setString(5, userDb.getUserCkpassword());
			pStatement.setString(6, userDb.getUserEmail());
			pStatement.setString(7, userDb.getUserPhone());
			pStatement.setString(8, userDb.getUserWechat());
			pStatement.setString(9, userDb.getUserLine());
			pStatement.setString(10, userDb.getUserIntro());
			pStatement.setByte(11, userDb.getUserRole());
			pStatement.setByte(12, userDb.getUserStatus());
			pStatement.setString(13, userDb.getUserCtime());
			pStatement.setString(14, userDb.getUserChecknumber());
			result=pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pStatement!=null) {
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
	
	/**
	 * 作者木木丸子
	 * 方法名 getteacher 前四 
	 * 返回值 老师 model的arraylist  不用 任何参数
	 * 
	 */
	public ArrayList<UserDb> getTeacherList(int startIndex,int count) {

		ArrayList<UserDb> teacherList = new ArrayList<UserDb>();

		Connection connection = MysqlUnitl.getConnection();
		String sql = "select  * from oc_user where userRole = 2 and userStatus =1 and isRecommend = 1 limit "+startIndex+" ,"+count;
		System.out.println(sql);
		PreparedStatement pStatement = null;
		try {
			pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				UserDb result=new UserDb();
				result.setUserId(resultSet.getInt("userId"));
				result.setUserHeadimage(resultSet.getString("userHeadimage"));
				result.setUserTruename(resultSet.getString("userTruename"));
				result.setUserNickname(resultSet.getString("userNickname"));
				result.setUserPassword(resultSet.getString("userPassword"));
				//result.setUserCkpassword(resultSet.getString("userCkpassword"));
				result.setUserEmail(resultSet.getString("userEmail"));
				result.setUserPhone(resultSet.getString("userPhone"));
				result.setUserWechat(resultSet.getString("userWechat"));
				result.setUserLine(resultSet.getString("userLine"));
				result.setUserIntro(resultSet.getString("userIntro"));
				result.setUserRole(resultSet.getByte("userRole"));
				result.setUserStatus(resultSet.getByte("userStatus"));
				result.setUserCtime(resultSet.getString("userCtime"));
				result.setUserChecknumber(resultSet.getString("userChecknumber"));
				result.setIsRecommend(resultSet.getByte("isRecommend"));
				teacherList.add(result);
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
		return teacherList;
	
	}
	
	//获取user
	/*
	 * @pam startIndex 数据的起始位置
	 * @pam count 获取的条数
	 * @pam order 根据什么字段排序
	 * @pam sort  desc 逆序，asc 正序
	 * @pam userTruename 用户真名
	 * */
	public ArrayList<UserListDb> getUserList(int startIndex,int count,String order,String sort,String userTruename) {
		ArrayList<UserListDb> resultList = new ArrayList<>();
		
		Connection connection=MysqlUnitl.getConnection();
	
		String sql="select userId, userTruename, userRole,userStatus,userEmail from oc_user ";
		//如果课程不为空则增加检索条件
		if(!userTruename.isEmpty()) {
				sql += " where userTruename like '%"+ userTruename +"%' ";
		}
		
		 sql += " order by "+ order +"  " + sort + 
				" limit "+ startIndex +"," + count ;	
		System.out.println(sql);
		
		PreparedStatement pStatement=null;
		
		
		try {
			pStatement= connection.prepareStatement(sql);			
			ResultSet resultSet= pStatement.executeQuery();
			//System.out.println(resultSet.getNString(userEmail));
			while (resultSet.next()) {
				UserListDb result =new UserListDb();
				
				result.setUserId(resultSet.getInt("userId"));
				result.setUserTrueName(resultSet.getString("userTruename"));
				result.setUserRole(resultSet.getByte("userRole"));
				result.setUserStatus(resultSet.getByte("userStatus"));
				result.setUserEmail(resultSet.getString("userEmail"));
				
				resultList.add(result);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pStatement!=null) {
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
