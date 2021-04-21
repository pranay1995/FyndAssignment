package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import static org.junit.Assert.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	Cookies cookies;
	TestDataBuild data =new TestDataBuild();
	static String user_id;
	static String resource_id;
	
	@Given("Add new user with {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_new_user_with(String name, String username, String email, String street, String suite,
			String city, String zipcode, String lat, String lng, String phone, String website, 
			String c_name, String catchPhrase, String bs) throws IOException {
		 res=given().spec(requestSpecification())
		.body(data.addNewUser(name, username, email, street, suite, city, zipcode, lat, lng, phone, website, c_name, catchPhrase, bs));
	}
	
	@Given("Add new post with {string} {string} {string}")
    public void add_new_post_with(String userid, String title, String body) throws Throwable {
		res=given().spec(requestSpecification())
		.body(data.addNewUserPost(userid, title, body));
    }
	
	@Given("Update user {string} {string}")
    public void update_user(String userid, String name) throws Throwable {
		res=given().spec(requestSpecification()).pathParam("inputDataId", userid)
		.body(data.updateUser(userid, name));
    }
	
	@Given("Update post {string} {string} {string} {string}")
    public void update_post(String id,String title, String body,String userid) throws Throwable {
		res=given().spec(requestSpecification()).pathParam("inputDataId", id)
		.body(data.updateExistingPost(id, title, body, userid));
    }
	
	@Then("verify user_id created maps to {string} using {string}")
	public void verify_user_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		user_id=getJsonPath(response,"id");
		res=given().spec(requestSpecification()).queryParam("id",user_id).cookies(cookies);
		user_calls_with_http_request(resource,"GET");
		String actualName=getJsonPath(response,"name");
		assertEquals(actualName,expectedName);  
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		APIResources resourceAPI=APIResources.valueOf(resource);
		if(method.equalsIgnoreCase("POST")){
			response =res.when().post(resourceAPI.getResource());
		}else if(method.equalsIgnoreCase("GET")){
			response =res.when().get(resourceAPI.getResource());
		}else if(method.equalsIgnoreCase("DELETE")){
			response =res.when().delete(resourceAPI.getResource()+"/{inputDataId}");
		}else if(method.equalsIgnoreCase("PUT")){
			response =res.when().put(resourceAPI.getResource()+"/{inputDataId}");
		}
		cookies = response.getDetailedCookies();
	}
	
	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(int statusCode) {
		assertEquals(statusCode,response.getStatusCode());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String Expectedvalue) {
	    assertEquals(getJsonPath(response,keyValue),Expectedvalue);
	}
		
	@Given("Delete existing user {string}")
	public void delete_existing_user(String userid)throws IOException {
		user_id=userid;
		res =given().spec(requestSpecification()).pathParam("inputDataId", user_id);
	}
	
	@Given("Existing resource id {string}")
	public void existing_resource_id(String userid)throws IOException {
		resource_id=userid;
		res =given().spec(requestSpecification()).queryParam("id",resource_id);
	}
	
	@And("verify user name {string} from received response")
	public void verify_user_name_from_received_response(String name){
		String actualName=getJsonPath(response,"name");
		assertEquals(actualName,"["+name+"]");
	}
}
