package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       WebDriver driver = new ChromeDriver();
       driver.get("https://the-internet.herokuapp.com/");
       WebElement ele = driver.findElement(By.linkText("Form Authentication"));
       ele.click();

       WebElement usernameTextField = driver.findElement(By.xpath("//*[@id=\'username\']"));
       usernameTextField.sendKeys("tomsmith");
       WebElement passwordTextField = driver.findElement(By.xpath("//*[@id=\'password\']"));
       passwordTextField.sendKeys("SuperSecretPassword!");
       WebElement loginButton = driver.findElement(By.xpath("//*[@id=\'login\']/button/i"));
       loginButton.click();

       WebElement confirmMessageEle = driver.findElement(By.xpath("//*[@id='flash']"));
       String confirmationText =confirmMessageEle.getText();
       if(confirmationText.contains("You logged into a secure area!")) {
		System.out.print("Login test successfull");
	} else {
		System.out.print("Login test failed");
	}

       driver.quit();








	}

}
