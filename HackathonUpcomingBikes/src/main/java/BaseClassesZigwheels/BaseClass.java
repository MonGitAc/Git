package BaseClassesZigwheels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import PageClassesZigwheels.ZigwheelsLandingPage;

public class BaseClass {
	
	public WebDriver driver;

	/****************** Invoke Browser ***********************/
	public void invokeBrowser(String browserName) {

		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Mozilla")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers//geckodriver.exe");
				driver = new FirefoxDriver();
			} 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	}
	
	/**********************Open Application***************/
	public ZigwheelsLandingPage openApplication() {
		driver.get("https://www.zigwheels.com/");
		return PageFactory.initElements(driver, ZigwheelsLandingPage.class);
	}
}


