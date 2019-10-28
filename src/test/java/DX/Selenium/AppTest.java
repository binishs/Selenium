package DX.Selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AppTest {
	
	@Test
	public void test(){
	String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",projectPath+"\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
    driver.get("http://the-internet.herokuapp.com/");
    
    driver.findElement(By.xpath("//*[text()='JavaScript Alerts']")).click();
    driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
    driver.switchTo().alert().accept();
    
    Assert.assertEquals(driver.findElement(By.xpath("//*[text()='You clicked: Ok']")).getText(), "You clicked: Ok");

    driver.close();
   
}
}