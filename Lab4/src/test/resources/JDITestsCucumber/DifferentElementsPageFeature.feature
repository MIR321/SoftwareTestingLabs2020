Feature: Different Elements Page

  @Smoke
  Scenario: Testing ComboBox
    Given User opened browser
    And User is signed in
    And User is on Different Elements Page
    When User selects elements in ComboBox on Different Elements Page
    Then Different Elements Page Logs should contain the correct information about last action
    And Closing browser

  Scenario: Testing RadioButtons and CheckBoxes
    Given User opened browser
    And User is signed in
    And User is on Different Elements Page
    When User clicks on RadioButtons and CheckBoxes on Different Elements Page
    Then Different Elements Page Logs should contain the correct information about last action
    And Closing browser


