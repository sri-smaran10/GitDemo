package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;


public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) //Constructor which executes first as method and then others will execute
	{
		//initialization
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	/*".ng-animating" (this is the css locator which dev 
	has written for product added to cart to become invisible*/
	@FindBy(css=".ng-animating")
	WebElement dissappearProductAddedMsg; //page factory is used because it is WebElement
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart =  By.cssSelector(".card-body button:last-of-type");
	By productAddedMsg = By.cssSelector("#toast-container");
	
	public  List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductName(String productName) 
	{
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText()
		.equals("ZARA COAT 3")).findFirst().orElse(null);
		
		return prod;
		
	}
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod=getProductName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(productAddedMsg); //waits until prdct is added to cart msg 
	    waitForElementToDissappear(dissappearProductAddedMsg);//waits until that msg disappears
		
	}
	
	
	
	
	
	
}
