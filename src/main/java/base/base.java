package base;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;

	public class base {
		
		public static WebDriver driver;
		public Properties prop;
		
		
		public WebDriver initializeDriver() throws IOException {
			prop = loadConfig();
			String browserName = prop.getProperty("browser");
			
			
			if(browserName.equals("chrome")) {
				driver = new ChromeDriver();
			}else if(browserName.equals("firefox")) {
				driver= new FirefoxDriver();
			}else if(browserName.equals("ie")) {
				driver = new InternetExplorerDriver();
			}
			else {
				System.out.println(browserName + "is not a valid browsername");
			} 
			driver.manage().window().maximize();
			return driver;
		}
		
		public Properties loadConfig() throws IOException {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
			return prop;
		}
		

	}

	


