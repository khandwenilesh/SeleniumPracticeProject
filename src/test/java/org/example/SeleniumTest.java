package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    // Not a JUnit test anymore — helper method for manual runs if needed.
    public static void openExampleDotComStandalone() {
        // This will download a compatible ChromeDriver binary if needed
        //WebDriverManager.chromedriver().setup();

        // Allow running headless by default (set HEADLESS=false to see the browser)
        String headlessEnv = System.getenv("HEADLESS");
        boolean headless = headlessEnv == null || !headlessEnv.equalsIgnoreCase("false");

        ChromeOptions options = new ChromeOptions();
        if (headless) {
            // Use the new headless mode for modern Chrome versions
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://testautomationpractice.blogspot.com/");
            String title = driver.getTitle();
            System.out.println("Standalone run: Page title -> " + title);
        } finally {
            // ensure the browser is closed even if anything goes wrong
            driver.quit();
        }
    }
}
