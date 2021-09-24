Feature: Sign In

    Scenario: Opening the sign in page
        Given the researcher is not signed in
        And the researcher has opened the application
        Then the sign in page is visible
        And the researcher is prompted to enter their email address
        And the researcher is prompted to enter their password
        And there is a button to sign in
        And there is no option to sign out

    Scenario: Signing in with the wrong email address
        Given the researcher is not signed in
        And the researcher has opened the application
        And the researcher has entered an unregistered email address
        And the researcher has entered a correct password
        When the researcher clicks the sign in button
        Then the researcher is not signed in
        And there is a suggestion to try again

    Scenario: Signing in with the wrong password
        Given the researcher is not signed in
        And the researcher has opened the application
        And the researcher has entered a registered email address
        And the researcher has entered an incorrect password
        When the researcher clicks the sign in button
        Then the researcher is not signed in
        And there is a suggestion to try again

    Scenario: Signing in with the correct details
        Given the researcher is not signed in
        And the researcher has opened the application
        And the researcher has entered a registered email address
        And the researcher has entered a correct password
        And the researcher clicks the sign in button
        Then the researcher is taken to the participant page
        And there is an option to sign out

    Scenario: Signing out of the application
        Given the researcher has signed in
        When the researcher clicks to sign out
        Then they are taken to the sign in page
        And there is no option to sign out
