package selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMytrip {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// From
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);
		act.moveByOffset(20, 20).perform();
		act.click().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[@for='fromCity']"))));
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']//span[1]")).click();
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();

		// To
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Goa");
		driver.findElement(By.xpath("//p[text()='Goa - Dabolim Airport, India']")).click();

		// Date
		driver.findElement(By.xpath("//p[text()='8']")).click();
		driver.findElement(By.xpath("//p[text()='15']")).click();

		// submit
		driver.findElement(By.xpath("//p[@data-cy='submit']//a[1]")).click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("fareLockInfoContainer"))));
		driver.findElement(By.xpath("//div[@class='commonOverlay ']//span")).click();

		// Selecting Left pane
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(
				By.xpath("(//div[@class='paneView'])[1]//div[@class='makeFlex priceInfo gap-x-10 ']//p"))));
		Thread.sleep(3000);
		List<WebElement> price = driver
				.findElements(By.xpath("(//div[@class='paneView'])[1]//div[@class='makeFlex priceInfo gap-x-10 ']//p"));
		List<Integer> newPrice = new ArrayList<>();

		for (WebElement pr : price) {

			String str = pr.getText();
			String priceOnly = str.replaceAll("[^0-9]", "");
			StringBuilder sb = new StringBuilder(priceOnly);

			if (!priceOnly.isBlank() || !priceOnly.isEmpty()) {
				newPrice.add(Integer.parseInt(sb.toString()));
			}
		}

		Collections.sort(newPrice);
		System.out.println(newPrice.get(newPrice.size() - 1));
		StringBuilder sb1 = new StringBuilder(newPrice.get(newPrice.size() - 1).toString());
		sb1.insert(sb1.length() - 3, ',');
		System.out.println(sb1.toString());
		driver.findElement(By.xpath("//p[contains(text(),'" + sb1 + "')]/following::input")).click();

		// Selecting Right pane
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(
				By.xpath("(//div[@class='paneView'])[2]//div[@class='makeFlex priceInfo gap-x-10 ']//p"))));
		Thread.sleep(3000);
		List<WebElement> price1 = driver
				.findElements(By.xpath("(//div[@class='paneView'])[2]//div[@class='makeFlex priceInfo gap-x-10 ']//p"));
		List<Integer> newPrice1 = new ArrayList<>();

		for (WebElement pr : price1) {

			String str = pr.getText();
			String priceOnly = str.replaceAll("[^0-9]", "");
			StringBuilder sb = new StringBuilder(priceOnly);

			if (!priceOnly.isBlank() || !priceOnly.isEmpty()) {

				newPrice1.add(Integer.parseInt(sb.toString()));
			}
		}

		Collections.sort(newPrice1);
		StringBuilder sb2 = new StringBuilder(newPrice1.get(newPrice1.size() - 1).toString());
		sb2.insert(sb2.length() - 3, ',');
		driver.findElement(By.xpath("//p[contains(text(),'" + sb2 + "')]/following::input")).click();

		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='You have ']"))));
		String total = driver.findElement(By.xpath("(//div[@class='multifareFooter']//p)[1]")).getText();

		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		String total1 = driver.findElement(By.xpath("//div[@class='fareFooter']//p//span[2]")).getText();

		System.out.println(total);
		System.out.println(total1);
		if (total.equals(total1)) {
			System.out.println("Price is matching");
		} else {
			System.out.println("Price is not matching");
		}

		driver.quit();

	}

}
