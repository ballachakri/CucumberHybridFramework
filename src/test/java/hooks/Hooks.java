package hooks;

import java.io.*;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

    WebDriver driver;

    @Before
    public void setup() throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/config/config.properties"));
        driver = DriverFactory.initializeBrowser(properties.getProperty("browser"));
        driver.get(properties.getProperty("url"));

    }

    @After
    public void tearDown(Scenario scenario) {


        String scenarioName = scenario.getName().replaceAll(" ", "_");

//        if (scenario.isFailed()) {
//            byte[] srcScreenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(srcScreenshot, "image/png", scenarioName);
//        }

        driver.quit();


    }

}
