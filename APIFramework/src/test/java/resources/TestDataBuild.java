package resources;

import pojo.*;

public class TestDataBuild {

	/*POJO method to create JSON payload to Update User operation*/
	public UpdateUser updateUser(String userId,String name){
		
		UpdateUser objUD = new UpdateUser();
		objUD.setid(Integer.parseInt(userId));
		objUD.setName(name);
		return objUD;
	}
	
	/*POJO method to create JSON payload to Update post operation*/
	public UpdatePost updateExistingPost(String id,String title,String body,String userid){
		UpdatePost objUP = new UpdatePost();
		objUP.setId(Integer.parseInt(id));
		objUP.setTitle(title);
		objUP.setBody(body);
		objUP.setUserId(Integer.parseInt(userid));
		return objUP;
	}
	
	/*Sample method to create JSON payload for user delete operation*/
	public String deleteUserPayload(String userId)
	{
		return "{\r\n\"id\":\""+Integer.parseInt(userId)+"\"\r\n}";
	}
	
	/*POJO method to create JSON payload to create new user*/
	public AddUser addNewUser(String name,String username,String email,String street,String suite,String city,String zipcode,
			String lat,String lng,String phone,String website,String c_name,String catchPhrase, String bs)
	{
		AddUser objUser = new AddUser();
		objUser.setName(name);
		objUser.setEmail(email);
		objUser.setUsername(username);
		UserAddress objUA = new UserAddress();
		objUA.setStreet(street);
		objUA.setSuite(suite);
		objUA.setCity(city);
		objUA.setZipcode(zipcode);
		UserAddressGeoLocation objUAG = new UserAddressGeoLocation();
		objUAG.setLat(lat);
		objUAG.setLng(lng);
		objUA.setGeolocation(objUAG);
		objUser.setUserAddress(objUA);
		objUser.setPhone(phone);
		objUser.setWebsite(website);
		UserCompany objUC = new UserCompany();
		objUC.setName(c_name);
		objUC.setCatchPhrase(catchPhrase);
		objUC.setBs(bs);
		objUser.setUserCompanyDetails(objUC);
		return objUser;
	}
	
	/*POJO method to creates JSON payload to create new post*/
	public AddPost addNewUserPost(String userid,String title,String body){
		AddPost objAP = new AddPost();
		objAP.setUserId(Integer.parseInt(userid));
		objAP.setTitle(title);
		objAP.setBody(body);
		return objAP; 
	}
	
	/*POJO method to create JSON payload to Create new comments*/
	public AddComment addNewCommentOnPost(int postid,String name,String email,String body){
		AddComment objAC = new AddComment();
		objAC.setPostId(postid);
		objAC.setName(name);
		objAC.setEmail(email);
		objAC.setBody(body);
		return objAC;
	}
	
	/*POJO method to create JSON payload to create new album*/
	public AddAlbum addNewUserAlbum(int userid,String title){
		AddAlbum objALB = new AddAlbum();
		objALB.setUserId(userid);
		objALB.setTitle(title);
		return objALB;
	}
}
