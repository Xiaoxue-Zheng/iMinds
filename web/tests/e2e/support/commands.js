// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add("login", (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add("drag", { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add("dismiss", { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This is will overwrite an existing command --
// Cypress.Commands.overwrite("visit", (originalFn, url, options) => { ... })
import 'cypress-plugin-snapshots/commands';
Cypress.Commands.add('clearStorage', () => {
  window.sessionStorage.clear();
});

Cypress.Commands.add('clickOutside', function() {
  return cy.get('body').click(0, 0);
});

Cypress.Commands.add('fixCypressSpec', filename => {
  const path = require('path');
  const relative = filename.substr(1); // removes leading "/"
  const projectRoot = Cypress.config('projectRoot');
  const absolute = path.join(projectRoot, relative);
  Cypress.spec = {
    absolute,
    name: path.basename(filename),
    relative
  };
});
