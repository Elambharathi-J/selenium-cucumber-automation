package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featurefile"},
        glue = {"stepdefinition"},
        tags = "@staticDropdown",
        plugin = {"pretty",
                "html:target/testoutput/report.html",
                "json:target/testoutput/report.json",
                "junit:target/testoutput/report.xml"}
)
public class Runner{
}
