Feature: Participant Setup

Scenario: Unique code generated on first app opening
    Given The app has not previously been opened
    When The app is opened
    Then A unique code is displayed on the screen
    And The code stays on screen until dismissed

Scenario: No unique code generated on subsequent app opening
    Given The app has previously been opened
    When The app is opened
    Then No unique code will be generated
    And The app homescreen will be displayed

Scenario: Reminder of unique code
    Given The app has previously been opened
    When The "My Code" menu item is selected
    Then The existing unique code is displayed on the screen
    And The code stays on screen until dismissed