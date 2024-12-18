package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

	WebDriver driver; // declare it as class level ( default access) to use it throughout the package

	@BeforeMethod
	public void initiate() {

		// open chrome
		driver = new ChromeDriver();// constructor of class ChromeDriver creates object of ref var driver of type WebDriver Interface

		

		// open url-https://the-internet.herokuapp.com/
		driver.navigate().to("https://the-internet.herokuapp.com/");

		

	}

	@AfterMethod
	public void closedown() {

		driver.quit(); //close browser

	}
}