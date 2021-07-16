package com.github.awwkoala.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

  public WebDriver getChromeDriver() {
    System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
    return new ChromeDriver();
  }

}
