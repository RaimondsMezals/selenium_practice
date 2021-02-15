package qa.com.googledemo;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleKittensTest {
	
	private static RemoteWebDriver driver;
	private static WebElement targ;
	
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		
		driver = new ChromeDriver(chromeCfg());
		System.out.println("Tests have Started");
		
	}
	
	@AfterClass
	public static void cleanUp() {
		driver.quit();
	System.out.println("The driver has been closed!");
	}
	
	@Before
	public void before() {
		System.out.println("\nTest has started!");
	}
	
	@After
	public void after() {
		System.out.println("\nTest has finished!");
	}
	
	@Test
	public void test1() throws InterruptedException {
		driver.get("http://www.google.com");
		
		targ = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
		targ.sendKeys("kittens");
		targ.submit();
		
		targ = driver.findElement(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a"));
		targ.click();
		
		String result = driver.getTitle();
		assertEquals("kittens - Google Search", result);
		
		Thread.sleep(5000);
	}
	
	public static ChromeOptions chromeCfg() {
		 Map<String, Object> prefs = new HashMap<String, Object>();
		 ChromeOptions cOptions = new ChromeOptions();
		  
		 // Settings
		 prefs.put("profile.default_content_setting_values.cookies", 2);
		 prefs.put("network.cookie.cookieBehavior", 2);
		 prefs.put("profile.block_third_party_cookies", true);

		 // Create ChromeOptions to disable Cookies pop-up
		 cOptions.setExperimentalOption("prefs", prefs);

		 return cOptions;
		 }

}
