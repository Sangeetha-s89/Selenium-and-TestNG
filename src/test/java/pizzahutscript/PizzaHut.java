package pizzahutscript;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Utils.GenericUtilities;
import base.base;
import pizzahutpages.*;

public class PizzaHut extends base {
	public static WebDriver driver;
	public GenericUtilities genUtil;
	public WebDriverWait wait;
	String text;

	private Logger log = LogManager.getLogger(PizzaHut.class.getName());

	@BeforeClass
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized.");
		genUtil = new GenericUtilities(driver);
	}

	@Test(priority = 1)
	public void locationSelection() throws InterruptedException {
		genUtil.navigateTo(prop.getProperty("url"));
		genUtil.windowsscrolldown();
		home hm = new home(driver);
		hm.enterLocation(prop.getProperty("location"));
		hm.selectLocation();
		hm.confirmLocation();
		try {
			hm.selectTime();
		} catch (Exception e) {
		} finally {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleContains("Deals"));
			text = driver.getCurrentUrl();
			System.out.println(text);
			assertTrue(text.contains("deals"), "Error User not in 'Deals' screen");
		}
	}

	@Test(priority = 2)
	public void addCart() {

		deals d = new deals(driver);
		d.clickPizza();
		d.addPizza();
		int count = d.itemCount();
		assertTrue(count == 1, "One item is expected");
		assertTrue(d.checkboxEnabled(), "Checkbox must be enabled");
		d.clickDrinksMenu();
		d.clickDrinks();
		d.clickCheckout();
		text = driver.getCurrentUrl();
		assertTrue(text.contains("checkout"), "Error User not in 'checkout' screen");

	}

	@Test(priority = 3)
	public void checkout() throws InterruptedException, IOException {
		orders o = new orders(driver);
		o.enterDetails(prop.getProperty("name"), prop.getProperty("phone"), prop.getProperty("email"));
		genUtil.windowsscrolldown();
		assertTrue(o.onlinePayment());
		o.selectCash();
		assertTrue(o.terms());
		o.selectGiftcard();
		o.applyGiftcard(prop.getProperty("giftcardnumber"), prop.getProperty("giftcardpin"));
		String errormessage = o.invalidGiftcard();
		assert (errormessage.equalsIgnoreCase("Invalid card number or pin combination"));
		o.clickCancel();
		text = driver.getCurrentUrl();
		assertTrue(text.contains("showGiftCardModalV2=true"), "Error User not in 'Deals' screen");

	}

	@AfterClass
	public void teardown() {
		driver.close();
		log.info("Driver is closed");
	}

}
