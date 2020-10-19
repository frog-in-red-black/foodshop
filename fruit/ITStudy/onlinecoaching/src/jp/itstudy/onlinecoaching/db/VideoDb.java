package jp.itstudy.onlinecoaching.db;

public class VideoDb {
	private int videoId;
	private String videoName;
	private String videoUrl;
	private byte videoStatus;
	private byte videoStatus2;
	private int lessonId ;
	
	public VideoDb() {
		super();
	}

	public VideoDb(int videoId, String videoName, String videoUrl, byte videoStatus, byte videoStatus2, int lessonId) {
		super();
		this.videoId = videoId;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.videoStatus = videoStatus;
		this.videoStatus2 = videoStatus2;
		this.lessonId = lessonId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public byte getVideoStatus() {
		return videoStatus;
	}

	public void setVideoStatus(byte videoStatus) {
		this.videoStatus = videoStatus;
	}

	public byte getVideoStatus2() {
		return videoStatus2;
	}

	public void setVideoStatus2(byte videoStatus2) {
		this.videoStatus2 = videoStatus2;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	@Override
	public String toString() {
		return "videoDb [videoId=" + videoId + ", videoName=" + videoName + ", videoUrl=" + videoUrl + ", videoStatus="
				+ videoStatus + ", videoStatus2=" + videoStatus2 + ", lessonId=" + lessonId + "]";
	}
	
	
	
}
