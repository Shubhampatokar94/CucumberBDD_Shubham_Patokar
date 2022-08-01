@ui @healthcheck
Feature: E-commerce Project website health check

  Background: Navigation to the URL
    Given User navigated to the landing page url

 
  @UrlRedirectionTest 
  Scenario: User is able to Open the browser and navigate to the URL  
    When  User is able to see the landing page
    Then  The landing page url should be "http://automationpractice.com/index.php"
    
  @LandingPageTitleTest
  Scenario: User is able to Open the browser and navigate to the URL
    Then The title of landing page should be "My Store"
    
  @ProdCtgValidationTest
  Scenario: User is able to Open the browser and navigate to the URL
    When User is able to see the product category
    Then Validating product category as per the given list
    |   WOMEN   |
    |  Dresses  |
    | T-SHIRTS  |
    And Size of the product category list is 3
    
  @LandingPgAppLogoDispTest
  Scenario: User is able to Open the browser and navigate to the URL
    When User see the landing page
    Then User must be able to see the landing page logo
    
  @AppLogoHeighttValidation
  Scenario: User is able to Open the browser and navigate to the URL
    When Fetching the height of the logo
    Then The height of logo on the landing page should be "99"
    
  @AppLogoWidthValidation
  Scenario: User is able to Open the browser and navigate to the URL
    When Fetching the width of the logo
    Then The width of logo on the landing page should be "350"
    
  @SignInPgTitleValidationTest
  Scenario: User is able to Open the browser and navigate to the URL
    When User is able to see the landing page
    And  User is able to See the SignIn button on landing page
    Then User click on SignIn Btn and next page title should be "Login - My Store"
    
  @ProdSrcBoxValidation
  Scenario: User is able to Open the browser and navigate to the URL
     Given User is able to see the search box
     When  User is searching for the product "Dress" in given searchBox
     Then  User is able to see the product suggestion list
     And   Fetching "Dress" in product name and validating exp result as 5
     
  @TwitterHandleValidation
  Scenario: User is able to Open the browser and navigate to the URL
    When User click on the twitter logo 
    Then Validating the Twitter account name as "Selenium Framework"
    