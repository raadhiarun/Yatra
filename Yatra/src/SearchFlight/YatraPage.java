package SearchFlight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class YatraPage {
	
	WebDriver driver;
	By departfrom = By.id("BE_flight_origin_city");
	By selectdepart=By.xpath("//p[@class='ac_cityname']//span[text()='(BLR)']");
    By goingto = By.id("BE_flight_arrival_city");
    By selectgoingto=By.xpath("//p[@class='ac_cityname']//span[text()='(DEL)']");
    By date=By.id("BE_flight_origin_date");
    By selectdate=By.xpath("//td[@data-date='06/07/2021']");
    
    By selectbom=By.xpath("//p[@class='ac_cityname']//span[text()='(BOM)']");
    By search=By.id("BE_flight_flsearch_btn");
    By searchdepart=By.xpath("//input[@id='origin_0']");
    By searchgoingto=By.xpath("//input[@id='destination_0']");

  
	
    
		YatraPage(WebDriver driver)
	{
	
	this.driver=driver;
	}
	
	public void selectDepartFrom()
	{
		driver.findElement(departfrom).click();
        driver.findElement(selectdepart).click();
		
	}
	
	public void selectGoingTo()
	{
				
		driver.findElement(goingto).click();
        driver.findElement(selectgoingto).click();
			
			}
	public void selectdate()
	{
				
		driver.findElement(date).click();
        driver.findElement(selectdate).click();
			
			}
		
	
	public void Clicksearch()
	{
		driver.findElement(search).click();
	}
	
	
}
