package com.github.awwkoala.selenium.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

  public WebDriver getChromeDriver() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver();
  }

}
