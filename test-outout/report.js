$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/Pramod/Desktop/New folder/com.Collabera/src/main/java/Feature/BorrowCalc.feature");
formatter.feature({
  "line": 1,
  "name": "ANZ Bo",
  "description": "",
  "id": "anz-bo",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Calculate Estimates",
  "description": "",
  "id": "anz-bo;calculate-estimates",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "user is on borrowing Page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user enters the details",
  "rows": [
    {
      "cells": [
        "Single",
        "0",
        "Home to live in",
        "80000",
        "10000",
        "500",
        "0",
        "100",
        "0",
        "10000"
      ],
      "line": 6
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "borrowing estimates are calculated",
  "keyword": "Then "
});
formatter.match({
  "location": "BorrowCalcDefn.user_is_on_borrowing_Page()"
});
formatter.result({
  "duration": 10434650637,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalcDefn.the_user_enters_the_details(DataTable)"
});
formatter.result({
  "duration": 2103989029,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalcDefn.borrowing_estimates_are_calculated()"
});
formatter.result({
  "duration": 1051560464,
  "error_message": "org.junit.ComparisonFailure: expected:\u003c$[479],000\u003e but was:\u003c$[507],000\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat stepDefn.BorrowCalcDefn.borrowing_estimates_are_calculated(BorrowCalcDefn.java:65)\r\n\tat ✽.Then borrowing estimates are calculated(/Users/Pramod/Desktop/New folder/com.Collabera/src/main/java/Feature/BorrowCalc.feature:7)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 9,
  "name": "Test Start Over button",
  "description": "",
  "id": "anz-bo;test-start-over-button",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "the user hits the startover button",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "values should be cleared from text boxes",
  "keyword": "Then "
});
formatter.match({
  "location": "BorrowCalcDefn.the_user_hits_the_startover_button()"
});
formatter.result({
  "duration": 212705570,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalcDefn.values_should_be_cleared_from_text_boxes()"
});
formatter.result({
  "duration": 282479893,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Living Expenses is minimum",
  "description": "",
  "id": "anz-bo;living-expenses-is-minimum",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "living expenses value is one",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "validation message should be captured",
  "keyword": "Then "
});
formatter.match({
  "location": "BorrowCalcDefn.living_expenses_value_is_one()"
});
formatter.result({
  "duration": 342540900,
  "status": "passed"
});
formatter.match({
  "location": "BorrowCalcDefn.validation_message_should_be_captured()"
});
formatter.result({
  "duration": 53388607,
  "status": "passed"
});
});