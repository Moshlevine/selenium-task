package automationFramework;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public  class firefoxRunner implements Runnable {
	DesiredCapabilities dc;
	firefoxRunner(DesiredCapabilities dc) {
		this.dc = dc;
	}
	@Override
	public void run() {
		
		dc.setCapability("platformName", "firefox");
		dc.setCapability(CapabilityType.BROWSER_VERSION, "57.0.2");
		dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
		WebDriver driver;
		try {
			driver = new RemoteWebDriver(new URL("https://sales.experitest.com" + "/wd/hub/"), dc);
			driver.get("https://www.premierleague.com/tables");
			driver.quit();
		
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
	}  
}