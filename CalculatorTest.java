package APPIUM;

import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
	
	static AppiumDriver<MobileElement> AppDriver;
	
	
	public static void main(String[] args) {
		try 
		{
			openCalculator();
		} 
		catch (Exception exp) {

			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();

		}
		
	}
	
	public static void openCalculator() throws Exception {
		
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
	}

}
