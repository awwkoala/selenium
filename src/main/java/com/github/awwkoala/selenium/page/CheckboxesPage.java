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
    waitUtils.waitUntilClickable(checkboxes.get(i));
    checkboxes.get(i).click();
  }

  public void clickFirstCheckbox() {
    clickCheckbox(0);
  }

  public void clickSecondCheckbox() {
    clickCheckbox(1);
  }

  private boolean isCheckboxSelected(int i) {
    return checkboxes.get(i).isSelected();
  }

  private void assertThatCheckboxSelected(int i) {
    Assertions.assertThat(isCheckboxSelected(i))
      .describedAs("checkbox %d is selected", i).isTrue();
  }

  private void assertThatCheckboxNotSelected(int i) {
    Assertions.assertThat(isCheckboxSelected(i))
      .describedAs("checkbox %d is selected", i).isFalse();
  }

  public void assertThatFirstCheckboxSelected() {
    assertThatCheckboxSelected(0);
  }

  public void assertThatSecondCheckboxSelected() {
    assertThatCheckboxSelected(1);
  }

  public void assertThatFirstCheckboxNotSelected() {
    assertThatCheckboxNotSelected(0);
  }

  public void assertThatSecondCheckboxNotSelected() {
    assertThatCheckboxNotSelected(1);
  }

}
