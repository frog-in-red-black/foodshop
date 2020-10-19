package jp.itstudy.onlinecoaching.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jp.itstudy.onlinecoaching.db.VideoDb;
import jp.itstudy.onlinecoaching.until.MysqlUnitl;

public class VideoModel {
	public int addVideo(VideoDb videoDb) {
		
	int result = 0;

	// 1,连接数据库
	Connection connection = MysqlUnitl.getConnection();
	// 2 写sql? 防止语句注入的bug
	String sql = "insert into oc_video(videoName,videoUrl,videoStatus,videoStatus2,lessonId) values(?,?,?,?,?)";

	// 3 生成数据流
	PreparedStatement ptmt = null;
			
	try {
		ptmt = connection.prepareStatement(sql);
		ptmt.setString(1, videoDb.getVideoName());//第一个问号是userName对应string，setstring
		ptmt.setString(2, videoDb.getVideoUrl());
		ptmt.setByte(3, videoDb.getVideoStatus());
		ptmt.setByte(4, videoDb.getVideoStatus2());
		ptmt.setInt(5, videoDb.getLessonId());
		result = ptmt.executeUpdate();//对象预编译，结果放入变量result
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if (ptmt != null) {
			try {
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	return result;
}
}
