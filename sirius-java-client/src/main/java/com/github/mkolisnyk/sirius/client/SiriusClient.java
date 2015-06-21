package com.github.mkolisnyk.sirius.client;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SiriusClient {

	private WebDriver driver;
	private Map<Platform, Class<?>> driverMap = new HashMap<Platform, Class<?>>() {
		private static final long serialVersionUID = 1L;

		{
			put(Platform.REMOTE, RemoteWebDriver.class );
			put(Platform.HTMLUNIT, HtmlUnitDriver.class );
			put(Platform.IE, InternetExplorerDriver.class );
			put(Platform.FIREFOX, FirefoxDriver.class );
			put(Platform.CHROME, ChromeDriver.class );
			put(Platform.SAFARI, SafariDriver.class );
			put(Platform.OPERA, OperaDriver.class );
			put(Platform.ANDROID_NATIVE, AndroidDriver.class );
			put(Platform.IOS_NATIVE, IOSDriver.class );
			put(Platform.ANDROID_WEB, AndroidDriver.class );
			put(Platform.IOS_WEB, IOSDriver.class );
			put(Platform.WIN_APP, RemoteWebDriver.class );
			put(Platform.WIN_PHONE, RemoteWebDriver.class );
		}
	};
	public SiriusClient() throws Exception {
		this.driver = (WebDriver) driverMap.get(Platform.REMOTE).getConstructor().newInstance();
	}
	public SiriusClient(WebDriver customDriver) {
		this.driver = customDriver;
	}
	public SiriusClient(String platform) throws Exception {
		super();
		for (Platform value : Platform.values()) {
			if (value.name().equalsIgnoreCase(platform.trim())) {
				this.driver = (WebDriver) driverMap.get(value).getConstructor().newInstance();
				return;
			}
		}
	}
	public SiriusClient(String platform, URL url, Capabilities capabilities) throws Exception {
		for (Platform value : Platform.values()) {
			if (value.name().equalsIgnoreCase(platform.trim())) {
				Constructor<?> constructor = null;
				try {
					constructor = driverMap.get(value).getConstructor(URL.class, Capabilities.class);
				} catch (NoSuchMethodException e) {
					;
				}
				if (constructor == null) {
					constructor = driverMap.get(value).getConstructor(Capabilities.class);
					this.driver = (WebDriver) constructor.newInstance(capabilities);
				} else {
					this.driver = (WebDriver) constructor.newInstance(url, capabilities);
				}
				return;
			}
		}
	}
	public final WebDriver getDriver() {
		return driver;
	}
}
