
public class feedBack {
	private String customerName;
	private String message;
	private String status;
	
	public feedBack(String customerName,String message) {
		this.customerName = customerName;
		this.message = message;
		this.status = "Pending";
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
}
