Feature: naukri web application testing
Scenario: Login functionality testing
Given user is on the naukri home page
When user enters valid username and password
Then user should be logged in successfully

Scenario: Job search functionality testing
Given user is logged in to the naukri application
When user searches for a job with valid criteria
Then relevant job listings should be displayed
And user can apply for a job successfully

