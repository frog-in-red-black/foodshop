package jp.itstudy.onlinecoaching.db;

public class CourseDb {
	private int id;
	 private String courseName;
	 private int courseStatus; // 默认1，1:下架，2:上架
	 private int checked; //默认1，1:未通过，2:通过，3:审核中
	 private int courseHour;
	 private String startDate;
	 private String endDate;
	 private double price;
	 private double salePrice;
	 private String courseImg;
	 private int lessonVideroNum;
	 private int courseTypeId;
	 private String teacherName;
	 private int recommand;
	 private int live;
	 private int courseRank;
	 private int teacherId;
	 private int setCourse;
	 private int setCourseId;
	 private String introduction;
	 private String mark;
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
	public int getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(int courseStatus) {
		this.courseStatus = courseStatus;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
	}
	public int getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public String getCourseImg() {
		return courseImg;
	}
	public void setCourseImg(String courseImg) {
		this.courseImg = courseImg;
	}
	public int getLessonVideroNum() {
		return lessonVideroNum;
	}
	public void setLessonVideroNum(int lessonVideroNum) {
		this.lessonVideroNum = lessonVideroNum;
	}
	public int getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getRecommand() {
		return recommand;
	}
	public void setRecommand(int recommand) {
		this.recommand = recommand;
	}
	public int getLive() {
		return live;
	}
	public void setLive(int live) {
		this.live = live;
	}
	public int getCourseRank() {
		return courseRank;
	}
	public void setCourseRank(int courseRank) {
		this.courseRank = courseRank;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getSetCourse() {
		return setCourse;
	}
	public void setSetCourse(int setCourse) {
		this.setCourse = setCourse;
	}
	public int getSetCourseId() {
		return setCourseId;
	}
	public void setSetCourseId(int setCourseId) {
		this.setCourseId = setCourseId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public CourseDb(int id, String courseName, int courseStatus, int checked, int courseHour, String startDate,
			String endDate, double price, double salePrice, String courseImg, int lessonVideroNum, int courseTypeId,
			String teacherName, int recommand, int live, int courseRank, int teacherId, int setCourse, int setCourseId,
			String introduction, String mark) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseStatus = courseStatus;
		this.checked = checked;
		this.courseHour = courseHour;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
		this.salePrice = salePrice;
		this.courseImg = courseImg;
		this.lessonVideroNum = lessonVideroNum;
		this.courseTypeId = courseTypeId;
		this.teacherName = teacherName;
		this.recommand = recommand;
		this.live = live;
		this.courseRank = courseRank;
		this.teacherId = teacherId;
		this.setCourse = setCourse;
		this.setCourseId = setCourseId;
		this.introduction = introduction;
		this.mark = mark;
	}
	public CourseDb() {
		super();
	}
	

}
