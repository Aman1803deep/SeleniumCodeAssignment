package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment16dec {

		public class ForgotPasswordTest extends BaseTest {

			String ExpectedMsg = "Internal Server Error";
			String ExpectedHeading = "Forgot Password";
			String ExpectedFooter = "Elemental Selenium";
			String ExpectedTitle = "The Internet";

			public void clickForgotPasswordLink() {

				// Click on link - Forgot Password
				WebElement forgotPwdLink = driver.findElement(By.linkText("Forgot Password")); 
				forgotPwdLink.click();

			}

			@Test
			public void VerifyForgotPasswordTest() {

				clickForgotPasswordLink(); 

				// Enter email in the Text box
				WebElement emailText = driver.findElement(By.xpath("//*[@id='email']"));
				emailText.sendKeys("Aman1243kaur@gmail.com"); //

				// Click on retrieve password button
				WebElement retrievePwdBtn = driver.findElement(By.xpath("//*[@id='form_submit']"));
				retrievePwdBtn.click();

				// Verify if actual heading is same as expected heading - "Internal Server Error"
				WebElement actualErrorEle = driver.findElement(By.xpath("/html/body/h1"));
				String actualErrorMsg = actualErrorEle.getText();

				Assert.assertEquals(actualErrorMsg, ExpectedMsg);

			}

			@Test(priority = 1)
			public void VerifyForgotPasswordPageHeadingTest() {

				clickForgotPasswordLink(); // click on Forgot password link

				// find the page Heading
				WebElement actualHeadingEle = driver.findElement(By.xpath("//*[@id='content']/div/h2")); // page
				String actualHeadingText = actualHeadingEle.getText();

				// validate the actual Heading matches the expected Heading "Forgot Password"
				Assert.assertEquals(actualHeadingText, ExpectedHeading); 
			}

			@Test(priority = 2)
			public void verifyPageFooterTest() {

				clickForgotPasswordLink(); // click on Forgot password link

				// Find Page Footer
				WebElement PageFooterEle = driver.findElement(By.xpath("//*[@id='page-footer']/div/div/a"));
				String PageFooterText = PageFooterEle.getText();

				// Validate actual Page footer is same as expected page
				Assert.assertEquals(PageFooterText, ExpectedFooter);

			}

			@Test(priority = 3)
			public void verifyTitleTest() {

				clickForgotPasswordLink();  // click on Forgot password link

				// Find actual page title
				String actualTitle = driver.getTitle();

				// Verify actual page title is same as expected title - "The Internet"
				Assert.assertEquals(actualTitle, ExpectedTitle);
				
			}
			
	}

}
