Feature: ANZ Bo

Scenario: Calculate Estimates
Given user is on borrowing Page
When the user enters the details
| Single | 0 | Home to live in | 80000 | 10000 | 500 | 0 | 100 | 0 | 10000 |
Then borrowing estimates are calculated

Scenario: Test Start Over button
When the user hits the startover button
Then values should be cleared from text boxes

Scenario: Living Expenses is minimum
When living expenses value is one
Then validation message should be captured