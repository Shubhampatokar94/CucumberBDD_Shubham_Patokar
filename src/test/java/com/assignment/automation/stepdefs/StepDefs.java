package com.assignment.automation.stepdefs;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.assignment.automation.core.WebDriverFactory;
import com.assignment.automation.pageobjects.LandingPageObjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
    	private static final Logger logger = LogManager.getLogger(StepDefs.class);

	
	    WebDriver driver;
	    String base_url = "http://automationpractice.com";
	    int implicit_wait_timeout_in_sec = 20;
	    Scenario scn;
	    
	    LandingPageObjects landingPageObjects;
	    
	    // ----------------- Before and After Hooks ------------------ //
	    
	    @Before
	    public void setUp(Scenario scn) throws Exception{
			this.scn = scn;
			String browserName = WebDriverFactory.getBrowserName();
			driver = WebDriverFactory.getWebDriverForBrowser(browserName);
			logger.info("Browser invoked.");

			landingPageObjects = new LandingPageObjects(driver, scn);
	    }
	    
	    @After(order=1)
	    public void cleanUp(){
	        WebDriverFactory.quitDriver();
	        scn.log("Browser Closed");
	    }
	    
	    @After(order=2)
	    public void takeScreenShot(Scenario s) {
	        if (s.isFailed()) {
	            TakesScreenshot scrnShot = (TakesScreenshot)driver;
	            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
	            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
	        }else{
	            scn.log("Test case is passed, no screen shot captured");
	        }
	    }
	    
	    // --------------------- Background ---------------------- //
	    
	    @Given("User navigated to the landing page url")
		public void user_navigated_to_the_landing_page_url() {

			WebDriverFactory.navigateToTheUrl(base_url);
			scn.log("Browser navigated to url: " + base_url);

		}
	    
	    // -------------------------- TestCase-one ----------------------------- //
	    
	    @When("User is able to see the landing page")
	    public void user_is_able_to_see_the_landing_page() {
	    	
	    	landingPageObjects.verifyThePage();
	    }
	    @Then("The landing page url should be {string}")
	    public void the_landing_page_url_should_be(String url) {
	    	
	    	landingPageObjects.urlValidation(url);
	    }
	    
	    // --------------------------- TestCase-two ----------------------------- //
	    
	    @Then("The title of landing page should be {string}")
	    public void the_title_of_landing_page_should_be(String pageTitle) {
	    	
	    	landingPageObjects.validateLandingPageTitle(pageTitle);
	    }
	    
	    // --------------------------- TestCase-three --------------------------- //
	    
	    @When("User is able to see the product category")
	    public void user_is_able_to_see_the_product_category() {
	    	landingPageObjects.availProdCategory();
	    }
	    @Then("Validating product category as per the given list")
	    public void validating_product_category_as_per_the_given_list(List<String> prodCat) {
	    	landingPageObjects.validateProdCategory(prodCat);
	    }
	    @Then("Size of the product category list is {int}")
	    public void size_of_the_product_category_list_is(Integer prodCount) {
	    	landingPageObjects.sizeOfProdCategory(prodCount);
	    }
	    
	    // -------------------------- TestCase-four --------------------------- //
	    
	    @When("User see the landing page")
	    public void user_see_the_landing_page() {
	    	
	    	landingPageObjects.verifyThePage();
	    }
	    @Then("User must be able to see the landing page logo")
	    public void user_must_be_able_to_see_the_landing_page_logo() {
	    	
	    	landingPageObjects.validateLandingPageLogo();
	    }
	    
	    // ----------------------------- TestCase-five ------------------------------ //
	    
	    @When("Fetching the height of the logo")
	    public void fetching_the_height_of_the_logo() {
	    	landingPageObjects.fetchLogoHeight();
	    }
	    @Then("The height of logo on the landing page should be {string}")
	    public void the_height_of_logo_on_the_landing_page_should_be(String height) {
	    	landingPageObjects.logoHeightValidation(height);
	    }
	    
	    // ------------------------------- TestCase-six -------------------------------- //
	    
	    @When("Fetching the width of the logo")
	    public void fetching_the_width_of_the_logo() {
	    	landingPageObjects.fetchLogoWidth();
	    }
	    
	    @Then("The width of logo on the landing page should be {string}")
	    public void the_width_of_logo_on_the_landing_page_should_be(String width) {
	    	landingPageObjects.logoWidthValidation(width);
	    }
	    
	    // ---------------------------- TestCase-seven ----------------------------- //
	    
	    @When("User is able to See the SignIn button on landing page")
		public void user_is_able_to_see_the_sign_in_button_on_landing_page() {

			landingPageObjects.validateSignInBtnDisplayOrNOT();
		}
	    @Then("User click on SignIn Btn and next page title should be {string}")
	    public void User_click_on_SignIn_Btn_and_next_page_title_should_be(String signInPageTitle) {
	        
	    	landingPageObjects.ValidateSignInPageTitle(signInPageTitle);
	    }
	    
	    // ----------------------------- TestCase-eight ----------------------------- //
	    
	    @Given("User is able to see the search box")
	    public void user_is_able_to_see_the_search_box() {
	        
	    	landingPageObjects.searchBoxVisibility();
	    }
	    @When("User is searching for the product {string} in given searchBox")
	    public void User_is_searching_for_the_product_in_given_searchBox(String product) {
	        
	    	landingPageObjects.searchProduct(product);
	    }
	    @Then("User is able to see the product suggestion list")
	    public void user_is_able_to_see_the_product_suggestion_list() {
	        
	    	landingPageObjects.searchProductList();
	    }
	    @Then("Fetching {string} in product name and validating exp result as {int}")
	    public void Fetching_in_product_name_and_validating_exp_result_as(String prodName, Integer prodSize) {
	       
	    	landingPageObjects.validateProductList(prodName, prodSize);
	    }
	    
	    // ------------------------------ TestCase-nine ----------------------------- //
	    
	    @When("User click on the twitter logo")
	    public void user_click_on_the_twitter_logo() {
	    	
	    	landingPageObjects.ValidateTwitterLogoClickOnIt();
	    }
        @Then("Validating the Twitter account name as {string}")
	    public void validating_the_twitter_account_name_as(String accountName) {
	    	
        	landingPageObjects.ValidateTwitterAccName(accountName);
	    }
	    
}
