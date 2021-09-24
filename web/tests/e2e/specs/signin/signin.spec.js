import { Given, When, Then, And } from 'cypress-cucumber-preprocessor/steps';

// Scenario: Opening the sign in page
Given('the researcher is not signed in', () => {
  cy.clearStorage();
});

And('the researcher has opened the application', () => {
  cy.server();
  cy.visit('/');
});

Then('the sign in page is visible', () => {
  cy.location('pathname').should('eq', '/signin');
  cy.contains('Log in');
});

And('the researcher is prompted to enter their email address', () => {
  cy.contains('Email address')
    .next()
    .should('have.attr', 'name', 'email');
});

And('the researcher is prompted to enter their password', () => {
  cy.contains('Password')
    .next()
    .should('have.attr', 'name', 'password');
});

And('there is a button to sign in', () => {
  cy.get('button').contains('Log in');
});

And('there is no option to sign out', () => {
  cy.contains('Sign out').should('not.be.visible');
});

// Scenario: Signing in with the wrong email address
And('the researcher has entered an unregistered email address', () => {
  cy.get('#email').type('unregistered@example.com');
});

And('the researcher has entered a correct password', () => {
  cy.get('#password').type('admin');
});

When('the researcher clicks the sign in button', () => {
  cy.get('button').click();
});

Then('the researcher is not signed in', () => {
  cy.location('pathname').should('eq', '/signin');
});

And('there is a suggestion to try again', () => {
  cy.contains(/try again/).should('be.visible');
});

// Scenario: Signing in with the wrong password
And('the researcher has entered a registered email address', () => {
  cy.get('#email').type('admin@localhost');
});

And('the researcher has entered an incorrect password', () => {
  cy.get('#password').type('incorrect123');
});

// Scenario: Signing in with the correct details
Then('the researcher is taken to the participant page', () => {
  cy.location('pathname').should('eq', '/participant');
});

And('there is an option to sign out', () => {
  cy.contains('Sign out').should('be.visible');
});

// Scenario: Signing out of the application
When('the researcher clicks to sign out', () => {
  cy.contains('Sign out').click();
});

Then('they are taken to the sign in page', () => {
  cy.location('pathname').should('eq', '/signin');
  cy.contains('Log in');
});

And('the researcher tries to navigate away', () => {
  cy.server();
  cy.visit('/');
});

Given('the researcher has signed in', () => {
  cy.server();
  cy.clearStorage();
  cy.visit('./signin');
  cy.get('#email').type('admin@localhost');
  cy.get('#password').type('admin');
  cy.get('button').click();
});
