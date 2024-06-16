package com.eva.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.eva.accountpage.Kilimall_AccountLandingPage;
import com.eva.accountpage.Kilimall_AccountLoginPage;
import com.eva.homepage.KilimallHomePage;

public class HomePageTestScript extends BaseTest {

	KilimallHomePage home ;
	
//	@Test
//	public void verifyDummyApplication() {
//
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']")).click();
//		
//	}
	
	@Test
	public void verifyKilimallAccountPage() {
	 home = new KilimallHomePage(ut, driver);
	 home.clickonCatagary();

		 home = new KilimallHomePage(ut, driver);
		

		home.clickonAccountBT();
		
	 	Kilimall_AccountLandingPage kAccountObj=	new Kilimall_AccountLandingPage(ut, driver);
	 	kAccountObj.clickonLoginLink();
	 	
	 	Kilimall_AccountLoginPage kLoginObj=	new Kilimall_AccountLoginPage(ut, driver);
	 	kLoginObj.fillUpCredential();
       System.err.println("paased");
	}
}
