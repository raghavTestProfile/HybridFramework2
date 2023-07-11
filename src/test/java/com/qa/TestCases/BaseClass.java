package com.qa.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qa.Utilities.Utils;

public class BaseClass extends Utils {

	public static WebDriver driver;

	public static Logger logger;

	@BeforeMethod
	public void setup() {

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		logger = LogManager.getLogger("Z99Project");

		driver.get(prop.getProperty("url"));

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();
	}

	public static double generateRandomAccount() {

		double d = Math.random();
		return d;

	}

}
