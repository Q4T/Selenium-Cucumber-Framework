
@Login
Feature: User can Login
  As a user
  I want to login to the site
  so that i can purchase items


  Scenario: Login
    Given user has valid credentials
    When user logs in
    Then user is taken to the landing page
