package PageClassesZigwheels;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClassesZigwheels.BaseClass;

public class HondaUpcomingBikesPage extends BaseClass {
	
	static WebDriver driver;
	public HondaUpcomingBikesPage(WebDriver driver) {
		this.driver=driver;		
	}
	
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
	public WebElement viewMorelink;
	
	@FindBy(xpath="//strong[@itemprop='name']")
	public List<WebElement> bikeNames;
	
	@FindBy(xpath="//div[@class='b fnt-15']")
	public List<WebElement> bikePrices;
	
	@FindBy(xpath="//div[@class='clr-try fnt-14']")
	public List<WebElement> bikeLaunchDates;
	
	public void clickViewMore() {
		
		//Click on View More Link to display all the bikes
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", viewMorelink);
	}
	public void getBikeDetails() {
		
		for(int i=0;i<bikePrices.size();i++) {
			String bikeprice=bikePrices.get(i).getText();
			int lakhIndex=bikeprice.indexOf(" Lakh");
			String priceno=bikeprice.substring(4, lakhIndex);
			double no=Double.parseDouble(priceno);
			if(no<4) {
				System.out.println(bikeNames.get(i).getText());
				System.out.println(bikeprice);
				System.out.println(bikeLaunchDates.get(i).getText());
			}
		}
		driver.close();
	}

}
