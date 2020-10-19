package jp.itstudy.onlinecoaching.db;

public class UserDb {
	/**
	 * userId int unsigned primary key auto_increment comment '用户id', userHeadimage
	 * varchar(255) comment '用户头像', userTruename varchar(50) not null comment
	 * '用户真实姓名', userNickname varchar(50) not null comment '用户昵称', userPassword
	 * varchar(100) not null comment '用户密码', userCkpassword varchar(100) not null
	 * comment '用户再次确认密码', userEmail varchar(255) not null comment '用户邮箱', userPhone
	 * varchar(20) not null comment '用户手机号', userWechat varchar(20) comment '用户微信',
	 * userLine varchar(20) comment '用户line', userIntro text comment '用户简介',
	 * userRole tinyint default 1 comment '默认1 1学生 2 老师 3管理员', userStatus tinyint
	 * default 1 comment '默认1 1 使用 2 禁用', userCtime timestamp comment '用户创建时间',
	 * userChecknumber varchar(255) comment '短信验证码'
	 */
	private int userId;
	private String userHeadimage;
	private String userTruename;
	private String userNickname;
	private String userPassword;
	private String userEmail;
	private String userPhone;
	private String userWechat;
	private String userLine;
	private String userIntro;
	private Byte userRole;
	private Byte userStatus;
	private String userCtime;
	private String userChecknumber;
	private byte isRecommend;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserHeadimage() {
		return userHeadimage;
	}
	public void setUserHeadimage(String userHeadimage) {
		this.userHeadimage = userHeadimage;
	}
	public String getUserTruename() {
		return userTruename;
	}
	public void setUserTruename(String userTruename) {
		this.userTruename = userTruename;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserWechat() {
		return userWechat;
	}
	public void setUserWechat(String userWechat) {
		this.userWechat = userWechat;
	}
	public String getUserLine() {
		return userLine;
	}
	public void setUserLine(String userLine) {
		this.userLine = userLine;
	}
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	public Byte getUserRole() {
		return userRole;
	}
	public void setUserRole(Byte userRole) {
		this.userRole = userRole;
	}
	public Byte getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Byte userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserCtime() {
		return userCtime;
	}
	public void setUserCtime(String userCtime) {
		this.userCtime = userCtime;
	}
	public String getUserChecknumber() {
		return userChecknumber;
	}
	public void setUserChecknumber(String userChecknumber) {
		this.userChecknumber = userChecknumber;
	}
	public byte getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(byte isRecommend) {
		this.isRecommend = isRecommend;
	}
	public UserDb(int userId, String userHeadimage, String userTruename, String userNickname, String userPassword,
			String userEmail, String userPhone, String userWechat, String userLine, String userIntro, Byte userRole,
			Byte userStatus, String userCtime, String userChecknumber, byte isRecommend) {
		super();
		this.userId = userId;
		this.userHeadimage = userHeadimage;
		this.userTruename = userTruename;
		this.userNickname = userNickname;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userWechat = userWechat;
		this.userLine = userLine;
		this.userIntro = userIntro;
		this.userRole = userRole;
		this.userStatus = userStatus;
		this.userCtime = userCtime;
		this.userChecknumber = userChecknumber;
		this.isRecommend = isRecommend;
	}
	public UserDb() {
		super();
	}
	@Override
	public String toString() {
		return "UserDb [userId=" + userId + ", userHeadimage=" + userHeadimage + ", userTruename=" + userTruename
				+ ", userNickname=" + userNickname + ", userPassword=" + userPassword + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + ", userWechat=" + userWechat + ", userLine=" + userLine + ", userIntro="
				+ userIntro + ", userRole=" + userRole + ", userStatus=" + userStatus + ", userCtime=" + userCtime
				+ ", userChecknumber=" + userChecknumber + ", isRecommend=" + isRecommend + "]";
	}

	

}
