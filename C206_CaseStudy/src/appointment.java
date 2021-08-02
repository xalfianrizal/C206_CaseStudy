
public class appointment {
	private int appointmentID;
	private String customerName;
	private String date;
	private String time;
	private String status;

	public appointment(int appointmentID,String customerName, String date, String time) {
		this.appointmentID = appointmentID;
		this.customerName = customerName;
		this.date = date;
		this.time = time;
		this.status = "Not collected";
	}
	
	public int getAppointmentID() {
		return appointmentID;
	}
	
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String display() {
		String output = "";
		output += String.format("%-10d %-10s %-20s %-10s %-10s", appointmentID, customerName, date, time, status);

		return output;
	}
}
