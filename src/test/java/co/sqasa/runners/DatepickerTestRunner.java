package co.sqasa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/datepicker",
        glue = {"co.sqasa.stepdefinitions", "co.sqasa.hooks"},
        tags = "@datepicker",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report",
                "json:target/cucumber-reports/json-report/Cucumber.json",
                "junit:target/cucumber-reports/junit-report/Cucumber.xml"
        }
)
public class DatepickerTestRunner {
}
