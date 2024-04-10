Feature: User clicks on Support and sees Cancel a Trip button

  Scenario: User clicks on Support
    Given the user is on the homepage
    When the user clicks on the "Support" link
    Then the "Cancel your Trip" button should be displayed