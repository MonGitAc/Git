package PageClassesZigwheels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClassesZigwheels.BaseClass;

public class ZigwheelsLandingPage extends BaseClass {
	
	static WebDriver driver;
	public ZigwheelsLandingPage(WebDriver driver) {
		this.driver=driver;		
	}
	
	@FindBy(xpath="//a[@href='/newbikes']")
	public WebElement targetNewBikesLink;
	
	@FindBy(xpath="//a[@href='/upcoming-bikes']")
	public WebElement upcomingBikeslink;
	
	@FindBy(xpath="//div[@id='alternate-login-close']")
	public WebElement popup;
	
	public void closePopup() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Close the popup coming up after loading of the homepage of ZigWheels
		popup.click();
	}
	
	public void hoverNewBikes() {
		//Mouse Hover Operation to hover over New Bikes element
		Actions act=new Actions(driver);
		act.moveToElement(targetNewBikesLink).build().perform();
	}
	
	public UpcomingBikesHomepage clickUpcomingBikes() {
		
		//Click on Upcoming Bikes web element
		upcomingBikeslink.click();		
		return PageFactory.initElements(driver, UpcomingBikesHomepage.class);
	}
}
