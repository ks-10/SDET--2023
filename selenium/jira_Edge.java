package selenium;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jira_Edge {
	public static void main(String[] args) throws InterruptedException, AWTException {
		String ar[] = {"Devi Priya", "Hema Murugesan", "KrishnaBharathi", "Sathish Baskaran"};
		//Start the chrome in incognito browser
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("incognito");
		opt.addArguments("start-maximized");
		
		EdgeDriver driver = new EdgeDriver(opt);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//Login to JIRA
		driver.get("https://comparecheck.atlassian.net/jira/software/projects/CC/boards/1");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='username']"))));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("karupasami994@gmail.com");
		driver.findElement(By.id("login-submit")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='password']"))));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Kp_12101994");
		driver.findElement(By.id("login-submit")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(" //div[text()='In Progress']"))));
		
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
		assertTrue(notfication.isDisplayed(), "Ticket is not created/ notification not arrived");
		String ticket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid = 'jira-issue-create.modal.create-form.success-flag']"))).getText();
		String[] tckt = ticket.split("\"");
		String ticketID = tckt[1];
		
		
		//Checking if the ticket is created in the JIRA board
		driver.get("https://comparecheck.atlassian.net/jira/software/projects/CC/boards/1");
		driver.findElement(By.xpath("//span[contains(text(),'This is KP')]"));
		Thread.sleep(2000);
		WebElement drag = driver.findElement(By.xpath("//span[contains(text(),'This is KP')]/../../../.."));
		WebElement drag4 = driver.findElement(By.xpath("//span[text()='Sprint 1 First Issue']"));
		WebElement drag2= driver.findElement(By.xpath("(//div[@class='__board-test-hook__column sc-1ef3ied-1 cgwwdw j4whmj-0 gftcoT'])[2]"));
		
		
		int x = drag2.getLocation().getX();
		int y = drag2.getLocation().getY();
		
		Thread.sleep(5000);
		act.clickAndHold(driver.findElement(By.xpath("(//div[contains(@class, 'ixgNBr')])[1]"))).build().perform();
		Thread.sleep(2500);
		act.moveToElement(driver.findElement(By.xpath("(//div[contains(@class, 'jwPAny')])[2]"))).build().perform();
		Thread.sleep(2500);
		act.release().build().perform();
		Thread.sleep(5000);
		//act.dragAndDrop(driver.findElement(By.xpath("(//div[@data-test-id='platform-card.ui.card.focus-container']//div)[1]")), driver.findElement(By.xpath("(//div[@data-testid='software-board.board-container.board.virtual-board.fast-virtual-list.fast-virtual-list-wrapper'])[2]"))).perform();
		//act.moveToElement(drag).pause(2000).clickAndHold().pause(2000).dragAndDrop(drag,drag2).release().build().perform();
//		
//		act.moveToElement(drag).pause(2000).perform();
//		act.clickAndHold(drag).perform();
//		act.pause(Duration.ofSeconds(3)).perform();
//		act.dragAndDrop(drag,drag2).perform();
//		act.pause(Duration.ofSeconds(3)).perform();
//		act.release(drag2).perform();
		
		driver.findElement(By.xpath("(//div[@data-test-id='platform-card.ui.card.focus-container']//div)[1]")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[text()='Description']"))));
		driver.findElement(By.xpath("//span[text()='Add a child issue']")).click();
		driver.findElement(By.id("childIssuesPanel")).sendKeys("KP sub task");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//span[text()='Create'])[2]")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("childIssuesPanel")).sendKeys("KP sub task");
//		driver.findElement(By.xpath("(//span[text()='Create'])[2]")).click();
		Thread.sleep(4000);
		//wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("(//a[@data-test-id='issue.issue-view.views.common.issue-line-card.issue-line-card-view.key'])[last()]"))));
		driver.findElement(By.xpath("(//a[@data-test-id='issue.issue-view.views.common.issue-line-card.issue-line-card-view.key'])[last()]")).click();
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='KP sub task']"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Add a description...']) | // span[@data-testid='placeholder-test-id']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'ua-chrome ProseMirror')]//p[1]")).click();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(.,'Press Ctrl + / to learn time-saving keyboard shortcuts.')]"))));
		driver.findElement(By.xpath("//div[contains(@class,'ua-chrome ProseMirror')]//p[1]")).sendKeys("This is subtask Description");
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		
		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", By.xpath("//span[text()='Unassigned']"));
		driver.findElement(By.xpath("//span[text()='Unassigned']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class,'fabric-user-picker__option')]//span//div//div//span[text()='Sathish Baskaran']"))));
		driver.findElement(By.xpath("//div[contains(@class,'fabric-user-picker__option')]//span//div//div//span[text()='Sathish Baskaran']")).click();
		
		// ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", By.xpath("(//h2[text()='Labels']/following::span[text()='None'] )[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//h2[text()='Labels']/following::span[text()='None'] )[1]")))).click();
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@data-testid,'issue.views.field.select.common.select-inline-edit.labels.field-inline-edit-state-less--container')]//span/following::div[text()='test']\""))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@data-testid,'issue.views.field.select.common.select-inline-edit.labels.field-inline-edit-state-less--container')]//span/following::div[text()='test']")).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("react-select-3-option-1-0"))));
		//driver.findElement(By.id("react-select-3-option-1-0")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Add a comment…']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(.,'Type @ to mention and notify someone.')]"))));
		driver.findElement(By.xpath("//p[contains(.,'Type @ to mention and notify someone.')]")).sendKeys("This is KP comment");
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Karupasami']/following::p[text()='This is KP comment']"))));
		
		    StringSelection str = new StringSelection("C:\\Users\\DELL\\Downloads\\Testdoc.txt");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str,null);

		    WebElement element = driver.findElement(By.xpath("//span[@data-test-id='issue.issue-view.views.issue-base.foundation.quick-add.quick-add-item.add-attachment']"));
		    element.click();
		    Robot robot = null;
	        try {
	            robot = new Robot();
	        } catch (AWTException e) {
	            e.printStackTrace();
	        }
		    robot.delay(250);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.delay(150);
	        robot.keyRelease(KeyEvent.VK_ENTER);
		
		//driver.findElement(By.xpath("//span[@data-test-id='issue.issue-view.views.issue-base.foundation.quick-add.quick-add-item.add-attachment']")).sendKeys("C:\\Users\\DELL\\Downloads\\Testdoc.txt");
	        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Testdoc.txt']"))));
	        
	        
	        driver.get("https://comparecheck.atlassian.net/jira/software/projects/CC/boards/1");
	        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(" //div[text()='In Progress']"))));
	     
	        WebElement parentTask = driver.findElement(By.xpath("(//div[@data-test-id='platform-card.ui.card.focus-container']//div)[1]"));
	        Thread.sleep(3000);
	        act.moveToElement(parentTask).perform();
	        act.pause(Duration.ofSeconds(3)).perform();
	        act.contextClick(parentTask).perform();
	        act.pause(Duration.ofSeconds(3)).perform();
	        act.click(driver.findElement(By.xpath("//button[@data-key='delete']"))).perform();
	        
	        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Delete']"))));
	        driver.findElement(By.xpath("//span[text()='Delete']")).click();

		Thread.sleep(3000);
		driver.quit();
		
		
	}
}
