# API Testing framework

BDD framework for testing API's and CRUD operations on resources from (https://jsonplaceholder.typicode.com/)

### Targeted resources:
* users:    (https://jsonplaceholder.typicode.com/users)
* posts:    (https://jsonplaceholder.typicode.com/posts)
* comments: (https://jsonplaceholder.typicode.com/comments)
* albums:   (https://jsonplaceholder.typicode.com/albums)

### Implementation details:
#### Technical details:
* Tools:        Eclipse IDE
* Framework:    RestAssured JAVA API, Unit
* Test scripts: Gherkin
* Reporting:    JSON, [Cucumber report](https://github.com/damianszczepanik/cucumber-reporting)
* Build:        Maven

#### Scenarios implemented
All scenarios are implemented in Gherkin under [userOperations.feature](https://github.com/pranay1995/FyndAssignment/blob/63b2fa22508a3644de326834095af81e81fe85fc/APIFramework/src/test/java/features/userOperations.feature)
* Create new user
* Delete existing user: Positive test
* Delete non-existing user: Negative test
* Fetch user using ID and verify name with expected data
* Update non-existing user details: Negative test
* Create new post for existing user: Positive test
* Create new post for non-exisiting user: Negative test
* Update post which does not exist: Negative test

#### JSON payload for PUT/POST operation
* JSON are programmed using POJO classes. No external .json files are prepared. 
* Data mentioned in feature file refered at run time by gherkins steps and stepDefinition class methods.
* POJO package has classes to create json payload using getters & setters (encapsulated) 
e.g. [AddUser](https://github.com/pranay1995/FyndAssignment/blob/9ee415ee1009222d66e2ffff69cd983aa1e1707e/APIFramework/src/main/java/pojo/AddUser.java),[AddPost(https://github.com/pranay1995/FyndAssignment/blob/9ee415ee1009222d66e2ffff69cd983aa1e1707e/APIFramework/src/main/java/pojo/AddPost.java)
