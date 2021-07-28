package com.github.awwkoala.selenium.page;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicControlsPage extends BasePage {

  @FindBy(id = "btn")
  private WebElement button;

  @FindBy(id = "checkbox")
  private WebElement checkbox;

  @FindBy(id = "message")
  private WebElement message;

  public DynamicControlsPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void goTo() {
    driver.get("http://theinternet.przyklady.javastart.pl/dynamic_controls");
  }

  private boolean isCheckboxVisible() {
    try {
      waitUtils.waitUntilIsVisible(checkbox);
      return checkbox.isDisplayed();
    } catch (TimeoutException e) {
      return false;
    }
  }

  private boolean isCheckboxSelected() {
    waitUtils.waitUntilIsVisible(checkbox);
    return checkbox.isSelected();
  }

  public DynamicControlsPage clickButton() {
    waitUtils.waitUntilClickable(button);
    button.click();
    return this;
  }

  public DynamicControlsPage assertThatCheckboxIsVisible() {
    Assertions.assertThat(isCheckboxVisible()).describedAs("checkbox is visible").isTrue();
    return this;
  }

  public DynamicControlsPage assertThatCheckboxIsNotSelected() {
    Assertions.assertThat(isCheckboxSelected()).describedAs("checkbox is selected").isFalse();
    return this;
  }

  public DynamicControlsPage assertThatMessageIsAsExpected(String messageText) {
    waitUtils.waitUntilIsVisible(message);
    Assertions.assertThat(message.getText()).describedAs("Message is %s", messageText).isEqualTo(messageText);
    return this;
  }

}
