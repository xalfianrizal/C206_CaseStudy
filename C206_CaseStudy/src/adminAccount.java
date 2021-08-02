
public class adminAccount {
	private int adminAccountID;
	private String loginName;
	private String password;

	public adminAccount(int adminAccountID,String loginName, String password) {
		this.adminAccountID = adminAccountID;
		this.loginName = loginName;
		this.password = password;
	}

	public int getAdminAccountID() {
		return adminAccountID;
	}

	public void setAdminAccountID(int adminAccountID) {
		this.adminAccountID = adminAccountID;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean valid(String loginName, String password) {
		if (this.loginName.equalsIgnoreCase(loginName) && this.password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
