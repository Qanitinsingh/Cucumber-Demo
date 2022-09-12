package tdd.approach;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrame {

	public static WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test(priority = 0)
	public void singleFrame() throws InterruptedException {

		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Test");
		driver.switchTo().defaultContent();
	}

	@Test(priority = 1)
	public void innerFrame() throws InterruptedException {
		driver.findElement(By.cssSelector("a[href='#Multiple']")).click();
		Thread.sleep(2000);

		WebElement f1=driver.findElement(By.xpath(".//iframe[@src='MultipleFrames.html']"));
		WebElement f2=driver.findElement(By.xpath("//iframe[normalize-space()='<p>Your browser does not support iframes.</p>']"));
		driver.switchTo().frame(f1);
		Thread.sleep(2000);
		driver.switchTo().frame(f2);
		WebElement ele=driver.findElement(By.cssSelector("//This element is in iframe - input[type='text']"));
		Thread.sleep(2000);
		ele.sendKeys("Test Inner");
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
		System.out.println("Execution is completed");
	}

}
