package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "StepDefinitions",
        tags = "@SmokeTesting or @Regression",
        plugin = {"json:target/cucumber.json"}
)

public class TestRunner {
}
