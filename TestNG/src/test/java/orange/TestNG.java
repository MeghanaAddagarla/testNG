package orange;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG extends PreandPost{
	
@Test(priority = 0)
public void login() {
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
	driver.findElement(By.id("btnLogin")).click();
}
	
	@Test(priority = 1)
	public void orange_Login() throws Throwable {
		Thread.sleep(2000);
		String Actual = driver.getTitle();
		String Expected = "dashboard";
	Assert.assertEquals(Actual, Expected, "Title is not matching");
		}
		
	@Test(priority = 2)
	public void add_PIM() throws Throwable {
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//b[normalize-space()='PIM']"))).perform();
		ac.moveToElement(driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"))).click().perform();
		driver.findElement(By.name("firstName")).sendKeys("Meghana");
		driver.findElement(By.name("middleName")).sendKeys("Meghana");
		driver.findElement(By.name("lastName")).sendKeys("Meghana");
		driver.findElement(By.id("btnSave")).click();
	}
	
	@Test (priority = 3)
	public void leave_click() throws Throwable {
		Thread.sleep(2000);
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//b[normalize-space()='Leave']"))).perform();
		ac.moveToElement(driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']"))).click().perform();
		String dob = "2022-Jul-1";
		String temp[]= dob.split("-");
		String dt = temp[2];
		String month = temp[1];
		String year = temp[0];
		driver.findElement(By.xpath("//input[@id='calFromDate']")).click();
		new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"))).selectByVisibleText("2022");
		new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"))).selectByVisibleText("Jul");
		WebElement webtable = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
		List<WebElement> rows, cols;
		rows = webtable.findElements(By.tagName("tr"));
		for(int i=1; i<rows.size(); i++) {
			cols = rows.get(i).findElements(By.tagName("td"));
			for (int j=0; j<cols.size(); j++) {
				String cell = cols.get(j).getText();
				if (cell.equals(dt)) {
					Thread.sleep(2000);
					cols.get(j).click();
				}
			}
		}
		
	}
	
	@Test (priority = 4)
	public void logout() {
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}
	
}
