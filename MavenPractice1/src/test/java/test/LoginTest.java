package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	  @BeforeClass (description = "setUp",alwaysRun= true, groups= {"sanity"})
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver", "D:/chromefile/chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("chrome driver launched successfully");
	  }
	  
	  @Test (description = "url",priority=1, groups= {"sanity"})
	  public void testcase1() throws InterruptedException {
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Thread.sleep(1000);
	  }
	  @Test(priority = 2, groups= {"sanity"})
	  public void testcase2() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	  }
	  @Test(enabled = true,priority=3, groups= {"sanity","regression"})
	  public void testcase3() throws InterruptedException {
		  
		  Thread.sleep(2000);
		  String actualURL = driver.getCurrentUrl();
		  String expectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		  Assert.assertEquals(actualURL, expectedURL);
	  }
	  @Test(priority = 4,groups= {"sanity","regression"})
	  public void testcase4() throws InterruptedException {
		  Thread.sleep(1000);
		  String actualTitle = driver.getTitle();
		  String expectedTitle = "OrangeHRM";
		  Thread.sleep(1000);
		  Assert.assertEquals(actualTitle, expectedTitle);
	  }
	  @Test(priority = 5, groups= {"sanity"})
		public void testcase5() throws InterruptedException {
		  driver.findElement(By.xpath("//span[@class=\"oxd-userdropdown-tab\"]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
		  Thread.sleep(1000);
		  String actualURL = driver.getCurrentUrl();
		  String expectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		  Thread.sleep(1000);
		  Assert.assertEquals(actualURL, expectedURL);
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

}
