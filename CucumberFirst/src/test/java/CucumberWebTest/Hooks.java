package CucumberWebTest;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utils {

    BrowserSelector browserSelector = new BrowserSelector();

    @Before
    public void openBrowser() {
        browserSelector.setUpBrowser();
    }

    @After
    public void closeBrowser(Scenario scenario)
    {
        if (scenario.isFailed()){
            takeScreenShot(scenario.getName()+timeStamp());
        }
        driver.quit();
    }


}
