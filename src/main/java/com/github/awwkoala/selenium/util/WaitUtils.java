package com.github.awwkoala.selenium.util;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

  private final WebDriverWait wait;
  private final FluentWait<WebDriver> fluentWait;
  private final int timeOutInSec = 5;
  private final int durationInSec = 30;
  private final int durationInMil = 100;

  public WaitUtils(WebDriver driver) {
    wait = new WebDriverWait(driver, timeOutInSec);
    fluentWait = new FluentWait<>(driver)
      .withTimeout(Duration.ofSeconds(durationInSec))
      .pollingEvery(Duration.ofMillis(durationInMil))
      .ignoring(NoSuchElementException.class);
  }

  public void waitUntilIsClickable(WebElement webElement) {
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }

  public void waitUntilIsVisible(WebElement webElement) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
  }

  public FluentWait<WebDriver> getFluentWait() {
    return fluentWait;
  }
}
