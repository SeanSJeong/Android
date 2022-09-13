package Basic;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import login.SeanWebDriver;

public class BasicFormat {
	
	private static int result = 9;
	private static ChromeDriver wd = null;
	
	static AppiumDriver<MobileElement> AppDriver;
	
	
	public static void main(String[] args) {
		result = 0;
		
		try 
		{
			openCalculator();
			//AppDriver.findElement(By.id("")).click();
			//SeanWebDriver.waitT(wd, 1000);
			AppDriver.findElement(By.xpath("//*[@class='android.widget.Button' and (./preceding-sibling::* | ./following-sibling::*)[./*[@class='android.widget.Button']]]")).click();
			AppDriver.findElement(By.xpath("//*[@text='Allow']")).click();
			AppDriver.findElement(By.xpath("//*[@text='Allow']")).click();
			

			
			
		} 
		catch (Exception exp) {

			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
			result += -10;
		    System.out.println("It is not selected. -10");

		    
		}
		finally
		{
			if(wd != null)
				wd.quit();
		}
        System.exit(result);
		
	}
	
	public static void openCalculator() throws Exception {
		
		String deviceName = "SM-N970U";
		String udid = "ce071717b9c9c134047e"; //10.16.0.46:5555 wifi  //R58M91BWDED
		String platformName = "Android";
		String platformVersion = "9";	
		String appPackage = "us.cm3.secure_mobile";
		String appActivity = "us.cm3.secure_mobile.MainActivity";
		String URL = "http://127.0.0.1:4723/wd/hub";
		/*
		Step 1 : adb devices
		Step 2 : adb tcpip 5555 (for WiFi)
		Step 3 : disconnect mobile cable (for WiFi)
		Step 4 : adb connect 10.16.0.37  (for WiFi)
		Step 5 : cmd appium
		Step 6 : adb kill-server (for WiFi)
		Step 7 : adb connect 10.16.0.37:5555 (for WiFi)
		*/
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", deviceName); //Phone Model Number //Any Name works
		cap.setCapability("udid", udid);  // Run CMD adb devices 
		cap.setCapability("platformName", platformName);
		cap.setCapability("platformVersion", platformVersion);  //Software information Android version
		
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		
		URL url = new URL(URL);
		AppDriver = new AppiumDriver<MobileElement>(url,cap);
		System.out.println("Application Started...");
		

		SeanWebDriver.waitT(wd, 1000);

		System.out.println("Completed....");

	}

}
