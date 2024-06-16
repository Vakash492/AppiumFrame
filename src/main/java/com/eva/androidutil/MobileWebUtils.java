package com.eva.androidutil;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MobileWebUtils {

	private AndroidDriver driver;

	private static ExtentReports extReports;
	private ExtentTest extTest;

//	public MobileWebUtils(AndroidDriver driver) {
//		this.driver = driver;
//	}
//	

	public void createExtentReport(String applicationName) {
		String dt = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());
		extReports = new ExtentReports();
		File folder = new File("Reports");
		if (folder.exists() == false) {
			folder.mkdir();
		}
		ExtentSparkReporter extSpark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/Reports/" + applicationName + dt + ".html");
		extReports.attachReporter(extSpark);

	}

	public void createTest(String testcase) {
		extTest = extReports.createTest(testcase);

	}

	public void flushReport() {
		extReports.flush();

	}
	
	public void sendKeys(WebElement we, String valueTosend, String elementNameString) {

		try {
			we.sendKeys(valueTosend);
			extTest.log(Status.INFO,
					"SuccessFully [ " + valueTosend + " ] entered in [ " + elementNameString + " ] text Box");
		} catch (Exception e) {
			extTest.log(Status.FAIL,
					"Value [ " + valueTosend + " ] is not enter in [ " + elementNameString + " ] text Box");
			throw e;
		}
	}

	public void clear(WebElement we, String elementNameString) {

		try {

			we.click();
			extTest.log(Status.INFO, "SuccessFully clicked on [ " + elementNameString + " ] ");
		} catch (Exception e) {
			extTest.log(Status.FAIL, " click is not perform on [ " + elementNameString + " ] ");
			throw e;
		}
	}
	
	public void click(WebElement we, String elementNameString) {

		try {

			we.click();
			extTest.log(Status.INFO, "SuccessFully clicked on [ " + elementNameString + " ] ");
		} catch (Exception e) {
			extTest.log(Status.FAIL, " click is not perform on [ " + elementNameString + " ] ");
			throw e;
		}
	}

	public void selectByValue(WebElement we, String valueToselect) {

		Select sltSelect = null;
		try {

			sltSelect = new Select(we);

			sltSelect.selectByValue(valueToselect);
			extTest.log(Status.INFO, "SuccessFully selected in Drop down");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "value is not select in  Drop down");
			throw e;
		}
	}

	public void dragAndDrop(WebElement source, WebElement destination) {
		// By using touch action class
		TouchAction action = null;
		try {
			action = new TouchAction(driver);

			action.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release()
					.perform();
			extTest.log(Status.INFO, "SuccessFully Drag and Drop Action Perform");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Due to exception Drag and Drop Action is not Perform");
			throw e;
		}
	}

	public String getText(WebElement we) {
		String innertext = null;
		try {
			innertext = we.getText();
			extTest.log(Status.INFO, "SuccessFully fetched inner text");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Due to Exception   inner text is not fetch");
			throw e;
		}
		return innertext;
	}

	public void verifyInnerTextValue(WebElement we, String expectedValue) {
		String actvalue = null;
		try {
			actvalue = getText(we);
			if (actvalue.equals(expectedValue)) {
				extTest.log(Status.PASS, "Actual value " + actvalue + " is matched Expected Value - " + expectedValue);
			}

		} catch (Exception e) {
			extTest.log(Status.FAIL, "Actual value " + actvalue + " is matched Expected Value - " + expectedValue);
			throw e;
		}
	}

}
