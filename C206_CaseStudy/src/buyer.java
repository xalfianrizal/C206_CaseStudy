
public class buyer {
	private int buyerID;
	private String buyerName;
	private int buyerMobileNo;
	
	public buyer(int buyerID,String buyerName,int buyerMobileNo) {
		this.buyerID = buyerID;
		this.buyerName = buyerName;
		this.buyerMobileNo = buyerMobileNo;
	}

	public int getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(int buyerID) {
		this.buyerID = buyerID;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public int getBuyerMobileNo() {
		return buyerMobileNo;
	}

	public void setBuyerMobileNo(int buyerMobileNo) {
		this.buyerMobileNo = buyerMobileNo;
	}
	public String display() {
		String output = "";
		output += String.format("%-10d %-20s %-10d", buyerID, buyerName, buyerMobileNo);
		
		return output;
	}
}
