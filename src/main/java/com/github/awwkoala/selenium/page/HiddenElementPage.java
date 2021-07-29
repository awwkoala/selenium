package com.github.awwkoala.selenium.page;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HiddenElementPage extends BasePage {

  @FindBy(id = "finish")
  private WebElement helloText;

  @FindBy(css = "#start button")
  private WebElement startBtn;

  public HiddenElementPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void goTo() {
    driver.get("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
  }

  public HiddenElementPage clickStartButton() {
    waitUtils.waitUntilClickable(startBtn);
    startBtn.click();
    return this;
  }

  private boolean isHelloTextVisible() {
    String style = helloText.getAttribute("style");
    return !style.equals("display: none;");
  }

  public HiddenElementPage assertThatHelloTextIsVisible() {
    waitUtils.waitUntilIsVisible(helloText);
    Assertions.assertThat(isHelloTextVisible()).describedAs("Hello text is visible").isTrue();
    return this;
  }

  public HiddenElementPage assertThatHelloTextIsNotVisible() {
    Assertions.assertThat(isHelloTextVisible()).describedAs("Hello text is not visible").isFalse();
    return this;
  }

}
