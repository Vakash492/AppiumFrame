package com.eva.accountpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eva.androidutil.MobileWebUtils;

import io.appium.java_client.android.AndroidDriver;

public class Kilimall_AccountLoginPage {

	MobileWebUtils mu;

	public Kilimall_AccountLoginPage(MobileWebUtils mu, AndroidDriver driver) {
		PageFactory.initElements(driver, this);

		// super(driver);
		this.mu = mu;
	}

	@FindBy(xpath = "//android.widget.EditText[@resource-id='net.kilimall.shop:id/et_user_name']")
	private WebElement userName;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='net.kilimall.shop:id/et_user_password']")
	private WebElement password;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id='net.kilimall.shop:id/bt_login']")
	private WebElement loginBT;
	
	public void fillUpCredential() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mu.clear(userName, "UserName TextBox");
		mu.sendKeys(userName,"akashvarun492@gmail.com" ," Catagary Button ");
		mu.clear(userName, "Password TestBox");
		mu.sendKeys(password,"akashvarun@1234" ,"Passowrd TextBox");
		mu.click(loginBT, "Login Button");
	}
	
	
	
	
	
}
