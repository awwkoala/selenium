package com.github.awwkoala.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

  public WebDriver getChromeDriver() {
    WebDriverProperties properties = PropertiesProvider.getProperties(WebDriverProperties.class);
    System.setProperty("webdriver.chrome.driver", properties.webDriverPath());
    return new ChromeDriver();
  }

}
