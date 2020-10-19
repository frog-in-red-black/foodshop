package jp.itstudy.onlinecoaching.db;

public class CourseListDb {
	private int id;
	private String courseName;
	private String courseTypeName;
	private String userTruename ;
	private String ctime;
	private int teacherId;
	private int courseTypeId;
	private byte courseStatus;// 1:下架 2；上架
	private byte checked; // 1：未通过 2：通过 3：审核中
	
	
	public CourseListDb() {
		super();
	}
	public CourseListDb(int id, String courseName, String courseTypeName, String userTruename, String ctime,
			int teacherId, int courseTypeId, byte courseStatus, byte checked) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseTypeName = courseTypeName;
		this.userTruename = userTruename;
		this.ctime = ctime;
		this.teacherId = teacherId;
		this.courseTypeId = courseTypeId;
		this.courseStatus = courseStatus;
		this.checked = checked;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseTypeName() {
		return courseTypeName;
	}
	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}
	public String getUserTruename() {
		return userTruename;
	}
	public void setUserTruename(String userTruename) {
		this.userTruename = userTruename;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public byte getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(byte courseStatus) {
		this.courseStatus = courseStatus;
	}
	public byte getChecked() {
		return checked;
	}
	public void setChecked(byte checked) {
		this.checked = checked;
	}
	@Override
	public String toString() {
		return "CourseListDb [id=" + id + ", courseName=" + courseName + ", courseTypeName=" + courseTypeName
				+ ", userTruename=" + userTruename + ", ctime=" + ctime + ", teacherId=" + teacherId + ", courseTypeId="
				+ courseTypeId + ", courseStatus=" + courseStatus + ", checked=" + checked + "]";
	}
	
	
}
