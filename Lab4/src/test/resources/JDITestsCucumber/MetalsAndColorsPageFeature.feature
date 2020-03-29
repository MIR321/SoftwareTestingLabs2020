Feature:  Metals and Colors Page

  @Smoke
  Scenario: Testing calculation
    Given User opened browser
    And User is signed in
    And User is on Metals and Colors Page
    When User clicks on RadioButtons on Metals and Colors Page
    And User presses calculate button on Metals and Colors Page
    Then Metals and Colors Page Results should contain the correct result
    And Closing browser

  Scenario: Testing submition
    Given User opened browser
    And User is signed in
    And User is on Metals and Colors Page
    When User chooses elements on Metals and Colors Page
    And User presses submit button on Metals and Colors Page
    Then Metals and Colors Page Results should contain the correct submit
    And Closing browser