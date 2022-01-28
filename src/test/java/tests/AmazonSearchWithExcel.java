package tests;

import org.testng.annotations.Test;

import utilities.Driver;
import utilities.ExcelUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;

public class AmazonSearchWithExcel {
  @Test(dataProvider ="searchData")
  
  
  public void amazonSearchWithExcel(Object obj) {
  System.out.println(obj);
  }
  
  @DataProvider
  public Object[]searchData(){
	Object[] obj = ExcelUtils.getExcelDataInAColumn("//.src/test/resources/test_data/amazonTestData.xlsx", "Departments");
	  return obj;
	  
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
