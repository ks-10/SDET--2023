package selenium;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jira_test {

	public static void main(String[] args) throws InterruptedException {
		String ar[] = {"Devi Priya", "Hema Murugesan", "KrishnaBharathi", "Sathish Baskaran"};
		//Start the chrome in incognito browser
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		opt.addArguments("start-maximized");
		
		ChromeDriver driver = new ChromeDriver(opt);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//Login to JIRA
		driver.get("https://comparecheck.atlassian.net/jira/software/projects/CC/boards/1/backlog");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='username']"))));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("karupasami994@gmail.com");
		driver.findElement(By.id("login-submit")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='password']"))));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Kp_12101994");
		driver.findElement(By.id("login-submit")).click();
		
		//Validate the invalid  and valida Projects
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Projects']"))));
		driver.findElement(By.xpath("//span[text()='Projects']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='View all projects']"))));
		driver.findElement(By.xpath("//span[text()='View all projects']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@data-test-id='searchfield']"))));
		driver.findElement(By.xpath("//input[@data-test-id='searchfield']")).click();
		driver.findElement(By.xpath("//input[@data-test-id='searchfield']")).sendKeys("Test");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='No projects were found that match your search']"))));
		driver.findElement(By.xpath("//h4[text()='No projects were found that match your search']"));
		driver.findElement(By.xpath("//span[@aria-label='Clear']")).click();
		driver.findElement(By.xpath("//input[@data-test-id='searchfield']")).sendKeys("compare_Check");
		driver.findElement(By.xpath("//table//tr//td[2]//a")).click();
		wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//div[text()='Done']"))));
		
		//Get the list of all the tickets in JIRA board
		List<WebElement> card = driver.findElements(By.xpath("//div[contains(@data-test-id,'platform-card')]//a"));
		for (int i = 0; i < card.size()-1; i++) {
			System.out.println(card.get(i).getText());
		}
		//Open a new tab
		 ((JavascriptExecutor) driver).executeScript("window.open()");
	        Thread.sleep(2000);
	        
	        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    
	    //Create a Ticket in JIRA
		driver.get("https://comparecheck.atlassian.net/jira/software/projects/CC/boards/1/backlog");
		driver.findElement(By.xpath("//span[text()='Create']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//span[text()='Create issue']")))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@id, 'issue-type-select')]")));
		driver.findElement(By.xpath("//div[contains(@id, 'issue-type-select')]")).click();
		act.sendKeys("Task").sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.name("summary")).sendKeys("This is KP's Test");
		Random random = new Random();		
		int rand = random.nextInt(ar.length);
		driver.findElement(By.xpath("//div[contains(@class,'fabric-user-picker__indicators')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class,'fabric-user-picker__option')]//span//div//div//span[text()='Sathish Baskaran']"))));
		driver.findElement(By.xpath("//div[contains(@class,'fabric-user-picker__option')]//span//div//div//span[text()='Sathish Baskaran']")).click();
		driver.findElement(By.xpath("//div[text()='Select sprint']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[text()='CC Sprint 1'])[2]"))));
		driver.findElement(By.xpath("(//div[text()='CC Sprint 1'])[2]")).click();
		driver.findElement(By.xpath("(//span[text()='Create'])[2]")).click();
		Thread.sleep(3000);
		
		//Validate the notification and get the ticket id created
		WebElement notfication = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid = 'jira-issue-create.modal.create-form.success-flag']")));
		String ticket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid = 'jira-issue-create.modal.create-form.success-flag']"))).getText();
		String[] tckt = ticket.split("\"");
		String ticketID = tckt[1];
		
		
		//Checking if the ticket is created in the JIRA board
		driver.get("https://comparecheck.atlassian.net/jira/software/projects/CC/boards/1");
		driver.findElement(By.xpath("//span[contains(text(),'This is KP')]"));
		
		//Creating a ticket for a bug
		driver.findElement(By.xpath("//span[text()='Create']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//span[text()='Create issue']")))));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(("//div[contains(@id, 'issue-type-select')]"))))).click();
		act.sendKeys("Bug").perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[text()='Status']/following::span)[3]")))).click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.name("summary")).sendKeys("KP Bug");
		driver.findElement(By.xpath("//span[text()='Assign to me']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//label[text()='Sprint']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text() = 'Select sprint']"))).click();
		act.sendKeys("CC Sprint 1").perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text() = 'Select Issue']"))).click();
		act.sendKeys(ticketID).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("(//span[text()='Create'])[2]")).click();
		Thread.sleep(3000);
		
		driver.get("https://comparecheck.atlassian.net/jira/software/projects/CC/boards/1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[contains(text(),'Done')])/following::span[contains(text(),'KP Bug')]"));
		driver.quit();
		
		
		

		
		
	}
}
