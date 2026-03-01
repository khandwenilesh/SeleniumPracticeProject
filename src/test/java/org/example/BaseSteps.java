package org.example;

import org.openqa.selenium.WebDriver;

/**
 * Base class for Cucumber step definition classes.
 * Provides a concise protected accessor to the thread-local WebDriver.
 */
public abstract class BaseSteps {
    protected WebDriver driver() {
        WebDriver d = TestContext.getDriver();
        if (d == null) {
            throw new IllegalStateException("WebDriver has not been initialized. Make sure Hooks.setUp() ran and TestContext.setDriver(...) was called.");
        }
        return d;
    }
}
