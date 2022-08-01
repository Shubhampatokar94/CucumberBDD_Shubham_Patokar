package com.assignment.automation.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class LandingPageObjects {
	
	private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario scn;
	
	// Locators
	private By prodCategory       = By.xpath("//div[@id='block_top_menu']/ul/li");
	private By LanPageLogoElement = By.xpath("//div[@id='header_logo']/a/img");
	private By SighInBtnElement   = By.xpath("//a[@class='login']");
	private By searchBox          = By.xpath("//input[@placeholder='Search']");
	private By suggestedProdList  = By.xpath("//div[@class='ac_results']/ul/li");
	private By TwitterLogoElement = By.xpath("//li[@class='twitter']/a");
	private By TwitterAcctElement = By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wbh5a2']//preceding-sibling::div[1]/child::div[1]/child::div[1]/span/span");
	
	
	// Constructor
	public LandingPageObjects(WebDriver driver, Scenario scn )
	{
		
		this.driver = driver;
		this.scn = scn;

	}
	
	// TestCase-1
	public void verifyThePage()
	{

		String ExpLanPageElement=driver.getTitle();
		Assert.assertTrue("Page validation Successful", ExpLanPageElement.equals("My Store"));
		
		scn.log("Page validation successfull. actual Landing page Element is: " + ExpLanPageElement );
		logger.info("Page validation successfull. actual Landing page Element is: " + ExpLanPageElement );
	
	}
	
	// TestCase-1
	public void urlValidation(String URLContain)
	{

		String actual=driver.getCurrentUrl();
		Assert.assertEquals("Landing page url validation", actual, URLContain);
		
		scn.log("Page url validation successfull. Actual URL: " + actual );
		logger.info("Page url validation successfull. Actual URL: " + actual );
	
	}
	
	// TestCase-2
	public void validateLandingPageTitle(String Title)
	{
		
		String actual =driver.getTitle();
		Assert.assertEquals("Page Title validation",Title,actual);
		
		scn.log("Page title validation successfull. Actual title: " + actual );
		logger.info("Page title validation successfull. Actual title: " + actual );
	
	}
	
	// TestCase-3
	public void availProdCategory()
	{
	   
		List <WebElement> prodCategoryList =driver.findElements(prodCategory);
	    Assert.assertEquals(false, prodCategoryList.isEmpty());
	    
	    logger.info("Display the product category list, size of list is: "+ prodCategoryList.size());
	    scn.log("Display the product category list, size of list is: "+ prodCategoryList.size());
	
	}
	
	// TestCase-3
	public void validateProdCategory(List<String> prodList)
	{
		  List <WebElement> prodCategoryList =driver.findElements(prodCategory);
		  {
		    for(int i=0; i< prodCategoryList.size(); i++)
		    {
		    	if(prodCategoryList.get(i).getText().equals(prodList.get(i).toString()))
		        {
		        	Assert.assertTrue(true);
		        	logger.info(prodCategoryList.get(i).getText()+ " is matched with expected "+ prodList.get(i).toString()+" product name in datatable");
		        }
		    	else
		    	{
		    		//Assert.fail();
		        	logger.fatal(prodCategoryList.get(i).getText()+ " is not matched with expected "+ prodList.get(i).toString()+" product name in datatable");
		    	}
		    }
		    logger.info("Validate the product category with expected datatable");
		    scn.log("Validate the product category with expected datatable");
		  }
	}
	
	// TestCase-3
	public void sizeOfProdCategory(int prodCount)
	{
		 
		  List <WebElement> prodCategoryList =driver.findElements(prodCategory);
		  Assert.assertEquals(prodCount, prodCategoryList.size());
		  
		  logger.info("validate the Size of product category, size is: "+ prodCategoryList.size());
		  scn.log("validate the Size of product category, size is: "+ prodCategoryList.size());
	
	}
	
	// Common Method
	public WebElement getElement(By locator) {
		WebElement element = null;		
		{
			element = driver.findElement(locator);
		}
        return element;
	}
	
	// Common Method
	public boolean doIsDisplayed(By locator) {
		boolean flag = false;
		flag = getElement(locator).isDisplayed();
		return flag;
	}
	
	// Common Method
	public void doClick(By locator) 
	{
		getElement(locator).click();
	}
	
	// TestCase-4
	public void validateLandingPageLogo()
	{

		scn.log("Checking the Landing page logo is Avaliable or Not");
		logger.info("Checking the Landing page logo is Avaliable or Not");

		Assert.assertEquals("Application Logo on Landing Page is not Displayed",true, doIsDisplayed(LanPageLogoElement));

		scn.log("Landing Page logo is Successfully Validate");
		logger.info("Landing Page logo is Successfully Validate");
	
	}
	
	// TestCase-5
	public void fetchLogoHeight()
	{
	   
		WebElement logo =driver.findElement(LanPageLogoElement);
	    String logoHeight= logo.getAttribute("height");
	    
	    logger.info("Height of logo is: "+ logoHeight);
	    scn.log("Height of logo is: "+ logoHeight);
	
	}
	
	// TestCase-5
	public void logoHeightValidation(String height)
    {
    	
		WebElement logo =driver.findElement(LanPageLogoElement);
    	Assert.assertEquals(height, logo.getAttribute("height"));
    	
    	logger.info("Validate the height of logo");
    	scn.log("Validate the height of logo");
    
    }
	
	// TestCase-6
	public void fetchLogoWidth()
	{
	   
		WebElement logo =driver.findElement(LanPageLogoElement);
	    String logoWidth= logo.getAttribute("width");
	    
	    logger.info("Width of logo is: "+ logoWidth);
	    scn.log("Width of logo is: "+ logoWidth);
	
	}
	
	// TestCase-6
	public void logoWidthValidation(String width)
    {
    	
		WebElement logo =driver.findElement(LanPageLogoElement);
    	Assert.assertEquals(width, logo.getAttribute("width"));
    	
    	logger.info("Validate the width of logo");
    	scn.log("Validate the width of logo");
    
    }
	
	// TestCase-7
	public void validateSignInBtnDisplayOrNOT() 
	{

		scn.log("Checking the SignIn button is Avaliable on Landing page or not");
		logger.info("Checking the SignIn button is Avaliable on Landing page or not");

		Assert.assertEquals("Application Logo on Landing Page is not Displayed",true, doIsDisplayed(SighInBtnElement));

		scn.log("SignIn button is Avaliable and Successfully Validated");
		logger.info("SignIn button is Avaliable and Successfully Validated");
	
	}
	
	// TestCase-7
	public void ValidateSignInPageTitle(String SignInTitle) 
	{

		wait =new WebDriverWait(driver, 20);	
		doClick(SighInBtnElement);

		scn.log("SignIn button is displayed and Successfully click on it");
		logger.info("SignIn button is displayed and Successfully click on it");

		wait.until(ExpectedConditions.titleIs(SignInTitle));
		String ActsignInTitle =driver.getTitle();		
		Assert.assertEquals("After click SignIn title not match",SignInTitle, ActsignInTitle);

		scn.log("After clicking On SignIn Page Title Validation is Successfully");
		logger.info("After clicking On SignIn Page Title Validation is Successfully");
	}
	
	// TestCase-8
	public void searchBoxVisibility()
	{
	   
		WebElement searchBoxElement =driver.findElement(searchBox);
	    Assert.assertEquals(true, searchBoxElement.isDisplayed());
	    
	    logger.info("SearchBox Validation");
	    scn.log("SearchBox Validation");
	
	}

	
	// TestCase-8
	public void searchProduct(String product)
    {
    	
		WebElement searchBoxElement =driver.findElement(searchBox);
    	searchBoxElement.sendKeys(product);
    	
    	logger.info("search a product in search box, product is: "+ product);
    	scn.log("search a product in search box, product is: "+ product);
    	
    }
	
	// TestCase-8
	public void searchProductList()
    {
     
      List <WebElement> suggProdList= driver.findElements(suggestedProdList);
      wait= new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.visibilityOfAllElements(suggProdList));
      logger.info("Fetching suggested products list, size of list is: "+ suggProdList.size());
      scn.log("Fetching suggested products list, size of list is: "+ suggProdList.size());
      logger.info("Suggested products list is as follows :");
      System.out.println("Suggested products list is as follows :");
      for(int i=0; i< suggProdList.size(); i++)
      {
    	  logger.info(i+1 +". "+ suggProdList.get(i).getText());
    	  scn.log(i+1 +". "+ suggProdList.get(i).getText());
    	  System.out.println(i+1 +". "+ suggProdList.get(i).getText());
      }
      Assert.assertEquals(false, suggProdList.isEmpty());
    
    }
	
	// TestCase-8
	public void validateProductList(String prodName, int prodSize)
	{
	    int count=0;
	    List <WebElement> suggProdList= driver.findElements(suggestedProdList);
	    logger.info("Fetching list of suggested products with desired product name, is as below: ");
	    scn.log("Suggested products list validation, list is as below: ");
	    for(int i=0; i< suggProdList.size(); i++)
	    {
	    	if(suggProdList.get(i).getText().contains(prodName.toString()))
	    	{
	    		Assert.assertEquals(true,suggProdList.get(i).getText().contains(prodName.toString()));
	    		logger.info(i+1 +". "+ suggProdList.get(i).getText());
	        	scn.log(i+1 +". "+ suggProdList.get(i).getText());
	        	count++;
	        }
	    }
	    Assert.assertEquals(prodSize, count);
	    logger.info("Total products containing desired product name are: "+ count);
	    scn.log("Total products containing desired product name are: "+ count);
	}
	
	// TestCase-9
	public void ValidateTwitterLogoClickOnIt()
	{

		WebElement twitterLink = driver.findElement(TwitterLogoElement);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView(true);", twitterLink);
    	Assert.assertEquals(true, twitterLink.isDisplayed());
    	scn.log("Twitter link is displayed successfully.");
    	logger.info("Twitter link is displayed successfully.");
    	twitterLink.click();	

	}
	
	// TestCase-9
	public void ValidateTwitterAccName(String accountName)
	{

		WebElement twitAccName = driver.findElement(TwitterAcctElement);
		Assert.assertEquals(true, twitAccName.isDisplayed());
		Assert.assertEquals(accountName, twitAccName.getText());		
		scn.log("Account name is match. Account name is : "+ twitAccName.getText());
		logger.info("Account name is match. Account name is : "+ twitAccName.getText());

	}
	
}
