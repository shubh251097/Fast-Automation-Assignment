package com.fast.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://fast.com/");
		System.out.println(driver.getTitle());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		By speedValueLocator = By.id("speed-value");
		By speedUnitLocator = By.id("speed-units");
		String className;
		while (true) {
			WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
			WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));

			System.out.println(speedValueElement.getText() + " " + speedUnitElement.getText());

			className = speedValueElement.getAttribute("class");
			if (className != null && className.contains("succeeded")) {
				break;
			}

		}
		WebElement speedValueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedValueLocator));
		WebElement speedUnitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnitLocator));
		System.out.println("------------------------Final Speed------------------------");
		System.out.println(speedValueElement.getText() + " " + speedUnitElement.getText());

	}

}
