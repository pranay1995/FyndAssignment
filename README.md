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
All scenarios are implemented in Gherkin under userOperations.feature
* Create new user
* Delete existing user: Positive test
* Delete non-existing user: Negative test
* Fetch user using ID and verify name with expected data
* Update non-existing user details: Negative test
* Create new post for existing user: Positive test
* Create new post for non-exisiting user: Negative test
* Update post which does not exist: Negative test
