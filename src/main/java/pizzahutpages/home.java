package pizzahutpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.GenericUtilities;

public class home extends GenericUtilities {
	public static WebDriver driver;
	WebElement ele;
	public WebDriverWait wait;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")
	WebElement location;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div/button[3]/div[2]/div[1]")
	WebElement selectlocation;

	@FindBy(xpath = "/html/body/div[8]/div/div/div/div/div[1]/img")
	WebElement confirmlocation;

	@FindBy(xpath = "/html/body/div[8]/div/div/div[2]/div[2]/button")
	WebElement selecttime;

	public home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterLocation(String data) {
		enterText(location, data);
	}

	public void selectLocation() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(selectlocation));
		click(selectlocation);
	}

	public void confirmLocation() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(confirmlocation));
		click(confirmlocation);
	}

	public void selectTime() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(selecttime));
		click(selecttime);
	}

}
