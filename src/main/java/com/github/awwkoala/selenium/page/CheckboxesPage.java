package com.github.awwkoala.selenium.page;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxesPage extends Page {

  @FindBy(css = "input[type='checkbox']")
  private List<WebElement> checkboxes;

  public CheckboxesPage(WebDriver driver) {
    super(driver);
  }

  public void goToCheckboxesPage() {
    driver.get("http://theinternet.przyklady.javastart.pl/checkboxes");
  }

  public void clickCheckbox1() {
    checkboxes.get(0).click();
  }

  public void clickCheckbox2() {
    checkboxes.get(1).click();
  }

  public boolean isCheckbox1Selected() {
    return checkboxes.get(0).isSelected();
  }

  public boolean isCheckbox2Selected() {
    return checkboxes.get(1).isSelected();
  }

  public void assertThatCheckbox1Selected() {
    Assertions.assertThat(isCheckbox1Selected())
      .describedAs("checkbox 1 is selected").isTrue();
  }

  public void assertThatCheckbox2Selected() {
    Assertions.assertThat(isCheckbox2Selected())
      .describedAs("checkbox 2 is selected").isTrue();
  }

  public void assertThatCheckbox1NotSelected() {
    Assertions.assertThat(isCheckbox1Selected())
      .describedAs("checkbox 1 is not selected").isFalse();
  }

  public void assertThatCheckbox2NotSelected() {
    Assertions.assertThat(isCheckbox2Selected())
      .describedAs("checkbox 2 is not selected").isFalse();
  }

}
