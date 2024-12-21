package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectAllText {

	public static void main(String[] args) {
		   WebDriver driver = new ChromeDriver();
	       driver.get("https://the-internet.herokuapp.com/");
	       WebElement ele = driver.findElement(By.linkText("Form Authentication"));
	       ele.click();

	       WebElement usernameTextField = driver.findElement(By.xpath("//*[@id=\'username\']"));
	       usernameTextField.sendKeys("tomsmith");
         
	       Actions action = new Actions(driver);
	       //press ctrl key
	       action.moveToElement(usernameTextField).keyDown(Keys.CONTROL);
	       
	       //Press 'a' select all
	       action.moveToElement(usernameTextField).sendKeys("a");
	       
	       //Release CTRL key
	       action.moveToElement(usernameTextField).keyUp(Keys.CONTROL);
	       
	       action.moveToElement(usernameTextField).perform();
	       
	       driver.quit();     

	}

}
