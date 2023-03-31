package MusicLab;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@GetAllListMentorsNegativeCase",
        plugin = {"pretty"},
        features = "classpath:features/Cucumber"
)
public class CucumberTestSuite {}
