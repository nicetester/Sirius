/**
 * 
 */
package org.sirius.server.web;

import javax.jws.WebService;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opera.core.systems.OperaDriver;

/**
 * @author Myk Kolisnyk
 * 
 */
@WebService
public class WebCore extends WebHelper {

	/**
	 * 
	 */
	public final String IE = "ie";
	/**
	 * 
	 */
	public final String FIREFOX = "firefox";
	/**
	 * 
	 */
	public final String FIREFOX_UNSECURED = "chrome";
	/**
	 * 
	 */
	public final String CHROME = "googlechrome";
	/**
	 * 
	 */
	public final String OPERA = "opera";
	/**
	 * 
	 */
	public final String SAFARI = "safari";
	/**
	 * 
	 */
	public final String HTMLUNIT = "htmlunit";

	/**
	 * 
	 */
	public WebCore() {
	}

	/**
	 * .
	 * @param token .
	 */
	public void back(String token) {
		driver(token).navigate().back();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public void clear(String token, String startFrom, String locator) {
		getElement(token, startFrom, locator).clear();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public void click(String token, String startFrom, String locator) {
		getElement(token, startFrom, locator).click();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 * @param timeout .
	 * @return .
	 */
	public boolean exists(String token,String startFrom,String locator,int timeout){
		WebDriverWait wait = new WebDriverWait(driver(token), timeout);
		if(startFrom != null){
			wait.until(ExpectedConditions.presenceOfElementLocated( toLocator(startFrom) ));
		}
		wait.until(ExpectedConditions.presenceOfElementLocated( toLocator(locator) ));
		try {
			return getElement(token, startFrom, locator) != null;
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * .
	 * @param token .
	 */
	public void forward(String token) {
		driver(token).navigate().forward();
	}
	
	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 * @param attribute .
	 * @return .
	 */
	public String getAttribute(String token, String startFrom, String locator,
			String attribute) {
		return getElement(token, startFrom, locator).getAttribute(attribute);
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 * @param value .
	 * @return .
	 */
	public String getCssValue(String token, String startFrom, String locator,
			String value) {
		return getElement(token, startFrom, locator).getCssValue(value);
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public Point getLocation(String token, String startFrom, String locator) {
		return getElement(token, startFrom, locator).getLocation();
	}

	/**
	 * .
	 * @param token .
	 * @return .
	 */
	public String getPageSource(String token) {
		return driver(token).getPageSource();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public Dimension getSize(String token, String startFrom, String locator) {
		return getElement(token, startFrom, locator).getSize();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public String getTagName(String token, String startFrom, String locator) {
		return getElement(token, startFrom, locator).getTagName();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public String getText(String token, String startFrom, String locator) {
		return getElement(token, startFrom, locator).getText();
	}

	/**
	 * .
	 * @param token .
	 * @return .
	 */
	public String getTitle(String token) {
		return driver(token).getTitle();
	}

	/**
	 * .
	 * @param token .
	 * @return .
	 */
	public String getURL(String token) {
		return driver(token).getCurrentUrl();
	}

	/**
	 * .
	 * @param token .
	 * @return .
	 */
	public String getWindowHandle(String token) {
		return driver(token).getWindowHandle();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public boolean isDisplayed(String token, String startFrom, String locator) {
		return getElement(token, startFrom, locator).isDisplayed();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public boolean isEnabled(String token, String startFrom, String locator) {
		return getElement(token, startFrom, locator).isEnabled();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public boolean isSelected(String token, String startFrom, String locator) {
		return getElement(token, startFrom, locator).isSelected();
	}

	/**
	 * .
	 * @param token .
	 * @param url .
	 */
	public void open(String token, String url) {
		driver(token).navigate().to(url);
	}

	/**
	 * .
	 * @param token .
	 */
	public void refresh(String token) {
		driver(token).navigate().refresh();
	}

	/**
	 * .
	 * @param token .
	 */
	public void selectAlert(String token) {
		driver(token).switchTo().alert();
	}

	/**
	 * .
	 * @param token .
	 */
	public void selectDefaultContent(String token) {
		driver(token).switchTo().defaultContent();
	}

	/**
	 * .
	 * @param token .
	 * @param index .
	 */
	public void selectFrameByIndex(String token, int index) {
		driver(token).switchTo().frame(index);
	}

	/**
	 * .
	 * @param token .
	 * @param name .
	 */
	public void selectFrameByName(String token, String name) {
		driver(token).switchTo().frame(name);
	}

	/**
	 * .
	 * @param token .
	 * @param name .
	 */
	public void selectWindow(String token, String name) {
		driver(token).switchTo().window(name);
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public void sendKeys(String token, String startFrom, String locator,
			String text) {
		getElement(token, startFrom, locator).sendKeys(text);
	}

	/**
	 * .
	 * @param browser .
	 * @return .
	 */
	public String start(String browser) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase(IE)) {
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase(FIREFOX)) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase(CHROME)) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase(HTMLUNIT)) {
			driver = new HtmlUnitDriver();
		} else if(browser.equalsIgnoreCase(OPERA)){
			driver = new OperaDriver();
		} else if(browser.equalsIgnoreCase(SAFARI)){
			driver = new SafariDriver();
		}
		

		if (driver != null) {
			DriverMap.drivers.put(driver.toString(), driver);
			return driver.toString();
		}

		return null;
	}

	/**
	 * .
	 * @param token .
	 */
	public void stop(String token) {
		driver(token).close();
		DriverMap.drivers.remove(token);
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 */
	public void submit(String token, String startFrom, String locator) {
		getElement(token, startFrom, locator).submit();
	}
	
	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 * @param timeout .
	 * @return .
	 */
	public boolean waitForElementToAppear(String token, String startFrom, String locator,int timeout){
		WebDriverWait wait = new WebDriverWait(driver(token), timeout);
		WebElement element = getElement(token, startFrom, locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element != null && element.isDisplayed();
	}

	/**
	 * .
	 * @param token .
	 * @param startFrom .
	 * @param locator .
	 * @param timeout .
	 * @return .
	 */
	public boolean waitForElementToDisappear(String token, String startFrom, String locator,int timeout){
		WebDriverWait wait = new WebDriverWait(driver(token), timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toLocator(locator)));
		WebElement element = getElement(token, startFrom, locator);
		return element == null || !element.isDisplayed();
	}
}
