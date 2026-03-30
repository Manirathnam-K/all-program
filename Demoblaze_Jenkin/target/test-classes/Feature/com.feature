Feature: Check website functionality 

  Scenario: Verify the login functionality of the website
    Given User as to launch the chrome browser
    When User opens the URL 
    Then wait till the product was dispaly
    Then add to cart
    Then Accept the popup
    When product added in the cart click on the cart icon