Feature: Interest Amount and Total Amount Calculator
  
  As a Product owner
  I want to build a interest calculator web application
  so that I can calculate Interest Amount and Total Amount with interest easily

  @smoke
  Scenario Outline: Calculate the Interest Amount and Total Amount
    Given the user is in login page
    And the User enters "<Email>" and "<Password>"
    And clicks on Login button
    When User selects Principal <Principal>
    And selects Interest rate <Interest>
    And selects Duration "<Duration>"
    And selects the Consent button
    And Clicks on Calculate button
    Then the User compares the displayed Interest Amount with actual interest amount "<ActualInterestAmount>"
    And the User compares the displayed Total Amount with actual total amount "<ActualTotalAmount>"
    And Close the browser

    Examples: Values
      | Email                   | Password      | Principal | Interest | Duration | ActualInterestAmount | ActualTotalAmount |
      | nima_tester@yahoo.co.uk | Godsgrace@143 |      7800 |        8 | Daily    |                 1.70 |           7801.70 |
      | nima_tester@yahoo.co.uk | Godsgrace@143 |      8100 |        5 | Monthly  |                33.75 |           8133.75 |
      | nima_tester@yahoo.co.uk | Godsgrace@143 |      7200 |        6 | Yearly   |               432.00 |           7632.00 |

  Scenario Outline: Negative scenario with Zero Principal
    Given the user is in login page
    And the User enters "<Email>" and "<Password>"
    And clicks on Login button
    When User selects Principal <Principal>
    And selects Interest rate <Interest>
    And selects Duration "<Duration>"
    And selects the Consent button
    And Clicks on Calculate button
    And Confirm the error displays the error message "<Error message>"

    Examples: Values
      | Email                   | Password      | Principal | Interest | Duration | ActualInterestAmount | ActualTotalAmount | Error message              |
      | nima_tester@yahoo.co.uk | Godsgrace@143 |         0 |        8 | Daily    |                 1.70 |           7801.70 | Please fill in all fields. |
      

  Scenario Outline: Negative scenario with Zero Interest rate
    Given the user is in login page
    And the User enters "<Email>" and "<Password>"
    And clicks on Login button
    When User selects Principal <Principal>
    And selects Duration "<Duration>"
    And selects the Consent button
    And Clicks on Calculate button
    And Confirm the error displays the error message "<Error message>"

    Examples: Values
      | Email                   | Password      | Principal | Duration | ActualInterestAmount | ActualTotalAmount | Error message              |
      | nima_tester@yahoo.co.uk | Godsgrace@143 |      7800 | Daily    |                 1.70 |           7801.70 | Please fill in all fields. |
      

  Scenario Outline: Negative scenario with no consent
    Given the user is in login page
    And the User enters "<Email>" and "<Password>"
    And clicks on Login button
    When User selects Principal <Principal>
    And selects Interest rate <Interest>
    And selects Duration "<Duration>"
    And Clicks on Calculate button
    And Confirm the error displays the error message "<Error message>"

    Examples: Values
      | Email                   | Password      | Principal | Interest | Duration | ActualInterestAmount | ActualTotalAmount | Error message              |
      | nima_tester@yahoo.co.uk | Godsgrace@143 |      7800 |        8 | Daily    |                 1.70 |           7801.70 | Please fill in all fields. |
