package org.example;

import org.openqa.selenium.WebDriver;

/**
 * Thread-safe holder for WebDriver used by tests. Uses ThreadLocal to support parallel execution.
 */
public final class TestContext {
    private TestContext() {}

    // ThreadLocal to keep one WebDriver instance per thread
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        DRIVER.set(driver);
    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    public static void quitDriver() {
        WebDriver d = DRIVER.get();
        if (d != null) {
            try {
                d.quit();
            } catch (Exception ignored) {
                // best-effort quit
            }
        }
        // remove the ThreadLocal value to avoid leaks
        DRIVER.remove();
    }
}
