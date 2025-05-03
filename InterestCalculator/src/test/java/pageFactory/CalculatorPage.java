package pageFactory;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {
	
	WebDriver driver;
	
	
	public CalculatorPage(WebDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="UserName")
	WebElement email_value;
	
	@FindBy(id="Password")
	WebElement password_value;
	
	@FindBy(id="login-submit")
	WebElement login_button;
	
	@FindBy(xpath="//input[@id='customRange1']")
	WebElement principal_slider;
	
	@FindBy(id="dropdownMenuButton")
	WebElement interest_dropdown;
	
	@FindBy(xpath="//a[contains(text(),'Daily')]")
	WebElement duration_daily;
	
	@FindBy(xpath="//a[contains(text(),'Monthly')]")
	WebElement duration_monthly;
	
	@FindBy(xpath="//a[contains(text(),'Yearly')]")
	WebElement duration_yearly;
	
	@FindBy(xpath="//input[@id='gridCheck1']")
	WebElement consent_checkbox;
	
	@FindBy(css=".btn.btn-primary ")
	WebElement calculate_button;
	
	@FindBy(xpath="//h3[@id='interestAmount']")
	WebElement interest_displayed;
	
	@FindBy(xpath="//h2[@id='totalAmount']")
	WebElement totalamount_displayed;
	
	
	public void enterEmail(String email)
	
	{
		email_value.sendKeys(email);
	}
	
	public void enterPassword(String password)
	
	{
		password_value.sendKeys(password);
	}
	
	public void login()
	
	{
		login_button.click();
	}
	
	public void enterPrincipalAmount(int principal)
	
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='customRange1']")));

		WebElement principal_slider1 = driver.findElement(By.xpath("//*[@id='customRange1']"));		
		Actions action = new Actions(driver);
		int sliderPosition = principal/30 -250; //principal changes by 300 for 10 slider moves - default slider position is 0 /default principal is 7500
		action.dragAndDropBy(principal_slider1, sliderPosition, 0).perform();
	}
	
	public void selectInterestRate(int interest)
	
	{
		interest_dropdown.click();
		String idRateElement = "rate-"+interest+"%";	//for example - rate-8%
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idRateElement)));
		WebElement interestRateselector = driver.findElement(By.id(idRateElement));
		interestRateselector.click();
		
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
	}
	
	public void selectDuration(String duration)
	
	{
		if (duration == "Daily")
		{
			duration_daily.click();
		}
		
		//**** Bug identified****//
		//if Monthly duration is selected, the displayed calculated Interest value and total amount in the application is wrong.
		if (duration == "Monthly")
		{
			duration_monthly.click();
		}
		
		if (duration == "Yearly")
		{
			duration_yearly.click();
		}
	}
	
	public void clickOnConsent()
	
	{
		Actions action = new Actions(driver);
		action.moveToElement(consent_checkbox).click().build().perform();
	}
	
	public void clickOnCalculate()
	
	{
		Actions action = new Actions(driver);
		action.moveToElement(calculate_button).click().build().perform();
	}
	
	public double getinterestamount()
	{
		String displayedinterest = interest_displayed.getText().replace("Interest Amount:", "");
		double interestAmount = Double.parseDouble(displayedinterest);
		return interestAmount;		
	}
	
	public double gettotalamount()
	{
		String displayedtotal = totalamount_displayed.getText().replace("Total Amount with Interest:", "");
		double totalAmount = Double.parseDouble(displayedtotal);
		return totalAmount;
	}
		
}
