package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FindElementByDiffWays extends BaseTest {
		
		@Test (priority = 1)
		public void selDropDownTest1() {
			
			driver.findElement(By.linkText("Dropdown")).click();
			//driver.findElement(By.xpath("//a[text()='Dropdown']")).click();

			
			WebElement optionEle = driver.findElement(By.id("dropdown"));
			//WebElement optionEle = driver.findElement(By.xpath("//*[@id='dropdown']"));

			Select select = new Select(optionEle);
			select.selectByIndex(1);
			select.selectByContainsVisibleText("ion 2");
			select.selectByValue("1"); 
			select.selectByVisibleText("Option 2");

		}

		//@Test (priority = 2)
		public void DemoDropDownTest2() {

			// click on dropdown box
			driver.findElement(By.xpath("//*[@id='withOptGroup']/div")).click();
            // driver.findElement(By.id("withOptGroup")).click();

			// click on Group 1, Option 1 to select
			driver.findElement(By.xpath("//*[text()='Group 1, option 1']")).click();
			// driver.findElement(By.xpath("//*[@id='withOptGroup']/div/div[1]/div[1]")).click();

			// Select One AND click on dropdown box
			driver.findElement(By.xpath("//*[@id='selectOne']/div")).click();

			
			driver.findElement(By.xpath("//*[@id='selectOne']/div/div[1]/div")).click();
			//driver.findElement(By.xpath("//*[text()='Other']")).click();

		    //driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
			WebElement oldSelectMenuEle = driver.findElement(By.id("oldSelectMenu"));

			Select select = new Select(oldSelectMenuEle);
			select.selectByValue("red");
			select.selectByVisibleText("Blue");
			select.selectByContainsVisibleText("ua");
			select.selectByIndex(5);

			
			//WebElement multiSelectEle = driver.findElement(By.xpath("//*[@id='cars']"));
			
			WebElement MSEle = driver.findElement(By.id("cars"));
			
			//WebElement multiSelectEle = driver.findElement(By.name("cars"));
			Select selection1 = new Select(MSEle);
			selection1.selectByVisibleText("Volvo");
			selection1.selectByContainsVisibleText("ud");
			selection1.selectByValue("ope");
			selection1.selectByIndex(3);
			selection1.deselectAll();

		}

	}

	


