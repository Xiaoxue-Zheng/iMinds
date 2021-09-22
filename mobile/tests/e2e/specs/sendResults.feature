Feature: Send Results

# Actual wording for the message to the user below should come from the study team
Scenario: Send data on questionnaire completion
    Given The user has answered some questions on the app
    When The questions are complete
    Then A message will be displayed to the user to thank them for completing the questions
    And The app shall send the data to the server, along with the unique code
    And The server will store received data for the correct participant identified by the unique code