package MusicLab;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Schedule",
        plugin = {"pretty"},
        features = "classpath:features/Cucumber"
)
public class CucumberTestSuite {}
