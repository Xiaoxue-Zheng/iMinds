// https://docs.cypress.io/api/introduction/api.html
import { Given, When, Then, And } from 'cypress-cucumber-preprocessor/steps';

Given("the participant has opened the application", () => {
  cy.server();
  cy.visit("/");
});

Then('the application loaded', () => {
  cy.contains("h1", "i-Minds");
});
