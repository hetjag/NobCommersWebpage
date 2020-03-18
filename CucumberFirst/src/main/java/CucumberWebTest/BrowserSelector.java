package CucumberWebTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils
{

    LoadProp loadProp = new LoadProp();
    String browser = loadProp.getProperty("browser");
    public void setUpBrowser()

    {
        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\BrowserDriver\\chromedriver.exe");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("password_manager_enabled", false);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--incognito");
            options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
//            options.addArguments("--headless");
            options.addArguments("--start-maximized");

//            DesiredCapabilities caps = DesiredCapabilities.chrome();
//            caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
//            caps.setCapability("chrome.switches", Arrays.asList("--incognito"));
//            caps.setCapability(ChromeOptions.CAPABILITY, options);
            driver= new ChromeDriver(options);



        }else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\BrowserDriver\\geckodriver.exe");
            driver= new FirefoxDriver();

        }else if(browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\BrowserDriver\\IEDriverServer.exe");
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

            ieCapabilities.setCapability("nativeEvents", false);
            ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
            ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
            ieCapabilities.setCapability("disable-popup-blocking", true);
            ieCapabilities.setCapability("enablePersistentHover", true);
            ieCapabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
            ieCapabilities.setCapability("requireWindowFocus", false);

            driver = new InternetExplorerDriver(ieCapabilities);

        }else
                {
                    System.out.println("browser name is wrong or empty :" + browser);
                }


        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    public void closeBrowser() {
        driver.quit();
    }
}
