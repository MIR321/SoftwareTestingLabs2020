Feature: Table with Pages Page

  @Smoke
  Scenario: Testing display of the table
    Given User opened browser
    And User is signed in
    And User is on Table with Pages Page
    When User selects different numbers of entries on Table with Pages Page
    And User switches sort on Table with Pages Page
    Then Verifying the first entry
    And Closing browser

  Scenario: Testing searching
    Given User opened browser
    And User is signed in
    And User is on Table with Pages Page
    When User is searching entries
    Then Verifying the result of search
    And Closing browser


