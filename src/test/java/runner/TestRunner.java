package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepdefinitions", "hooks"},
        publish = true,
        plugin = {"pretty",
                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/report.json"})
public class TestRunner {


}
