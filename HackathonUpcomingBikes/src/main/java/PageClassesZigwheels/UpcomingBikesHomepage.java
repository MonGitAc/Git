package PageClassesZigwheels;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClassesZigwheels.BaseClass;

public class UpcomingBikesHomepage extends BaseClass{
	
	static WebDriver driver;
	public UpcomingBikesHomepage(WebDriver driver) {
		this.driver=driver;		
	}
	
	@FindBy(xpath="//select[@id='makeId']")
	public WebElement dropbox;
	
	public HondaUpcomingBikesPage selectHondaBikes(String bikeManufacturer) {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Select Honda manufacturer from the given dropdown
		Select dropdown=new Select(dropbox);
		dropdown.selectByVisibleText(bikeManufacturer);
		
		return PageFactory.initElements(driver, HondaUpcomingBikesPage.class);
		
	}
}
