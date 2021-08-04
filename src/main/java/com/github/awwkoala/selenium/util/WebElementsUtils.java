package com.github.awwkoala.selenium.util;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class WebElementsUtils {

  protected WaitUtils waitUtils;

  public WebElementsUtils(WaitUtils waitUtils) {
    this.waitUtils = waitUtils;
  }

  public boolean isElementVisible(WebElement webElement) {
    try {
      waitUtils.waitUntilIsVisible(webElement);
      return webElement.isDisplayed();
    } catch (TimeoutException e) {
      return false;
    }
  }

}
