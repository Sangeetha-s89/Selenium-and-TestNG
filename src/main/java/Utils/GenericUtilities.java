package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GenericUtilities {

	public static WebDriver driver;

	public GenericUtilities(WebDriver driver) {
		GenericUtilities.driver = driver;
	}

	public void click(WebElement ele) {
		ele.click();
	}

	public void enterText(WebElement inputfield, String value) {
		inputfield.sendKeys(value);
	}

	public void navigateTo(String URL) {
		driver.get(URL);
	}

	public void selectfromDropDown(WebElement drpdown, int value) {
		Select dd = new Select(drpdown);
		dd.selectByIndex(value);
	}

	public void windowsscrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
	public void selectradio(WebElement select) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", select);
		
	}

}
