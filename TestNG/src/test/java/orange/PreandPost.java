package orange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class PreandPost {
	public static WebDriver driver;
	@Parameters ({"Browser"})
	
@BeforeClass
public void setUp(String brw) {
	switch (brw) {
	case "chrome":
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		break;

		case "firefox":
			driver = new FirefoxDriver();
			break;
		
	default:
		Reporter.log("Browser value not matching");
		break;
	}
	}
		
		
@AfterClass
public void teardown() {
	driver.close();
}

}
