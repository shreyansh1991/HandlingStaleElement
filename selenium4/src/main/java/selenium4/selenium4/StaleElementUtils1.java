package selenium4.selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class StaleElementUtils1 {
	public static WebElement getElement(WebDriver driver,final By by)
	{
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(java.time.Duration.ofSeconds(1));
		wait.withTimeout(java.time.Duration.ofSeconds(20));
		wait.ignoring(StaleElementReferenceException.class);

			WebElement someElement = wait.until(new Function<WebDriver, WebElement>() {
			    public WebElement apply(WebDriver driver) {
			        return driver.findElement(by);
			    }
			});
			return someElement;	
	}
}

