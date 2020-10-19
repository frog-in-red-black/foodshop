package jp.itstudy.onlinecoaching.db;

public class CourseTypeDb {
	private int courseTypeId;
	private String courseTypeName;
	private int  pid;
	public int getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public String getCourseTypeName() {
		return courseTypeName;
	}
	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public CourseTypeDb(int courseTypeId, String courseTypeName, int pid) {
		super();
		this.courseTypeId = courseTypeId;
		this.courseTypeName = courseTypeName;
		this.pid = pid;
	}
	public CourseTypeDb() {
		super();
	}
	@Override
	public String toString() {
		return "CourseTypeDb [courseTypeId=" + courseTypeId + ", courseTypeName=" + courseTypeName + ", pid=" + pid
				+ "]";
	}
	
	
}
