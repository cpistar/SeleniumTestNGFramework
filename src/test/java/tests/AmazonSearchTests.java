package tests;

import org.testng.annotations.Test;

import pages.AmazonSearchPage;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonSearchTests {
	
	AmazonSearchPage amazonPage;
	WebDriverWait wait;

  @Test(dataProvider = "dataBucket")
  public void amazonSearch(String data) {
	  
	  amazonPage = new AmazonSearchPage();
	  wait = new WebDriverWait(Driver.getDriver(),10);
			Driver.getDriver()
	  .get(PropertiesReader.getProperty("amazonURL"));
	 
	  
	  String actualTitle = Driver.getDriver().getTitle();
	  Assert.assertEquals(actualTitle, "Amazon.com. Spend less. Smile more.");
	  
	  amazonPage.searchBox.sendKeys(data);
	  amazonPage.searchBtn.click();
	  
	  wait.until(ExpectedConditions.visibilityOf(amazonPage.searchResultText));
//	  String actualText = amazonPage.searchResult.getText().substring(1);
	  
	   String actualText = amazonPage.searchResultText.getText();
	   String trimmedText = actualText.substring(1, actualText.length()-1);
	   System.out.println("actual Text : " + actualText);
	   System.out.println("trimmed Text : " + trimmedText);
	   System.out.println("Searched text: " + data);

	  Assert.assertEquals(actualText, data);
  }
  
  @DataProvider
  public String[] dataBucket() {
	  
	  String[] testData = new String[5];
	  testData[0] = "coffee mug";
	  testData[1] = "pretty coffee mug";
	  testData[2] = "cool coffee mug";
	  testData[3] = "cute coffee mug";
	  testData[4] = "ugly coffe mug";
	  
	  return testData;
  }
  
  
  
  
  @BeforeMethod
  public void beforeMethod() {
  Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  Driver.quitDriver();
  }

}
