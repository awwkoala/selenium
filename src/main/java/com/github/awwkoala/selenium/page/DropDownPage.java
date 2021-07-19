package com.github.awwkoala.selenium.page;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownPage extends BasePage {

  @FindBy(id = "dropdown")
  private WebElement dropdown;


  @FindBy(css = "#dropdown option")
  private List<WebElement> options;

  public DropDownPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void goTo() {
    driver.get("http://theinternet.przyklady.javastart.pl/dropdown");
  }

  private void selectOption(int i) {
    Select dropdownSelect = new Select(dropdown);
    waitUtils.waitUntilVisible(dropdown);
    dropdown.click();
    dropdownSelect.selectByIndex(i);
  }

  public DropDownPage selectFirstOption() {
    selectOption(1);
    return this;
  }

  public DropDownPage selectSecondOption() {
    selectOption(2);
    return this;
  }

  private boolean isOptionSelected(int i) {
    dropdown.click();
    return options.get(i).isSelected();
  }

  private void assertThatOptionIsSelected(int i) {
    Assertions.assertThat(isOptionSelected(i)).describedAs("option %d is selected", i).isTrue();
  }

  public DropDownPage assertThatDefaultOptionIsSelected() {
    assertThatOptionIsSelected(0);
    return this;
  }

  public DropDownPage assertThatFirstOptionIsSelected() {
    assertThatOptionIsSelected(1);
    return this;
  }

  public DropDownPage assertThatSecondOptionIsSelected() {
    assertThatOptionIsSelected(2);
    return this;
  }

}
