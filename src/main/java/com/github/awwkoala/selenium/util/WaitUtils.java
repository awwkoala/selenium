package com.github.awwkoala.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

  private final WebDriverWait wait;

  public WaitUtils(WebDriver driver) {
    wait = new WebDriverWait(driver, 5);
  }

  public void waitUntilClickable(WebElement webElement) {
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }

  public void waitUntilVisible(WebElement webElement) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
  }

}
