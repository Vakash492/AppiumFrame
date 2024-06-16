package com.eva.androidutil;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SetCapabilities {

	AndroidDriver driver;

	public AndroidDriver set_Capabilities() {

DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("deviceName", "AndroidEmulator");
		cap.setCapability("udid", "emulator-5554");
//		cap.setCapability("deviceName", "Huawei BKL L-09");
//		cap.setCapability("udid", "DXEDU17C18003178");
		cap.setCapability("noReset", "true");
//		cap.setCapability("app", "C:\\Users\\Dell\\Desktop\\apk\\Dummy-1.0.apk");
		cap.setCapability("app", "C:\\Users\\Dell\\Desktop\\apk\\net-kilimall-shop.apk");
//		cap.setCapability("appPackage", "com.techsquare.dummy");
//  	cap.setCapability("appActivity", "com.techsquare.dummy.SplashActivity");
		
		URL url=null;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		driver = new AndroidDriver(url,cap);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}

}
