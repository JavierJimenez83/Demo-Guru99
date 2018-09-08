package guru99Tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import guru99PageObjects.Guru99Login;
import guru99PageObjects.Guru99Manager;


public class Guru99LoginTest {

	//PageObjects
	WebDriver driver;
	private Guru99Login loginPageObject;
	private Guru99Manager managerPageObject;
		
	
    @Before
    public void setup(){
    	System.setProperty("webdriver.chrome.driver", "C:/Users/Training/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }
 
	
	@Test
	public void failedLoginWrongUserID() {
        loginPageObject = new Guru99Login(driver);
		loginPageObject.loginIntoPage("mgr124", "mgr!23");			
		assertTrue(driver.switchTo().alert().getText().contains("User or Password is not valid"));
	}

	@Test
	public void failedLoginWrongPassword() {
        loginPageObject = new Guru99Login(driver);
		loginPageObject.loginIntoPage("mgr123", "ngr!23");
		assertTrue(driver.switchTo().alert().getText().contains("User or Password is not valid"));	
	}
	
	@Test
	public void successLogin() {
        loginPageObject = new Guru99Login(driver);
		loginPageObject.loginIntoPage("mgr123", "mgr!23");
		managerPageObject = new Guru99Manager(driver);
		assertTrue(managerPageObject.getManagerID().contains("mgr123"));	
	}
	
	@Test
	public void resetUserID() throws InterruptedException {
        loginPageObject = new Guru99Login(driver);
        String test = "test";
		loginPageObject.setUsername(test);
		loginPageObject.clickResetButton();
		assertTrue(loginPageObject.getUserID().equals(""));	
	}
	
	@Test
	public void resetPassword() throws InterruptedException {
        loginPageObject = new Guru99Login(driver);
        String test = "test";
		loginPageObject.setPassword(test);
		loginPageObject.clickResetButton();
		assertTrue(loginPageObject.getPassword().equals(""));
	}
	
	 @After
	 public void tearDown(){
		 driver.quit();
	 }
	
}
