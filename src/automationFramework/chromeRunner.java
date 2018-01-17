package automationFramework;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class chromeRunner implements Runnable {
	DesiredCapabilities dc;
	chromeRunner(DesiredCapabilities dc) {
		this.dc = dc;
	}
	
	@Override
	public void run() {
		dc.setCapability("platformName", "chrome");
		dc.setCapability(CapabilityType.BROWSER_VERSION, "62");
		dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
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
