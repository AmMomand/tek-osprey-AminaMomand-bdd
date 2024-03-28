package tek.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "tek.bdd.steps",
        dryRun = false,
        tags = "@Story_1",
        plugin = {
                "pretty",
                "html:target/html_report/index.html",
        }
)
public class SecurityTestRunner {
}
