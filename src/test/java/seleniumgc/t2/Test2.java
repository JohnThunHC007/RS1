package seleniumgc.t2;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test2 {

	WebDriver driver = null;
	  
	  
	  @Given("^the web browser is at the SG Digital​ Careers page$")
	  public void goToHomePg() throws Throwable{ 
		  System.setProperty("webdriver.chrome.driver","C:\\DwldExtDriver\\ChromeDriver\\chromedriver.exe");			
		  driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	      driver.navigate().to("https://www.sgdigital.com/"); 
	   } 
  
    @Then("^a free text filter field is available to the user in the careers page for a keyword search$")
    public void checkF1() throws Throwable{

    	try {
    		 
      	  assertTrue(driver.findElement(By.cssSelector("input.srSearchInput")).isDisplayed());
      	  System.out.println("Pass:");	
      	}catch(Exception e) {
      		
      		System.out.println("Fail:");	
      	}
	}
    
    
    @When("^the 26 Alphabetic characters, the number 0 to 9, the spaces, the special characters  are entered in the filter input$")
    public void sendInput() throws Throwable{
    
    	try {
        String arg1=null;
	    arg1="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789    ~`!@#$%^&*()|-_=+{[}];:/?.>,<'\\\"\\\\";
    	driver.findElement(By.cssSelector("input.srSearchInput")).sendKeys(arg1);
    	  System.out.println("Pass:");	
    	}catch(Exception e) {
    		
    		System.out.println("Fail:");	
    	}
    	
    }	
    

    
    @Then("^the alnumeric characters and spaces remain in the fiter input with the special character cleared$")
    public void checkANS() throws Throwable{
    
    	try {
	    String arg1=null;
    	arg1=driver.findElement(By.cssSelector("input.srSearchInput")).getText();
		Pattern pat = Pattern.compile("^[a-z0-9 ]*$", Pattern.CASE_INSENSITIVE);
		Matcher mat = pat.matcher(arg1);
		boolean bat = mat.matches();

		if (bat) {
			  System.out.println("Pass:");	
		}else {
			System.out.println("Fail:");
		}

    	}catch(Exception e) {
    		
    		System.out.println("Fail:");	
    	}
    	
    }	
    
    
    
    @When("^the user performs action as \"([^\"]*)\" a search action should be triggered$")
    public void sendAction(String act) throws Throwable{
    	try {
    		if(act.trim().equalsIgnoreCase("Hit Enter")) {
    			driver.findElement(By.cssSelector("input.srSearchInput")).submit();
    		}else if(act.trim().equalsIgnoreCase("Click Search")){
    			driver.findElement(By.cssSelector("input.srSearchButton")).click();
    		}
 	    
 	   System.out.println("Pass:");	
    }catch(Exception e) {
		
		System.out.println("Fail:");	
	}
		
    }
    
    @Then("^the new results will be displayed$")
    public void checkD() throws Throwable{

    	try {
    		WebElement webtable = null;
    		List<WebElement>cols = null;
    		
    		assertNotNull(webtable=driver.findElement(By.xpath("/html/body")));
    		assertNotNull(cols=webtable.findElements(By.tagName("td")));
            
    		
    		
    System.out.println("Pass:");
    	}catch(Exception e) {
    		
    		System.out.println("Fail:");	
    	}
    
		 
		 }
    
    @Given("^the “Location” filter is available to list all available locations for the open vacancies$")
	  public void checkF2() throws Throwable{ 

    	try {
   		 
        	  assertTrue(driver.findElement(By.cssSelector("span.srSearchOptionText")).isDisplayed());
        	  System.out.println("Pass:");	
        	}catch(Exception e) {
        		
        		System.out.println("Fail:");	
        	}
	   } 
   
    @When("^a location is selected")
    public void selAction() throws Throwable{
    	try {
    	
    		
    			driver.findElement(By.cssSelector("//div[@id='facet_location']/ul/li/span")).click();
    	
 	   System.out.println("Pass:");	
    }catch(Exception e) {
		
		System.out.println("Fail:");	
	}
		
    }
    
    
    @Then("^filtering should apply automatically$")
    public void checkDC() throws Throwable{

    	try {
    		WebElement webtable = null;
    		List<WebElement>cols = null;
    		
    		assertNotNull(webtable=driver.findElement(By.xpath("/html/body")));
    		assertNotNull(cols=webtable.findElements(By.tagName("td")));
    
           System.out.println("Pass:");
    	}catch(Exception e) {
    		
    		System.out.println("Fail:");	
    		
    		
    	}finally {
    		driver.close();
    	}
    
 }
    
    
    
}
