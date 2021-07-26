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

  private DropDownPage selectOption(String value) {
    Select dropdownSelect = new Select(dropdown);
    waitUtils.waitUntilIsVisible(dropdown);
    dropdown.click();
    dropdownSelect.selectByValue(value);
    return this;
  }

  public DropDownPage selectFirstOption() {
    return selectOption("1");
  }

  public DropDownPage selectSecondOption() {
    return selectOption("2");
  }

  private String getSelectedOptionValue() {
    Select dropdownSelect = new Select(dropdown);
    return dropdownSelect.getFirstSelectedOption().getAttribute("value");
  }

  private String getSelectedOptionText() {
    Select dropdownSelect = new Select(dropdown);
    return dropdownSelect.getFirstSelectedOption().getText();
  }

  public DropDownPage assertThatSelectedOptionHasText(String expectedText) {
    Assertions.assertThat(getSelectedOptionText())
      .describedAs("option %s is selected", expectedText).isEqualTo(expectedText);
    return this;
  }

  public DropDownPage assertThatOptionIsSelected(String expectedValue) {
    Assertions.assertThat(getSelectedOptionValue())
      .describedAs("option %s is selected", expectedValue).isEqualTo(expectedValue);
    return this;
  }

}
