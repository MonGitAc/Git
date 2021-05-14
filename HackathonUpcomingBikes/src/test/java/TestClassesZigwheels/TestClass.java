package TestClassesZigwheels;

import org.testng.annotations.Test;

import BaseClassesZigwheels.BaseClass;
import PageClassesZigwheels.HondaUpcomingBikesPage;
import PageClassesZigwheels.UpcomingBikesHomepage;
import PageClassesZigwheels.ZigwheelsLandingPage;

public class TestClass extends BaseClass{
	
	ZigwheelsLandingPage landingPage;
	UpcomingBikesHomepage bikeHomepage;
	HondaUpcomingBikesPage hondaBikesPage;
	
	@Test
	public void displaybikedetails() {
		
		invokeBrowser("Chrome");
		landingPage=openApplication();
		
		landingPage.closePopup();
		landingPage.hoverNewBikes();
		bikeHomepage=landingPage.clickUpcomingBikes();
		hondaBikesPage=bikeHomepage.selectHondaBikes("Honda");
		hondaBikesPage.clickViewMore();
		hondaBikesPage.getBikeDetails();
}
}
