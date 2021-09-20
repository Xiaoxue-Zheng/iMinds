import { And, Then } from 'cypress-cucumber-preprocessor/steps'

And('the participant has opened the application', () => {
  cy.server()
  cy.visit('/')
})

Then('Tab1 showed', () => {
  cy.contains('Tab 1 page').should('be.visible')
})
