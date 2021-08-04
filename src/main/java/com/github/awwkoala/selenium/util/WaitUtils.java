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
  private final int timeOutInSeconds = 5;
  private final int timeOutDurationInSeconds = 30;
  private final int timeOutDurationInMilliseconds = 100;

  public WaitUtils(WebDriver driver) {
    wait = new WebDriverWait(driver, timeOutInSeconds);
    fluentWait = new FluentWait<>(driver)
      .withTimeout(Duration.ofSeconds(timeOutDurationInSeconds))
      .pollingEvery(Duration.ofMillis(timeOutDurationInMilliseconds))
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
