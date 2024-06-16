package com.eva.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.androidutil.MobileWebUtils;

import io.appium.java_client.android.AndroidDriver;

public class KilimallHomePage {
	MobileWebUtils mu;

	public KilimallHomePage(MobileWebUtils mu, AndroidDriver driver) {
		PageFactory.initElements(driver, this);

		// super(driver);
		this.mu = mu;
	}

	@FindBy(xpath = "//android.widget.RadioButton[@resource-id='net.kilimall.shop:id/rb_category']")
	private WebElement catagaryBT;

	@FindBy(xpath = "//android.widget.RadioButton[@resource-id='net.kilimall.shop:id/rb_account']")
	private WebElement accountBT;
	
	public void clickonCatagary() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mu.click(catagaryBT, " Catagary Button ");
	}

	public void clickonAccountBT() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mu.click(accountBT, " Account Button ");
	}
}
