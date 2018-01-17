package automationFramework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstTest {
	
	public static int number_of_chrome=2;
	public static int number_of_firefox=0;
	public static int number_of_ie=0;
	

	


	public static void main(String[] args) throws InterruptedException, IOException {
		
	

		DesiredCapabilities dc;
		dc= new DesiredCapabilities();
		dc.setCapability("accessKey", "eyJ4cC51IjoxMTUsInhwLnAiOjIsInhwLm0iOiJNQSIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE4MzE1NzI1MzksImlzcyI6ImNvbS5leHBlcml0ZXN0In0.sPv-i-q02EmdH1fXwy7PF4eTyRTCtj2orbcSyG6SZQw");
//		dc.setCapability("projectName", "<cloudProject>"); //only required if your user has several projects assigned to it. Otherwise, exclude this capability.
		dc.setCapability("generateReport", true);
		dc.setCapability("testName", "table test");
		dc.setCapability("newSessionWaitTimeout", 90);
		dc.setCapability("newCommandTimeout", 120);


		int sumofthreads = number_of_chrome+number_of_firefox;
		System.out.println("we are going to start "+sumofthreads+" threads");
	
		for (int i = 0; i < number_of_firefox; i++) {
			Thread thread = new Thread (new firefoxRunner(dc));		
			thread.start();
			System.out.println("started firefox thread succesfully");
		}
		
		for (int i = 0; i < number_of_chrome; i++) {
			Thread thread = new Thread (new chromeRunner(dc));		
			thread.start();
			System.out.println("started chrome thread succesfully");
			
		}

	 }	
}


