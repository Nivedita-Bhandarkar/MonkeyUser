package Assessment.monkeyuser;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ComicsBook {

	@Test
	public void comicBook() {
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.monkeyuser.com/");
		String[] given_date= {"December 4, 2018","June 19, 2018","May 30, 2017"};
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.cssSelector("#list")).click();
		List<WebElement> date =driver.findElements(By.cssSelector(".et"));
		
		for(int i=0;i<date.size();i++) {
			List<String> al = Arrays.asList(given_date);
		String date_text =driver.findElements(By.cssSelector(".center .toc .et strong")).get(i).getText();
		if(al.contains(date_text)) {
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".image-title")));
			driver.findElements(By.cssSelector(".center .toc .et")).get(i).click();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
		}
		
		}
	}
}
