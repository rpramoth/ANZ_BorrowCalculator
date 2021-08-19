package stepDefn;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExtentTestManager;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BorrowCalcDefn {
	static WebDriver driver;
	
	
	@Given("^user is on borrowing Page$")
	public void user_is_on_borrowing_Page() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	
	}

	@When("^the user enters the details$")
	public void the_user_enters_the_details(DataTable arg1) throws Throwable {
		try {
			List<List<String>> data = arg1.raw();
			driver.findElement(By.xpath("//label[contains(text(),'"+data.get(0).get(0)+"')]"));
			WebElement dropDown = driver.findElement(By.xpath("//select[@title='Number of dependants']"));
			Select select = new Select(dropDown);
			select.selectByVisibleText(data.get(0).get(1));
			driver.findElement(By.xpath("//label[contains(text(),'"+data.get(0).get(2)+"')]"));
			driver.findElement(By.xpath("//input[@aria-labelledby='q2q1']")).sendKeys(data.get(0).get(3));
			driver.findElement(By.xpath("//input[@aria-labelledby='q2q2']")).sendKeys(data.get(0).get(4));
			driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys(data.get(0).get(5));
			driver.findElement(By.xpath("//input[@aria-labelledby='q3q2']")).sendKeys(data.get(0).get(6));
			driver.findElement(By.xpath("//input[@aria-labelledby='q3q3']")).sendKeys(data.get(0).get(7));
			driver.findElement(By.xpath("//input[@aria-labelledby='q3q4']")).sendKeys(data.get(0).get(8));
			driver.findElement(By.xpath("//input[@aria-labelledby='q3q5']")).sendKeys(data.get(0).get(9));
			driver.findElement(By.xpath("//button[@class='btn btn--action btn--borrow__calculate']")).click();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^borrowing estimates are calculated$")
	public void borrowing_estimates_are_calculated() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-live='assertive']")));
		String actualValue=driver.findElement(By.xpath("//span[@id='borrowResultTextAmount']")).getText();	
		Assert.assertEquals("$479,000", actualValue);
	}




	@When("^the user hits the startover button$")
	public void the_user_hits_the_startover_button() throws Throwable {

		driver.findElement(By.xpath("//button[@class='start-over']")).click();
	}

	@Then("^values should be cleared from text boxes$")
	public void values_should_be_cleared_from_text_boxes() throws Throwable {

		boolean isWorkoutButtonDisplayed = driver.findElement(By.id("btnBorrowCalculater")).isDisplayed();
		Assert.assertEquals(true, isWorkoutButtonDisplayed);

		boolean isApplicationTypeSingle=driver.findElement(By.id("application_type_single")).isSelected();
		Assert.assertEquals(true, isApplicationTypeSingle);
		
		boolean isBorrowTypeHome=driver.findElement(By.id("borrow_type_home")).isSelected();
		Assert.assertEquals(true, isBorrowTypeHome);


		List<WebElement> textFields=driver.findElements(By.xpath("//input[@type='text' and @aria-labelledby and not(@disabled)]"));
		for(WebElement e: textFields) {
			Assert.assertEquals("0", e.getAttribute("value"));
		}

	}


	@When("^living expenses value is one$")
	public void living_expenses_value_is_one() throws Throwable {

		driver.findElement(By.xpath("//input[@aria-labelledby='q3q1']")).sendKeys("1");
		driver.findElement(By.xpath("//button[@class='btn btn--action btn--borrow__calculate']")).click();

	
	}

	@Then("^validation message should be captured$")
	public void validation_message_should_be_captured() throws Throwable {
		String actualMsg=driver.findElement(By.xpath("//span[@class='borrow__error__text']")).getText();
		String expectedMessage = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
		Assert.assertEquals(expectedMessage,actualMsg);
		
		
	}
}