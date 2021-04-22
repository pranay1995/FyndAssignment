# API Testing framework

BDD framework for testing API's and CRUD operations on resources from (https://jsonplaceholder.typicode.com/)

## Targeted resources:
* users:    (https://jsonplaceholder.typicode.com/users)
* posts:    (https://jsonplaceholder.typicode.com/posts)
* comments: (https://jsonplaceholder.typicode.com/comments)
* albums:   (https://jsonplaceholder.typicode.com/albums)

## Implementation details:
### Technical details:
* Tools:        Eclipse IDE
* Framework:    RestAssured JAVA API, Unit
* Test scripts: Gherkin
* Test data:    JSON payload for PUT/POST operation created dynamically using POJO. no external file   
* Reporting:    JSON, xml, [Cucumber report](https://github.com/damianszczepanik/cucumber-reporting)
* Build:        Maven

### Scenarios implemented
All scenarios are implemented in Gherkin under [userOperations.feature](https://github.com/pranay1995/FyndAssignment/blob/63b2fa22508a3644de326834095af81e81fe85fc/APIFramework/src/test/java/features/userOperations.feature) including test data in example.
1. Create new user
2. Delete existing user: Positive test
3. Delete non-existing user: Negative test
4. Fetch user using ID and verify name with expected data
5. Update non-existing user details: Negative test
6. Create new post for existing user: Positive test
7. Create new post for non-exisiting user: Negative test
8. Update post which does not exist: Negative test

### JSON payload for PUT/POST operation
* JSON are programmed using POJO classes. No external **json files** are prepared. 
* Data mentioned in feature file refer at run time by gherkins steps and stepDefinition class methods.
* POJO package has classes to create json payload using getters & setters (encapsulated) 
e.g. [AddUser](https://github.com/pranay1995/FyndAssignment/blob/9ee415ee1009222d66e2ffff69cd983aa1e1707e/APIFramework/src/main/java/pojo/AddUser.java),[AddPost](https://github.com/pranay1995/FyndAssignment/blob/9ee415ee1009222d66e2ffff69cd983aa1e1707e/APIFramework/src/main/java/pojo/AddPost.java) etc.
* The java object created using POJO implementation is serialized JSON payload send in body and then response in deserialized back to java object.

## How to test build ?
### Pre-requisite
1. Install Maven in your system
2. Download this project or clone repository in your system
3. Locate **\FyndAssignment\APIFramework\** path
4. Launch command prompt
5. change directory to above path using command **cd path**
#### Commands to run project/test
1. To compile build **mvn compile**
2. To run whole build including all test featues use **"mvn test verify"**. Note: Verify command is must to generate cucumber HTML report
#### Commands to test specific scenario listed above
1. Create new user: **mvn test verify -Dcucumber.options="--tags @AddUser"**
