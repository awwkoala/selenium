package com.github.awwkoala.selenium.page;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxesPage extends BasePage {

  @FindBy(css = "input[type='checkbox']")
  private List<WebElement> checkboxes;

  public CheckboxesPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void goTo() {
    driver.get("http://theinternet.przyklady.javastart.pl/checkboxes");
  }

  private void clickCheckbox(int i) {
    waitUtils.waitUntilIsClickable(checkboxes.get(i));
    checkboxes.get(i).click();
  }

  public CheckboxesPage clickFirstCheckbox() {
    clickCheckbox(0);
    return this;
  }

  public CheckboxesPage clickSecondCheckbox() {
    clickCheckbox(1);
    return this;
  }

  private boolean isCheckboxSelected(int i) {
    return checkboxes.get(i).isSelected();
  }

  private void assertThatCheckboxIsSelected(int i) {
    Assertions.assertThat(isCheckboxSelected(i))
      .describedAs("checkbox %d is selected", i).isTrue();
  }

  private void assertThatCheckboxIsNotSelected(int i) {
    Assertions.assertThat(isCheckboxSelected(i))
      .describedAs("checkbox %d is selected", i).isFalse();
  }

  public CheckboxesPage assertThatFirstCheckboxIsSelected() {
    assertThatCheckboxIsSelected(0);
    return this;
  }

  public CheckboxesPage assertThatSecondCheckboxIsSelected() {
    assertThatCheckboxIsSelected(1);
    return this;
  }

  public CheckboxesPage assertThatFirstCheckboxIsNotSelected() {
    assertThatCheckboxIsNotSelected(0);
    return this;
  }

  public CheckboxesPage assertThatSecondCheckboxIsNotSelected() {
    assertThatCheckboxIsNotSelected(1);
    return this;
  }

}
