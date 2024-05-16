package pizzahutpages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.GenericUtilities;

public class deals extends GenericUtilities {

	public static WebDriver driver;
	public WebDriverWait wait;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[2]")
	WebElement pizza;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div[1]/a[1]/div[3]/div/button")
	WebElement addpizza;

	@FindBy(xpath = "//*[@id=\"basket\"]/div[@class='mb-20 px-20']")
	List<WebElement> verifyitemcount;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a")
	WebElement checkout;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[7]")
	WebElement drinksmenu;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[3]/div[3]/div/button")
	WebElement drink1;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[4]/div[3]/div/button")
	WebElement drink2;

	public deals(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickPizza() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(pizza));
		click(pizza);

	}

	public void addPizza() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(addpizza));
		click(addpizza);
	}

	public int itemCount() {

		int count = verifyitemcount.size();
		return count;
	}

	public boolean checkboxEnabled() {
		return checkout.isEnabled();

	}

	public void clickDrinksMenu() {

		click(drinksmenu);
	}

	public void clickDrinks() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(drink1));
		click(drink1);
		click(drink2);

	}

	public void clickCheckout() {

		click(checkout);

	}

}
