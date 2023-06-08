package selenium;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		

			ChromeDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Actions act = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

			//Load the URL https://www.amazon.in/
			driver.get("https://www.amazon.in/");
			
			//search as oneplus 9 pro 
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("field-keywords")));
			driver.findElement(By.name("field-keywords")).sendKeys("one plus 9 pro", Keys.ENTER);
			
			//Get the price of the first product
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Results']"))));
			String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
			
			//Print the number of customer ratings for the first displayed product
			String rating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
			System.out.println("Customer rating :" +rating);
			
			// Click the first text link of the first image
			driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[1]")).click();
			
			//Take a screen shot of the product displayed
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Back to results")));

			File srcFile =   driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("./target/screenshots/image1.png"));
			
			// Click 'Add to Cart' button
			driver.findElement(By.id("add-to-cart-button")).click();
			
			//Get the cart subtotal and verify if it is correct.
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//b[text()='Cart subtotal']")));
			String subTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
			
			price = price.replaceAll("[^0-9]", "");
			subTotal = subTotal.replaceAll("[^0-9]", "").substring(0, subTotal.length()-5);
			System.out.println(price+" = " +subTotal);
			assertEquals(price, subTotal);
			
			//close the browser
			driver.quit();

	       
			
	}

}
