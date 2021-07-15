package com.github.awwkoala.selenium;

import com.github.awwkoala.selenium.util.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class TestBase {

  protected WebDriver driver;

  @BeforeClass
  public void getDriver() {
    driver = new WebDriverProvider().getChromeDriver();
  }

  @AfterClass
  public void afterClass() {
    driver.close();
  }

}
