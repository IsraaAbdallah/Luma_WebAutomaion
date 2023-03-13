package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/login.feature"},
        glue = {"stepDefintions"},
//        dryRun = true,
        tags = "@Sanity",
        plugin = {"html:cucumberReports/login_report.html","json:cucumberReports//login_report.json"},
        monochrome = true

)

public class Run_login extends AbstractTestNGCucumberTests {
}
