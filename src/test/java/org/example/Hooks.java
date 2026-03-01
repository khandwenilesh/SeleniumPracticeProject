package org.example;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {
        //WebDriverManager.chromedriver().setup();

        String headlessEnv = System.getenv("HEADLESS");
        boolean headless = headlessEnv == null || !headlessEnv.equalsIgnoreCase("false");

        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        // create a ChromeDriver and register it in TestContext
        //ChromeDriver driver = new ChromeDriver(options);
       WebDriver driver;
        String executionType = System.getProperty("remote", "local");
        if (executionType.equalsIgnoreCase("remote")) {

            System.out.println("Running in DOCKER / GRID mode");

             driver =new RemoteWebDriver(
                    URI.create("http://localhost:4444").toURL(),
                    options);

        } else {

            System.out.println("Running in LOCAL mode");

            driver=new ChromeDriver(options);
        }

        TestContext.setDriver(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        // Use the Scenario parameter to avoid unused-parameter warnings and log basic info
        if (scenario != null) {
            System.out.println("Cucumber scenario finished: '" + scenario.getName() + "'; failed=" + scenario.isFailed());
        }

        // Use TestContext API to quit and cleanup the ThreadLocal
        TestContext.quitDriver();
    }
}
