package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment {

	@Test
	public  void Assignment() {
	
		
		 WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		// Log in to OrangeHRM
        WebElement LoginButton = driver.findElement(By.xpath("//*[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", LoginButton);
		
		//Click on dropdpwn
		driver.findElement(By.xpath("//div[@id='app']/div/div[1]/header/div[1]/div[3]/ul/li")).click();
		
		//Click on about
		driver.findElement(By.linkText("About")).click();
		
		//verify if the company name
		String companyName = driver.findElement(By.xpath("//p[text()='OrangeHRM']")).getText();
		Assert.assertEquals(companyName, "OrangeHRM");
		
		//close that window by clicking on x
		driver.findElement(By.xpath("//button[text()='×']")).click();
		
		//click on leave button
		driver.findElement(By.xpath("//span[text()='Leave']")).click();
		
		//click on apply button
		driver.findElement(By.xpath("//a[text()='Apply']")).click();
		
		//click on  Leave Type dropdown
		driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]")).click();

		//select CAN - FMLA
		driver.findElement(By.xpath("//span[text()='CAN - FMLA']")).click();
		
		//input the from date
		driver.findElement(By.xpath("//form/div[2]/div/div[1]/div/div[2]/div/div/input")).sendKeys("2024-30-12");
		
		
		WebElement toDateEle =driver.findElement(By.xpath("//form/div[2]/div/div[2]/div/div[2]/div/div/input"));

		//input the to date
		Actions act = new Actions(driver);
		act.click(toDateEle).keyDown(Keys.CONTROL).sendKeys("A" + "X").keyUp(Keys.CONTROL).sendKeys("2024-30-12").keyDown(Keys.TAB).perform();
		
		//Input the text on comment
		
		driver.findElement(By.xpath("//form/div[4]/div/div/div/div[2]/textarea")).sendKeys("vacation submitted by Aman");
		
		//Click on submitt button submit the leave application
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Go to my leave page to confirm the entry
		driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")).click();
		
		driver.quit();
	}

}
