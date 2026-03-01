package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions extends BaseSteps {

    @Given("I open the test automation practice site")
    public void i_open_the_test_automation_practice_site() {
        driver().get("https://testautomationpractice.blogspot.com/");
    }

    @Then("the page title should contain {string}")
    public void the_page_title_should_contain(String expected) {
        String title = driver().getTitle();
        assertTrue(title.contains(expected), "Title did not contain expected text. Actual: " + title);
        System.out.println("Verified title contains: '" + expected + "' -> Actual title: " + title);
    }

    @Then("I enter the personal details")
    public void iEnterThePersonalDetails() {

        driver().findElement(By.xpath("//input[@placeholder='Enter Name']")).sendKeys("Nilesh ");
        driver().findElement(By.xpath("//input[@id='email']")).sendKeys("khandwenilesh@gmail.com");
        driver().findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("0423424");
        driver().findElement(By.xpath("//label [contains(text(),'Address')]//following::textarea")).sendKeys("Address added");
       //Add implicit wait
        driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        // Write code here that turns the phrase above into concrete actions

    }
}
