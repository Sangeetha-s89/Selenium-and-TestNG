package pizzahutpages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.GenericUtilities;

public class orders extends GenericUtilities {

	public static WebDriver driver;
	public WebDriverWait wait;

	@FindBy(id = "checkout__name")
	WebElement name;

	@FindBy(id = "checkout__phone")
	WebElement phone;

	@FindBy(id = "checkout__email")
	WebElement email;

	@FindBy(id = "payment-method--razorpay")
	WebElement online;

	@FindBy(id = "payment-method--cash")
	WebElement cash;

	@FindBy(id = "marketingOptIn")
	WebElement agreecheckbox;

	@FindBy(xpath = "//*[@id=\"checkout-form\"]/div[3]/button")
	WebElement giftcard;

	@FindBy(xpath = "/html/body/div[7]/div/div/div/div/div[2]/form/div[2]/input")
	WebElement giftcardnum;

	@FindBy(xpath = "/html/body/div[7]/div/div/div/div/div[2]/form/input")
	WebElement giftcardpin;

	@FindBy(xpath = "/html/body/div[7]/div/div/div/div/div[2]/form/div[4]/button[1]")
	WebElement giftcardclick;

	@FindBy(xpath = "/html/body/div[7]/div/div/div/div/div[3]/span")
	WebElement errormessage;

	@FindBy(xpath = "/html/body/div[7]/div/div/div/div/div[4]/button[2]")
	WebElement cancel;

	public orders(WebDriver driver) {
		super(driver);
		orders.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterDetails(String username, String userphone, String useremail) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(name));

		enterText(name, username);
		enterText(phone, userphone);
		enterText(email, useremail);

	}

	public boolean onlinePayment() {
		return online.isSelected();

	}

	public void selectCash() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", cash);
		selectradio(cash);
		
	}

	public boolean terms() {
		return agreecheckbox.isSelected();

	}

	public void selectGiftcard() {
		click(giftcard);

	}

	public void applyGiftcard(String num, String pin) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(giftcardnum));

		enterText(giftcardnum, num);
		enterText(giftcardpin, pin);
		click(giftcardclick);

	}

	public String invalidGiftcard() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(errormessage));
		String errormsg = errormessage.getText();
		return errormsg;

	}

	public void clickCancel() {
		click(cancel);

	}

}
