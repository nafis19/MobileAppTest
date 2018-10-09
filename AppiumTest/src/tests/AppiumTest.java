package tests;

import java.net.MalformedURLException;
import java.net.URL;
	 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	 
	public class AppiumTest {
		
		static WebDriver driver;
		
		@BeforeTest
		public void setup() {
			
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "99bcfa27"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("appPackage", "com.vbanthia.androidsampleapp");
		caps.setCapability("appActivity", "com.vbanthia.androidsampleapp.MainActivity");
		caps.setCapability("noReset", "true");
			
		//Instantiate Appium Driver
			try {
					AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
		}
			
		@Test (priority = 0)
		public void sum() {
			
			driver.findElement(By.id("com.vbanthia.androidsampleapp:id/inputFieldLeft")).sendKeys("11");
			
			driver.findElement(By.id("com.vbanthia.androidsampleapp:id/inputFieldRight")).sendKeys("5");	
			
			driver.findElement(By.id("com.vbanthia.androidsampleapp:id/additionButton")).click();
			
			driver.findElement(By.id("com.vbanthia.androidsampleapp:id/resetButton")).click();
			
		}
		
		@Test (priority = 1)
		public void multiply() {
			
			driver.findElement(By.id("com.vbanthia.androidsampleapp:id/inputFieldLeft")).sendKeys("11");
			
			driver.findElement(By.id("com.vbanthia.androidsampleapp:id/inputFieldRight")).sendKeys("7");	
			
			driver.findElement(By.id("com.vbanthia.androidsampleapp:id/multiplicationButton")).click();
			
			driver.findElement(By.id("com.vbanthia.androidsampleapp:id/resetButton")).click();
				
			
		}
		
		@AfterTest
		 public void End() {
		  driver.quit();
		 }
	 
	}

