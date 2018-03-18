
@purchase
Feature: User can purchase items
As a customer
I want to be able to amend a dress size and add a message
So that I can buy some dresses

@smoke 
Scenario: User purchases 2 items
Given the user user is logged into the site
When the user changes the size of an item
And adds it to their basket
And adds another item to the basket
Then the sizes and cost calculations are correct
And the user can purchase the items

@smoke
Scenario: user can add a message to a purchased item
Given there is a product in the order hisory
When the user adds a message to a particular product ordered
Then the message will appear under messages


Scenario: Assertion fails causing screenshot
Given there is an assertion fail
When  the failure occurs
Then a screenshot is taken 