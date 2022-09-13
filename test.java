package Three_MC;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import login.SeanWebDriver;

public class test {
	static int result = 7;
	private static ChromeDriver wd = null;
	
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Three_MC_login";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    //Late Update 2020/10/21
    String ID = "seanjeong";
    String Password = "sksskdiPW123";
    @BeforeMethod
	public void setUp() throws MalformedURLException {

    }
    @Test
    public void testUntitled() throws MalformedURLException {
    	
        String UDID[] = {"ce071717b9c9c134047e"};// "R58M91BWDED", "ce071717b9c9c134047e"  "10.16.0.39:5555"
        for(int i = 0; i < UDID.length; i++)
        {	
    	
    	// Open Appium Studio 
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, UDID[i]);  //10.16.0.45:5555 wifi  //R58M91BWDED  Note 10 // R38J90JRM6J Note 8
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "us.cm3.secure_mobile");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
        
        try 
        {
        	driver.findElement(By.xpath("//*[@class='android.widget.Button' and (./preceding-sibling::* | ./following-sibling::*)[./*[@class='android.widget.Button']]]")).click();
        	SeanWebDriver.waitT(wd, 1000);
        	driver.findElement(By.xpath("//*[@text='Allow']")).click();
        	SeanWebDriver.waitT(wd, 1000);
            driver.findElement(By.xpath("//*[@text='Allow']")).click();
            SeanWebDriver.waitT(wd, 1000);
            
        }
        catch (Exception exp) 
        {
        	System.out.println("It is not required.");
        }
        try 
        {
            if(driver.findElement(By.xpath("//*[@text='UserID or Email']")).isDisplayed())
            {
	        	driver.findElement(By.xpath("//*[@text='UserID or Email']")).click();
	            SeanWebDriver.waitT(wd, 1000);
	            System.out.println("1");
	            
	            Actions action = new Actions(driver);
	            action.sendKeys(ID).perform();
	            SeanWebDriver.waitT(wd, 1000);
	            System.out.println("3");
            }
        }
        catch (Exception exp) 
        {
        	System.out.println("ID is remembered");
        } 
        try 
        { 
            if(driver.findElement(By.xpath("//*[@text='Password']")).isDisplayed())
            {     	
	        	driver.findElement(By.xpath("//*[@text='Password']")).click();
	            SeanWebDriver.waitT(wd, 1000);
	            System.out.println("4");
	            Actions action2 = new Actions(driver);
	            action2.sendKeys(Password).perform();
	            SeanWebDriver.waitT(wd, 1000);
	            System.out.println("5");
	            driver.findElement(By.xpath("//*[@content-desc='Login']")).click();
	            SeanWebDriver.waitT(wd, 5000);
	            System.out.println("6");
            }
        }
        catch (Exception exp) 
        {
        	System.out.println("already logged In");
        } 
        try 
        {
        	 driver.findElement(By.xpath("//*[@class='android.widget.Button']")).click();
             SeanWebDriver.waitT(wd, 2000);
             System.out.println("2-1");

        	 driver.findElement(By.xpath("//*[@content-desc='About…']")).click();
             SeanWebDriver.waitT(wd, 2000);
             System.out.println("2-2");
             driver.findElement(By.xpath("//*[@content-desc='Back']")).click();
             SeanWebDriver.waitT(wd, 2000);
             System.out.println("2-3");
             driver.findElement(By.xpath("//*[@class='android.widget.Button']")).click();
             SeanWebDriver.waitT(wd, 2000);
             System.out.println("2-4");
             driver.findElement(By.xpath("//*[@content-desc='Log Out']")).click();
             SeanWebDriver.waitT(wd, 2000);
             System.out.println("Log Out");  
             driver.quit();
        }
        catch (Exception exp) 
        {
        	result = -1;
        	System.out.println("Button failed.");
        } 

        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}