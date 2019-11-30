package selenium4.selenium4;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class HandlingStaleElement {
	public void handlingException() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "browser_exe"
				+ File.separator + "chromedriver_latest.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		System.out.println("Driver => " + driver);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		new WebDriverWait(driver, Duration.ofDays(1));
		WebElement textBox = driver.findElement(By.name("q"));
		System.out.println(textBox.toString());
		driver.navigate().refresh();
		try {
		textBox.sendKeys("Selenium");
		}catch (StaleElementReferenceException e) {
		//	WebElement refreshedElement = StaleElementUtils.refreshElement(driver,textBox);
			WebElement refreshedElement = StaleElementUtils1.getElement(driver, By.name("q"));
			refreshedElement.sendKeys("Its Working...!!");
		}
		System.out.println("Done");
		
		
		
	}
}
