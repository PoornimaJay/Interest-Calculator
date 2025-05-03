# Interest-Calculator
Automating an Interest calculator application that calculates Interest Amount and Total Amount with interest

****To clone this project please use https://github.com/PoornimaJay/Interest-Calculator.git ****

**** Positive scenario is tagged as @smoke and didnot have enough time to test other scenarios (Negative)  ****



**** BUG IDENTIFIED ****
While selecting the duration as Monthly, the displayed Interest Amount and Total Amount with interest in the application is not correct.
----- Root cause -----
Most likely, the formula used to calculate Interest Amount is 1/10 instead 1/12



**** Steps to Run the Automation Suite ****

After importing the project, Open the "CucumberTestRunner" Test runner class
Right click -> Click Run As -> "TestNG Test"
After the testrun , The number of tests executed, Passed, Failed is displayed in the Console panel



**** Steps to View the TestNG report ****

To view the Report in html, Right Click on the "htmlreport.html" (in the path /InterestCalculator/target)

Open with -> Webbrowser This displays the Output report in html format
