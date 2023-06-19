package selenium;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class goibibo {

	public static void main(String[] args) throws InterruptedException {
		

			ChromeDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Actions act = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			// From
			driver.get("https://www.goibibo.com/flights/air-MAA-GOI-20230609--1-0-0-E-D?");
			Thread.sleep(3000);
			act.moveByOffset(20, 20).perform();
			act.click().perform();
			
			Thread.sleep(6000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("javascript:window.scrollBy(450,650)");
	        Thread.sleep(2000);
	        js.executeScript("javascript:window.scrollBy(450,650)");
	        Thread.sleep(2000);
	        js.executeScript("javascript:window.scrollBy(450,650)");
	        Thread.sleep(2000);
	        js.executeScript("javascript:window.scrollBy(450,650)");
	        Thread.sleep(2000);
	        js.executeScript("javascript:window.scrollBy(450,650)");
	        
	       
			
	}

}
