package jp.itstudy.onlinecoaching.db;

public class UserListDb {
	private int userId;
	private String userTrueName;
	private Byte userRole;
	private Byte userStatus;
	private String userEmail;
	
	public UserListDb() {
		super();
	}

	public UserListDb(int userId, String userTrueName, Byte userRole, Byte userStatus, String userEmail) {
		super();
		this.userId = userId;
		this.userTrueName = userTrueName;
		this.userRole = userRole;
		this.userStatus = userStatus;
		this.userEmail = userEmail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserTrueName() {
		return userTrueName;
	}

	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}

	public byte getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(byte userStatus) {
		this.userStatus= userStatus;
	}

	public Byte getUserRole() {
		return userRole;
	}

	public void setUserRole(Byte userRole) {
		this.userRole = userRole;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
