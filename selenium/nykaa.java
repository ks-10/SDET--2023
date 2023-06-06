package selenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class nykaa {

	public static void main(String[] args) throws InterruptedException {
		

			ChromeDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Actions act = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			// From
			driver.get("https://www.nykaa.com/");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='brands']")));
			act.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).build().perform();
			driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"][1]")).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='All Products']"))));

			String title = driver.getTitle();
			System.out.println(title.contains("L'Oreal Paris"));
			
			driver.findElement(By.xpath("//span[contains(text(),'Sort')]/..")).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='customer top rated']"))));
			driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Category']")))).click();
			driver.findElement(By.xpath("//span[text()='Hair']")).click();
			driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
			driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
			
			driver.findElement(By.xpath("//span[text()='Concern']")).click();
			driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
			String filterApplied =  driver.findElement(By.xpath("//span[text()='Filters Applied']/following::span")).getText();
			assertEquals(filterApplied, "Shampoo");
			
			driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Add to Bag']"))));
			driver.findElement(By.xpath("//span[text()='180ml']")).click();
			
			String text = driver.findElement(By.xpath("(//span[text()=\"MRP:\"]/following::span)[1]")).getText();
			System.out.println("Price: " +text);
			
			driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
			driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
			
			driver.switchTo().frame(0);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Price Details']"))));
			String text1 = driver.findElement(By.xpath("(//span[@color='#001325'])[2]")).getText();
			System.out.println("Grand Total: " +text1);
			
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text() = 'Proceed']"))));
			act.moveToElement(driver.findElement(By.xpath("//span[text() = 'Proceed']")), 10, 20).click(driver.findElement(By.xpath("//span[text() = 'Proceed']"))).build().perform();
			//act.click(driver.findElement(By.xpath("//span[text() = 'Proceed']"))).build().perform();
			
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Account']"))));
			driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
			
			act.moveByOffset(20, 20).perform();
			act.click().perform();
			String text2 = driver.findElement(By.xpath("//p[text()='Price Details']/following::p")).getText();
			assertEquals(text1, text2);
			
			
			driver.quit();
			
			
			
			
			
			
			
			
			
			
			
			
			
//			act.moveByOffset(20, 20).perform();
//			act.click().perform();
			
	
	        
	       
			
	}

}
