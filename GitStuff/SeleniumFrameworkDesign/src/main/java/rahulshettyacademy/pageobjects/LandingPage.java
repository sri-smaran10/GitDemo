package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;


public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	public LandingPage(WebDriver driver) //Constructor which executes first as method and then others will execute
	{
		//initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement userEmails=driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	public ProductCatalogue loginApplication(String email ,String password)
	{
		userEmail.sendKeys(email);
		userpassword.sendKeys(password);
		loginbtn.click();
		ProductCatalogue productspage = new ProductCatalogue(driver);
		return productspage;
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	
	
	
}
