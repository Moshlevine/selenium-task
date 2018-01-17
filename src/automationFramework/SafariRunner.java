package automationFramework;

import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SafariRunner implements Runnable {


	DesiredCapabilities dc;
	SafariRunner(DesiredCapabilities dc) {
		this.dc = dc;
	}
	@Override
	public void run() {
		dc.setCapability("platformName", "safari");
		dc.setCapability(CapabilityType.BROWSER_VERSION, "57.0.2");
		dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.SAFARI);
		
	}  
}