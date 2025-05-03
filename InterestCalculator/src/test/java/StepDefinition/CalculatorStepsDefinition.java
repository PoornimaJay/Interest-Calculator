package StepDefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.CalculatorPage;


public class CalculatorStepsDefinition {

	static WebDriver driver;

	CalculatorPage calculatorpage;
	

	@Given("the user is in login page")
	public void the_user_is_in_login_page() {
		driver = new ChromeDriver();
		driver.get("https://ten10techtest-dnd6bgfzcqdggver.uksouth-01.azurewebsites.net/Account/Login");
		driver.manage().window().maximize();
	}

	@And("the User enters {string} and {string}")
	public void the_user_enters_and(String Email, String Password) {
		calculatorpage = new CalculatorPage(driver);
		calculatorpage.enterEmail(Email);
		calculatorpage.enterPassword(Password);
	}

	@And("clicks on Login button")
	public void clicks_on_login_button() {
		calculatorpage.login();
	}

	@When("User selects Principal {int}")
	public void user_selects_Principal(int principal) {		
		calculatorpage.enterPrincipalAmount(principal);
	}

	@And("selects Interest rate {int}")
	public void selects_Interest_rate(int interest) {
		calculatorpage.selectInterestRate(interest);
	}

	@And("selects Duration {string}")
	public void selects_Duration(String duration) {
		calculatorpage.selectDuration(duration);
	}

	@And("selects the Consent button")
	public void selects_the_consent_button() {
		calculatorpage.clickOnConsent();
	}

	@And("Clicks on Calculate button")
	public void clicks_on_calculate_button() {
		calculatorpage.clickOnCalculate();
	}

	@Then("the User compares the displayed Interest Amount with actual interest amount {string}")
	public void the_User_compares_the_displayed_Interest_Amount_with_actual_interest_amount(
			String expectedInterestAmount) {
		Assert.assertEquals(calculatorpage.getinterestamount(), Double.parseDouble(expectedInterestAmount));

	}

	@And("the User compares the displayed Total Amount with actual total amount {string}")
	public void the_User_compares_the_displayed_Total_Amount_with_actual_total_amount(String expectedTotalAmount) {
		Assert.assertEquals(calculatorpage.gettotalamount(), Double.parseDouble(expectedTotalAmount));
	}
	
	@And("Close the browser")
	public void close_the_browser() {
		driver.quit();
	}

}
