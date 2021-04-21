package pojo;

public class AddUser {

	private String name;
	private String username;
	private String email;
	private UserAddress userAddress;
	private String phone;
	private String website;
	private UserCompany userCompanyDetails;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public UserCompany getUserCompanyDetails() {
		return userCompanyDetails;
	}
	public void setUserCompanyDetails(UserCompany userCompanyDetails) {
		this.userCompanyDetails = userCompanyDetails;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
}
