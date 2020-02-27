package com.testproject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	/*
	 * INITIALIZING... WebDriver Properties Logs ExtentReport DB Excel Mail
	 * ReportNG, ExtentReport
	 * Jenkins
	 */

	public static WebDriver driver;
	public static String projectDir = System.getProperty("user.dir");
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	/* Initialize everything */
	@BeforeSuite
	public void setUp() {
		if (driver == null) {

			try {
				fis = new FileInputStream(
						projectDir + "//src//test//resources//com//testproject//properties//Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						projectDir + "//src//test//resources//com//testproject//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						projectDir + "\\src\\test\\resources\\com\\testproject\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						projectDir + "\\src\\test\\resources\\com\\testproject\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
		}

	}

	/* Quit/Close everything */
	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}
}
