package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
		WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder*='Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	@FindBy(css=".ta-results button:last-of-type")
	WebElement selectIndia;
	
	By results = By.cssSelector(".ta-results");
	public void selectCountry(String countryName)
	{
		Actions li = new Actions(driver); // to control dropdown
		li.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selectIndia.click();
	}
	
	public confirmationPage placeOrder() {
		placeOrder.click();
		confirmationPage confirmationPage =new confirmationPage(driver);
		return confirmationPage;
	}
	
	
	

}
