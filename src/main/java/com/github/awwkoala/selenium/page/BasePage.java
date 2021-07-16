package com.github.awwkoala.selenium.page;

import com.github.awwkoala.selenium.util.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  protected WebDriver driver;
  protected WaitUtils waitUtils;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    this.waitUtils = new WaitUtils(driver);
  }

  public abstract void goTo();

}
