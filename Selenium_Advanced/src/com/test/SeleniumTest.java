package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

	public static void main(String[] args) {
		System.out.println("Hello Selenium");
		
		//Register a user on mercurytour site
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mrityunjay\\selenium_learn\\chromedriver.exe");
		//Launch a browser
		ChromeDriver driver=new ChromeDriver();
		
		//navigate to site
		driver.get("http://newtours.demoaut.com/");
		
		//registerUser(driver);
		login(driver);
		
		
	}
	
	public static void login(WebDriver driver) {
		driver.findElement(By.name("userName")).sendKeys("selenium");
		driver.findElement(By.name("password")).sendKeys("selenium");
		//Changed the code to call submit method for login
		driver.findElement(By.name("login")).submit();
	}
	
	public static void registerUser(WebDriver driver) {

		//Click on Register Link
		//driver.findElement(By.xpath(".//a[text()='REGISTER']")).click();
		//driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.partialLinkText("REGISTER")).click();
		CharSequence name=new String("XYZ");
		//Type First Name
		driver.findElement(By.name("firstName")).sendKeys(name);
		
		driver.findElement(By.xpath(".//input[@name='city']")).sendKeys("Hyd");
		
		WebElement country=driver.findElement(By.name("country"));
		
		Select select=new Select(country);
		select.selectByVisibleText("INDIA");
		
		driver.findElement(By.id("email")).sendKeys("selenium");
		driver.findElement(By.name("password")).sendKeys("selenium");
		driver.findElement(By.name("confirmPassword")).sendKeys("selenium");
		
		driver.findElement(By.name("register")).click();
		
		String text=driver.findElement(By.partialLinkText("Note: Your user name is")).getText();
		System.out.println(text);
		if(text.contains("selenium")) {
			System.out.println("Selenium user got created");
		}else {
			System.out.println("Some error occured in user registration");
		}
	}

}
