
public class adminAccount {
	private String loginName;
	private String password;

	public adminAccount(String loginName, String password) {
		this.loginName = loginName;
		this.password = password;
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
