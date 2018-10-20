package seleniumgc.t1;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test1 {

	WebDriver driver = null;
	   
	  @Given("^the web browser is at the SG Digital​ home page$")
	  public void goToHomePg() throws Throwable{ 
		  
		  System.setProperty("webdriver.chrome.driver","C:\\DwldExtDriver\\ChromeDriver\\chromedriver.exe");			
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.navigate().to("https://www.sgdigital.com/"); 

	  } 
  
    @Then("^a new menu should be displayed in the top menu$")
    public void checkTopMenuCount() throws Throwable{

 	       int expected=0;
		   int actual=0;
		   try {
		   actual =driver.findElements(By.xpath("//div/nav/ul/li")).size();
		   expected=12;
		   if(expected== actual) {
			   System.out.println("Pass:");
		   }else{
			   System.out.println("Fail:");
		   }
		   }catch(Exception e) {
	    		
	    		System.out.println("Fail:");	
	    	}
		 }
    
    
    @Then("^menu text should be “Careers”$")
    public void checkNewMenuTag() throws Throwable{
    
    	try {
	 
    	  assertTrue(driver.findElement(By.linkText("Careers")).isDisplayed());
    	  System.out.println("Pass:");	
    	}catch(Exception e) {
    		
    		System.out.println("Fail:");	
    	}
    	

    
	
    }	
    
    @When("^a user clicks on the menu item \"Careers\"$")
    public void clickTopMenuCount() throws Throwable{
    	try {
 	    driver.findElement(By.linkText("Careers")).click();
 	   System.out.println("Pass:");	
    }catch(Exception e) {
		
		System.out.println("Fail:");	
	}
		
    }
    
    @Then("^he should be navigated into the Careers page$")
    public void checkURL() throws Throwable{

    	try {
    assertEquals("https://www.sgdigital.com/careers",driver.getCurrentUrl());
    
    System.out.println("Pass:");
    	}catch(Exception e) {
    		
    		System.out.println("Fail:");	
    	}finally {
    		driver.close(); 
    	}
    
		 
		 }
    
   
    
}
