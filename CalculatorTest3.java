package APPIUM;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import login.SeanWebDriver;

public class CalculatorTest3 {
	
	private static int result = 9;
	private static ChromeDriver wd = null;
	
	static AppiumDriver<MobileElement> AppDriver;
	
	
	public static void main(String[] args) {
		result = 0;
		
		try 
		{
			openCalculator();
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
		String udid = "10.16.0.46:5555"; //10.16.0.46:5555 wifi  //R58M91BWDED
		String platformName = "Android";
		String platformVersion = "10";	
		/*
		Step 1 : adb devices
		Step 2 : adb tcpip 5555 (for WiFi)
		Step 3 : disconnect mobile cable (for WiFi)
		Step 4 : adb connect 10.16.0.46  (for WiFi)
		Step 5 : cmd appium
		Step 6 : adb kill-server (for WiFi)
		Step 7 : adb connect 10.16.0.46:5555 (for WiFi)
		*/
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("deviceName", deviceName); //Phone Model Number //Any Name works
		cap.setCapability("udid", udid);  // Run CMD adb devices 
		cap.setCapability("platformName", platformName);
		cap.setCapability("platformVersion", platformVersion);  //Software information Android version
		
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AppDriver = new AppiumDriver<MobileElement>(url,cap);
		System.out.println("Application Started...");
		
		AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")).click();
		SeanWebDriver.waitT(wd, 1000);
		AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")).click();
		SeanWebDriver.waitT(wd, 1000);
		AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03")).click();
		SeanWebDriver.waitT(wd, 1000);
		AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")).click();
		SeanWebDriver.waitT(wd, 1000);

		MobileElement result = AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
		String res = result.getText();
		SeanWebDriver.waitT(wd, 1000);
		System.out.println("\n Result is : " + res);
		System.out.println("Completed....");

	}

}
