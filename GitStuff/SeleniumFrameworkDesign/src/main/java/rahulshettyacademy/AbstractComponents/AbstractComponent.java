package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.cartPage;

public class AbstractComponent {
		WebDriver driver;
	public AbstractComponent(WebDriver driver) {
			
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartBtn;

	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public cartPage goToCartPage() 
	{
		 cartBtn.click();
		 cartPage cartPage = new cartPage(driver);
		 return cartPage;
		
	}
	
	
	public void waitForElementToDissappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	
}
