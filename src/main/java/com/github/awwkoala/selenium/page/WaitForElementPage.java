package com.github.awwkoala.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WaitForElementPage extends BasePage {

  @FindBy(css = "#start button")
  private WebElement startBtn;

  @FindBy(id = "finish")
  private WebElement helloText;

  public WaitForElementPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void goTo() {
    driver.get("http://theinternet.przyklady.javastart.pl/dynamic_loading/2");
  }

  public WaitForElementPage clickButton() {
    waitUtils.waitUntilIsClickable(startBtn);
    startBtn.click();
    return this;
  }

  public WaitForElementPage waitUntilHelloTextIsDisplayed() {
    waitUtils.getFluentWait().until(webDriver -> helloText.isDisplayed());
    return this;
  }

}
