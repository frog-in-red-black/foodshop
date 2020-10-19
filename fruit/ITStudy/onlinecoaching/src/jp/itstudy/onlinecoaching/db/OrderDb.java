package jp.itstudy.onlinecoaching.db;

public class OrderDb {
    private int orderId;
    private int userId;
    private int courseId;
    private long price;
    private byte orderStatus; //默认1，1:已付款，2:待付款，3:待退款，4:已退款，5:取消订单
    private String ctime;
    private String mark;
        
	
	public OrderDb() {
		super();
	}
	public OrderDb(int orderId,  int userId, int courseId, long price, byte orderStatus,
			String ctime, String mark) {
		super();
		this.orderId = orderId;		
		this.userId = userId;
		this.courseId = courseId;
		this.price = price;
		this.orderStatus = orderStatus;
		this.ctime = ctime;
		this.mark = mark;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public byte getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(byte orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}  
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	
	
}
