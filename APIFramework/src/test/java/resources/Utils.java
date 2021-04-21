package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
		if(req==null)
		{
			PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
			req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
			return req;
		}
		return req;	
	}
	/*
	 * Purpose: to fetch static data from properties file by providing key 
	*/
	public static String getGlobalValue(String key) throws IOException
	{
		String propertiesFile = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\global.properties";
		Properties objProp =new Properties();
		FileInputStream fis =new FileInputStream(propertiesFile);
		objProp.load(fis);
		return objProp.getProperty(key);	
	}
	/*
	 * Purpose:to parse json and fetch required node data 
	*/
	public String getJsonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
