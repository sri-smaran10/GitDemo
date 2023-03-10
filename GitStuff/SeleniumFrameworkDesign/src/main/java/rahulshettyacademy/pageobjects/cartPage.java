package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;


public class cartPage extends AbstractComponent {
	WebDriver driver;
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutBtn;
	
	
	
	public cartPage(WebDriver driver) //Constructor which executes first as method and then others will execute
	{
		//initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public Boolean verifyProductDisplay(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.
				getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goTocheckout()
	{
		checkOutBtn.click();
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		return checkoutPage;
	}
	


	
	

	
	
	
	
	
}
