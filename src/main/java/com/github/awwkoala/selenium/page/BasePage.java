package com.github.awwkoala.selenium.page;

import com.github.awwkoala.selenium.util.WaitUtils;
import com.github.awwkoala.selenium.util.WebElementsUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  protected WebDriver driver;
  protected WaitUtils waitUtils;
  protected WebElementsUtils webElementsUtils;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    this.waitUtils = new WaitUtils(driver);
    this.webElementsUtils = new WebElementsUtils(waitUtils);
  }

  public abstract void goTo();

}
