package JDITestsCucumber.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/JDITestsCucumber", glue = "JDITestsCucumber.steps", tags = "@Smoke")
//@CucumberOptions(features = "src/test/resources/JDITestsCucumber/DifferentElementsPageFeature.feature", glue = "JDITestsCucumber.steps")
//@CucumberOptions(features = "src/test/resources/JDITestsCucumber/MetalsAndColorsPageFeature.feature", glue = "JDITestsCucumber.steps")
//@CucumberOptions(features = "src/test/resources/JDITestsCucumber/TableWithPagesPageFeature.feature", glue = "JDITestsCucumber.steps")
@CucumberOptions(features = "src/test/resources/JDITestsCucumber/", glue = "JDITestsCucumber.steps")
public class JDITestsRunner {
}
