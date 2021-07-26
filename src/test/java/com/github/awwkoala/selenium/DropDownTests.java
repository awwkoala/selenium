package com.github.awwkoala.selenium;

import com.github.awwkoala.selenium.page.DropDownPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownTests extends TestBase {

  private DropDownPage ddPage;
/*  Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
  Przejdź na stronę dropdown
  Sprawdź, że po wejściu na stronę w kontrolce typu Dropdown jest wybrana opcja "Please select an option"
  Ustaw wartość na Option 1
  Sprawdź, że wybrana opcja to Option 1
  Ustaw wartość na Option 2
  Sprawdź, że wybrana opcja to Option 2*/

  @BeforeClass
  public void prepareTest() {
    ddPage = new DropDownPage(driver);
    ddPage.goTo();
  }

  @Test
  public void verifyAllOptionsFromDropdown() {
    ddPage
      .assertThatOptionIsSelected("")
      .assertThatSelectedOptionHasText("Please select an option")
      .selectFirstOption()
      .assertThatOptionIsSelected("1")
      .selectSecondOption()
      .assertThatOptionIsSelected("2");
  }

}
