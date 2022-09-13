package APPIUM;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest2 {
	
	static AppiumDriver<MobileElement> AppDriver;
	
	
	public static void main(String[] args) {
		try 
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability("deviceName", "SM-N970U"); //Phone Model Number //Any Name works
			cap.setCapability("udid", "R58M91BWDED");  // Run CMD adb devices 
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "10");  //Software information Android version
			
			cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
			cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			AppDriver = new AppiumDriver<MobileElement>(url,cap);
			System.out.println("Application Started...");
			
			MobileElement two = AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
			two.click();
			MobileElement plus = AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
			plus.click();
			MobileElement three = AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
			three.click();
			MobileElement equals = AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
			equals.click();

			MobileElement result = AppDriver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
			
			String res = result.getText();
			System.out.println("\n Result is : " + res);
			System.out.println("Completed....");
			
			
		} 
		catch (Exception exp) {

			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();

		}
		
	}
	
	

}
