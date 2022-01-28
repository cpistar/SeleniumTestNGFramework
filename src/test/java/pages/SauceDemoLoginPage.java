package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SauceDemoLoginPage {
	
	public SauceDemoLoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy (id = "user-name")
	public WebElement loginUserName;
	
	@FindBy (id = "password")
	public WebElement loginPassword; //only works with id locator

	@FindBy (id = "login-button")
	public WebElement logInBtn;
	
	@FindBy (css = ".inventory_item")
	public List<WebElement> items;
	
	@FindBy (css = ".inventory_item_price")
	public List<WebElement> itemPrices;

}
