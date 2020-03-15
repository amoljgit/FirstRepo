package com.mvn.demo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class NewTest {

	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("file:///D:/Offline%20Website/index.html");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@Test
	public void TestLogin() throws InterruptedException {

		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		
	}

	@Test
	public void TestGettitle() {
		String title = driver.getTitle();
		try {
			Assert.assertEquals("JavaByKiran | Dashboard", title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Page title is not matching, test case failed.");
		}

	}
	
	@AfterSuite
	public void TearDown() {
		
		driver.findElement(By.linkText("LOGOUT"));
		driver.close();
		driver.quit();
	}

}
