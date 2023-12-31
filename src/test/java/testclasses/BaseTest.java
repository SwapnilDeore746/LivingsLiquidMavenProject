package testclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.HomePage;
import pages.ProductPage;
import utility.CofigReader;


public class BaseTest {
	public static WebDriver driver;
	HomePage homepage;
	ProductPage productpage;
	
	@BeforeSuite
	public void initBrowser() throws IOException
	{
		CofigReader cr=new CofigReader();
		String browsername=cr.readConfig("browser");
		if(browsername.equals("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		
		
		
		String url=cr.readConfig("testsiteurl");
		
		driver.get(url);
	}
	
	@BeforeClass
	public void creatObject()
	{
		 homepage = new HomePage(driver);
		 productpage = new ProductPage(driver);
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
