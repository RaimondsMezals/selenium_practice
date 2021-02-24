package qa.com.googledemo.cuke.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleStepDef {

	
	private static RemoteWebDriver driver;
	private static WebElement targ;
	
	public static ChromeOptions chromeCfg() {
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 ChromeOptions cOptions = new ChromeOptions();
		 cOptions.addArguments("--headless");
		 // Settings
		 prefs.put("profile.default_content_setting_values.cookies", 2);
		 prefs.put("network.cookie.cookieBehavior", 2);
		 prefs.put("profile.block_third_party_cookies", true);

		 // Create ChromeOptions to disable Cookies pop-up
		 cOptions.setExperimentalOption("prefs", prefs);

		 return cOptions;
		 }
	
	@Before
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		driver = new ChromeDriver(chromeCfg());
	}
	
	@After
	public static void cleanUp() {
		driver.quit();
	}
	
	//Kittens
	
	@Given("^That I can access \"([^\"]*)\"$")
	public void that_I_can_access(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		targ = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
		targ.sendKeys(arg1);
		targ.submit();
	}

	@When("^I select the images tab$")
	public void i_select_the_images_tab() throws Throwable {
		targ = driver.findElement(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a"));
		targ.click();
	}

	@Then("^I should be able to view images of \"([^\"]*)\"$")
	public void i_should_be_able_to_view_images_of(String arg1) throws Throwable {
		String result = driver.getTitle();
		assertEquals(arg1+" - Google Search", result);
	}
	
}
