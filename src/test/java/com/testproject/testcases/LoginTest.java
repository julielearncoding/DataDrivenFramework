package com.testproject.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.testproject.base.TestBase;

public class LoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {
	
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
	}
}
