package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest {
	@Test(priority=1)
	public void validateTitle() 
	{
		String title = homepage.getTitleOfPage();
		
		String exepected = "Mumbai";
		
		boolean ispresent = title.contains(exepected);
		
		Assert.assertEquals(ispresent, true);
	}

	
	@Test(priority=2)
	public void navToSingleMalt()
	{
		homepage.clickOnSpirit();
		homepage.navToProductPage();
	}
	}
	