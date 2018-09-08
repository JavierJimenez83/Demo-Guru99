package guru99PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Guru99Login {
	
	//Driver + locators
	private WebDriver driver;
	By titleLocator = By.className("barone");
	By userLocator = By.name("uid");
	By passwordLocator = By.name("password");
	By loginButtonLocator = By.name("btnLogin");
	By resetButtonLocator = By.name("btnReset");
	
	//Constructor
	public Guru99Login(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	//Methods - Get, set, click, goto etc
	public String getTitle()
	{
		return driver.findElement(titleLocator).getText();
	}
	
	public String getUserID()
	{
		return driver.findElement(userLocator).getText();
	}
	
	public String getPassword()
	{
		return driver.findElement(passwordLocator).getText();
	}
		
	public void setUsername(String username)
	{
		driver.findElement(userLocator).clear();
		driver.findElement(userLocator).sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		driver.findElement(passwordLocator).clear();
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(loginButtonLocator).click();
	}

	public void clickResetButton()
	{
		driver.findElement(resetButtonLocator).click();
	}

	
	//Methods - Other
	public void loginIntoPage(String username, String password)
	{
		this.setUsername(username);
		this.setPassword(password);
		this.clickLoginButton();
	}
	
}
