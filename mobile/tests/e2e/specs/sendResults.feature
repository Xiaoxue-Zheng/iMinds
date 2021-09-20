Feature: Send Results

Story: Send results from app to server
    Scenario: Send data on questionnaire completion
        Given: The user has answered some questions on the app
        When: The questions are complete
        Then: The app shall send the data to the server, along with the unique code
        And: The server will store received data for the correct participant
        And: The unique code will be used to identify the correct participant