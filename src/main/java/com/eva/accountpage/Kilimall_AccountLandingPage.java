package com.eva.accountpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.androidutil.MobileWebUtils;

import io.appium.java_client.android.AndroidDriver;

public class Kilimall_AccountLandingPage {

	MobileWebUtils mu;

	public Kilimall_AccountLandingPage(MobileWebUtils mu, AndroidDriver driver) {
		PageFactory.initElements(driver, this);

		// super(driver);
		this.mu = mu;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id='net.kilimall.shop:id/tv_nickname']")
	private WebElement loginLink;
	
	public void clickonLoginLink() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mu.click(loginLink, " Catagary Button ");
	}
	
	
	
}
