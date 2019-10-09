package com.ClassMateDemo.LearnSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ProfileImageUpload {
	//WebDriver is defined
	WebDriver driver;	

	@Test(priority = 1)
	public void test_setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "driver\\Chromedriver.exe");
		driver= new ChromeDriver();	
		driver.get("https://www.edureka.co/");
		Thread.sleep(1000);
 }
		
	@Test(priority = 2)
	public void test() throws Exception {
		driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/a[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("si_popup_email")).sendKeys("vijay.byrappa@gmail.com");
		driver.findElement(By.id("si_popup_passwd")).sendKeys("P@ssword123");
		driver.findElement(
				By.xpath("(//*[@id=\"new_sign_up_mode\"]//button[contains(@class,'clik_btn_log btn-block')])[3]"))
				.click();
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//*[@id=\"footauto\"]//img[contains(@class,'user_image')]")).click();
		 //driver.findElement(By.xpath("//*[@id='footauto']//img[contains(@class,'user_image')]")).click();
		 driver.findElement(By.xpath("//*[@id='footauto']//span[contains(@class,'user_name')]")).click();
		driver.findElement(By.linkText("My Profile")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#personal_details > i")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#collapseOne > div > div > div.profile-photo-section > a > i")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("custom-input")).click();
		Thread.sleep(10000);
		Runtime.getRuntime().exec("FileUploader.exe");
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id='onboarding']/div/div[1]/div[2]/div[2]/app-onboarding-personal-details/div[2]/div/div/div[2]/div[2]/button"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='btn btn-default pull-right verify-continue-btn']"))
		.click();
			}
	
	@AfterTest
	public void Aftertest() throws Exception {
		Thread.sleep(5000);	
		driver.close();
	}
}