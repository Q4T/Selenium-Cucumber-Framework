$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("PurchaseItem.feature");
formatter.feature({
  "line": 3,
  "name": "User can purchase items",
  "description": "As a customer\r\nI want to be able to amend a dress size and add a message\r\nSo that I can buy some dresses",
  "id": "user-can-purchase-items",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@purchase"
    }
  ]
});
formatter.before({
  "duration": 8911896300,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "User purchases 2 items",
  "description": "",
  "id": "user-can-purchase-items;user-purchases-2-items",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "the user user is logged into the site",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "the user changes the size of an item",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "adds it to their basket",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "adds another item to the basket",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "the sizes and cost calculations are correct",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "the user can purchase the items",
  "keyword": "And "
});
formatter.match({
  "location": "PurchaseItem.the_user_user_is_logged_into_the_site()"
});
formatter.result({
  "duration": 3656478600,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.the_user_changes_the_size_of_an_item()"
});
formatter.result({
  "duration": 4262164000,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.adds_it_to_their_basket()"
});
formatter.result({
  "duration": 1570115700,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.adds_another_item_to_the_basket()"
});
formatter.result({
  "duration": 4137197600,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.the_sizes_and_cost_calculations_are_correct()"
});
formatter.result({
  "duration": 355039100,
  "status": "passed"
});
formatter.match({
  "location": "PurchaseItem.the_user_can_purchase_the_items()"
});
formatter.result({
  "duration": 6466251900,
  "status": "passed"
});
formatter.after({
  "duration": 931397000,
  "status": "passed"
});
formatter.before({
  "duration": 7598743500,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "user can add a message to a purchased item",
  "description": "",
  "id": "user-can-purchase-items;user-can-add-a-message-to-a-purchased-item",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 17,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 19,
  "name": "there is a product in the order hisory",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "the user adds a message to a particular product ordered",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "the message will appear under messages",
  "keyword": "Then "
});
formatter.match({
  "location": "AddMessage.there_is_a_product_in_the_order_history()"
});
formatter.result({
  "duration": 16803876600,
  "status": "passed"
});
formatter.match({
  "location": "AddMessage.the_user_adds_a_message_to_a_particular_product_ordered()"
});
formatter.result({
  "duration": 2738063300,
  "status": "passed"
});
formatter.match({
  "location": "AddMessage.the_message_will_appear_under_messages()"
});
formatter.result({
  "duration": 505763500,
  "status": "passed"
});
formatter.after({
  "duration": 2921850200,
  "status": "passed"
});
});