package cucumber.Options;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features/userOperations.feature",
plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
		 "junit:target/cucumber-reports/Cucumber.xml",
		 "html:target/cucumber-reports",
		 "json:target/jsonReports/cucumber-report.json"},monochrome=true,glue= {"stepDefinations"})
public class TestRunner {

}
