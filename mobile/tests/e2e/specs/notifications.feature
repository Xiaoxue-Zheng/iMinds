Feature: Notifications

Scenario: Daily notification launched
    Given The app has been configured
    And The app has not been used this calendar day
    When It is 5pm
    Then A notification shall be displayed
    And The notification shall include the text "Would you like to work with i-Minds now?"

# There are two possible options for when to fire a reminder: The notification has not been clicked OR the app has not been used
# I have gone for the latter because I don't think we want to remind someone to use the app if they have done so recently
Scenario: Daily reminder notification launched
    Given The daily notification has fired
    And The app has not been used this calendar day
    When It is 8pm
    Then A reminder daily notification shall be displayed
    And The notification shall include the text "Reminder: Would you like to work with i-Minds now?"

# I'm not sure if this scenario is necessary or it will be covered by "The app has not been used this calendar day" in the above scenarios
Scenario: Cancel daily notification when app is used
    Given It is before 5pm
    When The app is used
    Then The daily notification shall be cancelled

Scenario: Clicking a daily or daily reminder notification opens the app
    Given A daily notification is active
    When The notification is clicked
    Then The homescreen of the app shall be displayed

Scenario: No interaction this week, weekly notification launched
    Given The current day is a multiple of 7
    And The app has not been used this week
    When It is midday
    Then A notification will be displayed
    And The notification shall include the text "It looks like you've not used i-Minds this week, please tell us why"

Scenario: No interaction this week, weekly notification clicked
    Given A weekly notification is active
    And The app has not been used in the past 7 days
    When The notification is clicked
    Then A question shall be displayed
    And The question shall state "It looks like you've not used i-Minds this week. Why is that?"
    And The options shall be a dropdown list
    And The options shall include "I haven't had time"
    And The options shall include "I don't find i-Minds helpful"
    And The options shall include "I'm feeling okay so I don't need i-Minds at the moment"
    And The options shall include "Other"

Scenario: "Other" option clicked from weekly notification
    Given The weekly notification question is displayed
    When Other is clicked
    Then A textbox shall be displayed
    And The user can type into the box
    And Click a Submit button

Scenario: Interaction this week, weekly notification launched
    Given The current day is a multiple of 7
    And The app has been used this week
    When It is midday
    Then A notification shall be displayed
    And The notification shall include a random suggested activity
    And The activity shall be one of the following
    And One option is "Great to see you have been using i-Minds. How about watching a video?"
    And One option is "Great to see you have been using i-Minds. How about listening to a relaxation exercise?"
    And One option is "Great to see you have been using i-Minds. How about looking at intervention 1?"
    And One option is "Great to see you have been using i-Minds. How about looking at intervention 2?"
    And One option is "Great to see you have been using i-Minds. How about looking at intervention 3?"

# The Then clause below will need updating to open the relevant part of the app but that will have to wait until the rest of the app is implemented
Scenario: Interaction this week, weekly notification clicked
    Given A weekly notification is active
    And The app has been used in the past 7 days
    When The notification is clicked
    Then The homescreen of the app shall be displayed

# Unlike daily notifications, I think we want the user to actually click the weekly notification rather than just use the app
Scenario: Weekly reminder notification fires at 3pm
    Given The weekly notification has fired
    And The notification has not been clicked
    When It is 3pm
    Then A reminder weekly notification will be displayed
    And The notification shall include the text "Reminder"



