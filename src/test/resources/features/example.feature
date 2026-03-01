Feature: Verify example site title

  Scenario: Page title contains expected text
    Given I open the test automation practice site
    Then the page title should contain "Automation Testing Practice"
    Then I enter the personal details