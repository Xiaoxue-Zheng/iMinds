Feature: View participants

Scenario: View participant summary
    Given The researcher has previously setup one or more participants
    When The researcher logs in to the web interface
    Then They will see a "summary view" of existing participants
    And The view shall be ordered by participant id.
    And For each participant the view shall include participant id
    And For each participant the view shall include unique code
    And For each participant the view shall include a button named "view details" to view data

Scenario: View participant details
    Given The researcher is viewing the participant summary page
    When They select to view details for a participant
    Then They will see a "detailed view" for the selected participant
    And The view shall include participant id, unique code and details of data received from the app