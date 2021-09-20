Story: Create unique code in app 
    Scenario: Unique code generated on first app opening
        Given: The user has not previously opened the app
        When: They open the app
        Then: A unique code will be generated that is stored in the app
        And: The user will be shown the code on the screen
        And: The code will remain on screen until the user dismisses it

    Scenario: No unique code generated on subsequent app opening
        Given: The user has already opened the app and generated a code
        When: They open the app
        Then: No unique code will be generated
        And: The user can interact with the normal app features

    Scenario: Reminder of unique code
        Given: The user has already opened the app and generated a code
        And: The user wants a reminder of the unique code
        When: They select the "unique code" menu item
        Then: They will be shown a reminder of the unique code
        And: The code will remain on screen until the user dismisses it