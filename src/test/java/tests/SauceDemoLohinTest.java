package tests;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SauceDemoLoginPage;
import utilities.Driver;
import utilities.PropertiesReader;

public class SauceDemoLohinTest {
  
	SauceDemoLoginPage page;
	
	
	
@Test
  public void loginPageTest() {
		page = new SauceDemoLoginPage();
	  Driver.getDriver()
	  .get(PropertiesReader.getProperty("sauceURL"));
	  page.loginUserName
		.sendKeys(PropertiesReader.getProperty("sauce_username"));	  
			
	  page.loginPassword
	  .sendKeys(PropertiesReader.getProperty("sauce_password"));
	  
	  page.logInBtn.click();
	  System.out.println(page.items.size());
	  
  }

@Test
public void invertoryTest() {
	page = new SauceDemoLoginPage();
	Driver.getDriver().get(PropertiesReader.getProperty("sauceURL"));
	
	page.loginUserName.sendKeys(PropertiesReader.getProperty("sauce_username"));
	page.loginPassword.sendKeys(PropertiesReader.getProperty("sauce_password"));
	page.logInBtn.click();
	
	for (WebElement item_price : page.itemPrices) {
		System.out.println(item_price.getText().trim());
	}
	
}
  @BeforeTest
  public void beforeMethod() {
	  Driver.getDriver()
	  .manage().timeouts()
	  .implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @AfterMethod
  public void afterMethod() {
	  Driver.quitDriver();
  }
}
