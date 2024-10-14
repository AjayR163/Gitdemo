package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.*;

public class StepDefinition {

	WebDriver driver;

	@Given("the user is on the dropdown page")
	public void dropdownpage() {

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

	}

	@When("the user selects the currency")
	public void currency() {
		WebElement element = driver.findElement(By.xpath("//Select[@id='ctl00_mainContent_DropDownListCurrency']"));
		Select s = new Select(element);

		s.selectByIndex(2);

	}

	@When("the user clicks on the selcted")
	public void selected() {
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	}

	@Then("the user need to select")
	public void country() throws InterruptedException {
		driver.findElement(By.cssSelector("a[value='MAA']")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Madurai (IXM)']"))
				.click();
		Thread.sleep(3000);
	}

	@Then("the user should see the Welcome page")
	public void welcomePage() {

		driver.findElement(By.xpath("//label[text()=' Family and Friends']")).click();
	}

}
