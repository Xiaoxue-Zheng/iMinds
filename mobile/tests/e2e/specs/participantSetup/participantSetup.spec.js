import { Given, When, Then, And, Before } from 'cypress-cucumber-preprocessor/steps';

let existUniqueCode

Before(() => {
  cy.intercept({
    url: 'api/unique-codes',
    }).as('generateUniqueCodeRequest')
    cy.clearStorage();
});

Given('The app has not previously been opened', () => {
  cy.clearStorage();
  cy.viewport('iphone-6')
  cy.visit('localhost:8100/')
  cy.wait('@generateUniqueCodeRequest').then((res) => {
    expect(res.response.body).to.have.length(7)
    existUniqueCode = res.response.body
  });
});

When('The app is opened',   () => {
  assert.isNotNull(existUniqueCode, 'unique code is not null')
});

Then('A unique code is displayed on the screen', () =>{
  cy.get('ion-text').should('contain', existUniqueCode)
});

And('The code stays on screen until dismissed', () =>{
  cy.get('ion-button').contains('Close').click()
  cy.get('div.ion-page').should('not.have.id', 'unique-code-display')
});

Given('The app has previously been opened', () => {
  cy.clearStorage();
  cy.viewport('iphone-6')
  cy.visit('localhost:8100/')
  cy.wait('@generateUniqueCodeRequest').then((res) => {
    expect(res.response.body).to.have.length(7)
    existUniqueCode = res.response.body
  });
  cy.viewport('iphone-6')
  cy.visit('localhost:8100/')
});

Then('No unique code will be generated', () =>{
  cy.shouldBeCalled('generateUniqueCodeRequest', 0)
});

Then('The app homescreen will be displayed', ()=>{
  cy.url().should('match', /8100\/$/)
});

When('The {string} menu item is selected', menuItemName => {
  cy.get('ion-menu-button').click()
  cy.get('div.ion-page').should('have.class', 'menu-content-open')
  cy.contains(menuItemName).click()
});

Then('The existing unique code is displayed on the screen', () =>{
  cy.get('ion-text').should('contain', existUniqueCode)
});