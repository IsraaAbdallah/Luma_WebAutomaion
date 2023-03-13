package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = {"src/test/resources/features/Search.feature"},
            glue = {"stepDefintions"},
//            dryRun = true,
            tags = "@Regression",
            plugin = {"html:cucumberReports/search_report.html","json:cucumberReports//search_report.json"},
            monochrome = true

    )
    public class Run_search  extends AbstractTestNGCucumberTests {

    }

