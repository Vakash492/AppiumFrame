package com.eva.testcases;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.eva.androidutil.MobileWebUtils;
import com.eva.androidutil.SetCapabilities;
import com.eva.homepage.KilimallHomePage;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {
	protected AndroidDriver driver;
	protected MobileWebUtils ut;
	protected SetCapabilities st;

	@BeforeSuite
	public void createReport() {
		st = new SetCapabilities();
		driver = st.set_Capabilities();
		ut = new MobileWebUtils();
		ut.createExtentReport("API_DEMO_DEBUGGER APPLICATION");
	}

	@BeforeMethod
	public void beforMethodClass(Method mt) {
		ut.createTest(mt.getName());
	}

	@AfterMethod
	public void tearDown() {

		ut.flushReport();
	}

	@AfterSuite
	public void afterSuite() {
//		driver.close();
		ut.flushReport();
	}

}
