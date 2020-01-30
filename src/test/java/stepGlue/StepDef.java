package stepGlue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	WebDriver driver;
	
	
	@When("Larry searches for product in search field")
	public void larry_searches_for_product_in_search_field(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    //throw new cucumber.api.PendingException();
		List<String> pro_list=dataTable.asList();
		System.out.println(pro_list.size());
		
		for(String plist:pro_list) {
			driver.findElement(By.name("products")).sendKeys(plist);
			String str=driver.findElement(By.xpath("/html/body/div[1]/b")).getText();
			System.out.println(str);
			driver.findElement(By.name("products")).clear();
		}
		
	}

	@Then("Larry verifies the product")
	public void larry_verifies_the_product() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
	
	
	@Given("Sales executive logged into the machine")
	public void sales_executive_logged_into_the_machine() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		driver=DriverUtil.getDriver("chrome");
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}


	@When("Sales executive provides {string} and {string} as credentials")
	public void sales_executive_provides_and_as_credentials(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys(string);
		driver.findElement(By.name("password")).sendKeys(string2);
		driver.findElement(By.name("Cancel")).click();
		driver.quit();
	}

	@Then("Login is successful")
	public void login_is_successful() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}



}
