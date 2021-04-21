Feature: User specific operations
@AddUser 
Scenario Outline: Verify if new user is being succesfully added
	Given Add new user with "<name>" "<username>" "<email>" "<street>" "<suite>" "<city>" "<zipcode>" "<lat>" "<lng>" "<phone>" "<website>" "<c_name>" "<catchPhrase>" "<bs>"
	When user calls "AddOrDeleteOrUpdateOrGetUser" with "POST" http request
	Then the API call got success with status code 201
	
Examples:
|name   |username  |email            |street        |suite |city    |zipcode|lat      |lng       |phone     |website                 |c_name |catchPhrase |bs |
|JohnDoe|johndoe123|johndoe@yahoo.com|2,sutelstrasse|BG,546|Hannover|4575557|-54.54654|54.2423423|54-64-4654|https://www.djohndoe.com|Fynd   |HelloDoe    |XYZ| 
	 
@DeleteUser @PositiveTest
Scenario Outline: Delete existing user
	Given Delete existing user "<userid>" 
	When user calls "AddOrDeleteOrUpdateOrGetUser" with "DELETE" http request
	Then the API call got success with status code 200
	
Examples:
|userid|
|10    |

@DeleteUser @NegativeTest
Scenario Outline: Try to delete non-existing user
	Given Delete existing user "<userid>" 
	When user calls "AddOrDeleteOrUpdateOrGetUser" with "DELETE" http request
	Then the API call got success with status code 500
	
Examples:
|userid|
|17    |
	
@GetUserDetails @PositiveTest
Scenario Outline: Get existing user name
	Given Existing resource id "<userid>" 
	When user calls "AddOrDeleteOrUpdateOrGetUser" with "GET" http request
	Then the API call got success with status code 200
	And verify user name "<name>" from received response
	
Examples:
|userid|name                   |
|10    |Clementina DuBuque     |
	
@UpdateUserDetails @NegativeTest
Scenario Outline: try to update user which doesnot exist
	Given Update user "<userid>" "<name>"
	When user calls "AddOrDeleteOrUpdateOrGetUser" with "PUT" http request
	Then the API call got success with status code 500
	
Examples:
|userid|name       |
|12    |HarryPotter|
	
@AddPost @PositiveTest
Scenario Outline: Create new post with existing user ID
	Given Add new post with "<userid>" "<title>" "<body>"
	When user calls "AddOrDeleteOrUpdateOrGetPosts" with "POST" http request
	Then the API call got success with status code 201
	
Examples:
|userid|title      |body          |
|1     |My new post|New post added|
	
@AddPost @NegativeTest
Scenario Outline: Create new post for non-existing user ID
	Given Add new post with "<userid>" "<title>" "<body>"
	When user calls "AddOrDeleteOrUpdateOrGetPosts" with "POST" http request
	Then the API call got success with status code 500
	
Examples:
|userid |title        |body             |
|12     |My new post 1|New post 1 added |	

@UpdatePost @NegtiveTest
Scenario Outline: Update post which doesnot exist
	Given Update post "<id>" "<title>" "<body>" "<userid>"
	When user calls "AddOrDeleteOrUpdateOrGetPosts" with "PUT" http request
	Then the API call got success with status code 500
	
Examples:
|id|title      |body              |userid|
|11|Update post|Newly updated post|1     |