package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = {"src/test/resources/features/register.feature"},
        glue = {"stepDefintions"},
//        dryRun = true,
  tags = "@Smoke",
        plugin = {"html:cucumberReports/register_report.html","json:cucumberReports//register_report.json"},
        monochrome = true

)
    public  class Run_register extends AbstractTestNGCucumberTests {

}
