  
	package SearchFlight;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SearchFlight.Xlutilities;


public class NewTest {
	WebDriver driver;
	private String sTestCaseName;

	private int iTestCaseRow;

	@BeforeMethod
       public void test() 
    {
	
		System.setProperty("webdriver.chrome.driver","C:\\Mohi\\Yatra\\jars\\chromedriver_win32\\chromedriver.exe");

	//System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
	// WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	 driver.get("https://www.yatra.com/");
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	 
	 
    }

		
		@DataProvider

		public Object[][] YatraBooking(Method m) throws Exception {

			sTestCaseName = m.getName();
			Xlutilities.setExcelFile("C:\\Mohi\\Yatra\\Yatra\\TestData\\sheet.xlsx", "Sheet1");
			iTestCaseRow = Xlutilities.getRowContains(sTestCaseName, 0);
			Object[][] testObjArray = Xlutilities.getTableArray(
					"C:\\Mohi\\Yatra\\Yatra\\TestData\\sheet.xlsx", "Sheet1", iTestCaseRow);
			
		   
			return (testObjArray);
		}

		@Test(dataProvider = "YatraBooking")
		public void TC001(String DepartFrom, String GoingTo) throws InterruptedException {
				System.out.println("Entered");	
				YatraPage yp=new YatraPage(driver);
				
			WebDriverWait wait = new WebDriverWait(driver, 15);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BE_flight_origin_city")));
					yp.selectDepartFrom();
			Thread.sleep(5000);
			yp.selectGoingTo();
			Thread.sleep(5000);
			yp.selectdate();
			Thread.sleep(5000);
			yp.Clicksearch();
			Thread.sleep(5000);
			
			
			String strxpath=driver.findElement(By.xpath("//input[@id='origin_0']")).getAttribute("value");
			System.out.println("str"+strxpath);
		
			String str1=driver.findElement(By.xpath("//input[@id='destination_0']")).getAttribute("value");
		  
							System.out.println("str1"+str1);
				Assert.assertEquals(DepartFrom,strxpath);
				Assert.assertEquals(GoingTo,str1);
				System.out.println("Testcase Passed");	
			
			
			

		}
		
		@Test(dataProvider = "YatraBooking")
		public void TC002(String DepartFrom, String GoingTo)throws InterruptedException {
		YatraPage yp=new YatraPage(driver);
				WebDriverWait wait = new WebDriverWait(driver, 15);

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BE_flight_origin_city")));
						yp.selectDepartFrom();
				Thread.sleep(5000);
				driver.findElement(yp.goingto).click();
				Thread.sleep(5000);
				driver.findElement(yp.selectbom).click();
				Thread.sleep(5000);
				yp.selectdate();
				Thread.sleep(5000);
				yp.Clicksearch();
				Thread.sleep(5000);
					String strxpath=driver.findElement(By.xpath("//input[@id='origin_0']")).getAttribute("value");
					System.out.println("str"+strxpath);
				
					String str1=driver.findElement(By.xpath("//input[@id='destination_0']")).getAttribute("value");
							System.out.println("str1"+str1);
					Assert.assertEquals(DepartFrom,strxpath);
					Assert.assertNotEquals(GoingTo,"New Delhi (DEL)");

			
			
		}
		@Test(dataProvider = "YatraBooking")
		public void TC003(String DepartFrom, String GoingTo)throws InterruptedException {
			YatraPage yp=new YatraPage(driver);
			WebDriverWait wait = new WebDriverWait(driver, 15);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BE_flight_origin_city")));
		driver.findElement(By.id("BE_flight_origin_city")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//p[@class='ac_cityname']//span[text()='(BOM)']")).click();
			Thread.sleep(5000);
				driver.findElement(By.id("BE_flight_arrival_city")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//p[@class='ac_cityname']//span[text()='(DEL)']")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("BE_flight_origin_date")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//td[@data-date='06/07/2021']")).click();

				driver.findElement(By.id("BE_flight_flsearch_btn")).click();
				Thread.sleep(5000);
			
				String strxpath=driver.findElement(By.xpath("//input[@id='origin_0']")).getAttribute("value");
				System.out.println("str"+strxpath);
			
				String str1=driver.findElement(By.xpath("//input[@id='destination_0']")).getAttribute("value");
						System.out.println("str1"+str1);
				Assert.assertNotEquals(DepartFrom,"Bangalore (BLR)");
				Assert.assertEquals(GoingTo,str1);

		}
		@Test(dataProvider = "YatraBooking")
		public void TC004(String DepartFrom, String GoingTo)throws InterruptedException {
			YatraPage yp=new YatraPage(driver);
			WebDriverWait wait = new WebDriverWait(driver, 15);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BE_flight_origin_city")));
			driver.findElement(By.id("BE_flight_origin_city")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//p[@class='ac_cityname']//span[text()='(DEL)']")).click();
			Thread.sleep(5000);
				driver.findElement(By.id("BE_flight_arrival_city")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//p[@class='ac_cityname']//span[text()='(BOM)']")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("BE_flight_origin_date")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//td[@data-date='06/07/2021']")).click();

				driver.findElement(By.id("BE_flight_flsearch_btn")).click();
				Thread.sleep(5000);
			
				String strxpath=driver.findElement(By.xpath("//input[@id='origin_0']")).getAttribute("value");
				System.out.println("str"+strxpath);
			
				String str1=driver.findElement(By.xpath("//input[@id='destination_0']")).getAttribute("value");
						System.out.println("str1"+str1);
				Assert.assertNotEquals(DepartFrom,"Bangalore (BLR)");
				Assert.assertNotEquals(GoingTo,"New Delhi");
				

		}
		@AfterMethod
		public void af()
		{
			driver.close();
		}
		
		
		
	}


	

