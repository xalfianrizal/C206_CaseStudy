
public class feedBack {
	private int feedBackID;
	private String customerName;
	private String message;
	private String status;
	
	public feedBack(int feedBackID,String customerName,String message) {
		this.feedBackID = feedBackID;
		this.customerName = customerName;
		this.message = message;
		this.status = "Pending";
	}
	public int getFeedBackID() {
		return feedBackID;
	}
	public void setFeedBackID(int feedBackID) {
		this.feedBackID = feedBackID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String display() {
		String output = "";
		output += String.format("%-10s %-10s %-30s %-10s", feedBackID, customerName, message, status);
		
		return output;
	}
}
