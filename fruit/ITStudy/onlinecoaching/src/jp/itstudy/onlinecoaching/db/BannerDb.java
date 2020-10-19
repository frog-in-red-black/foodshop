package jp.itstudy.onlinecoaching.db;

public class BannerDb {
	/**
	 * bannerId int unsigned primary key auto_increment comment '广告id',
    bannerName varchar(255) not null comment '广告名字',
    bannerUrl varchar(255) not null comment '广告地址',
    bannerCtime timestamp comment '广告创建时间',
    bannerStatus tinyint default 1 comment '默认1 1使用 2禁用'
	 */
	
	private int bannerId ;
	private String  bannerName;
	private String   bannerUrl;
	private String bannerCtime;
	private Byte  bannerStatus;
	public int getBannerId() {
		return bannerId;
	}
	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}
	public String getBannerName() {
		return bannerName;
	}
	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
	public String getBannerUrl() {
		return bannerUrl;
	}
	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}
	public String getBannerCtime() {
		return bannerCtime;
	}
	public void setBannerCtime(String bannerCtime) {
		this.bannerCtime = bannerCtime;
	}
	public Byte getBannerStatus() {
		return bannerStatus;
	}
	public void setBannerStatus(Byte bannerStatus) {
		this.bannerStatus = bannerStatus;
	}
	public BannerDb(int bannerId, String bannerName, String bannerUrl, String bannerCtime, Byte bannerStatus) {
		super();
		this.bannerId = bannerId;
		this.bannerName = bannerName;
		this.bannerUrl = bannerUrl;
		this.bannerCtime = bannerCtime;
		this.bannerStatus = bannerStatus;
	}
	public BannerDb() {
		super();
	}
	@Override
	public String toString() {
		return "BannerDb [bannerId=" + bannerId + ", bannerName=" + bannerName + ", bannerUrl=" + bannerUrl
				+ ", bannerCtime=" + bannerCtime + ", bannerStatus=" + bannerStatus + "]";
	}
	
	
}
