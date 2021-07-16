package com.github.awwkoala.selenium;

import com.github.awwkoala.selenium.page.CheckboxesPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxesTests extends TestBase {

  private CheckboxesPage cbPage;
  /*  Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
  Przejdź na stronę checkboxes
  Sprawdź, że po wejściu na stronę checkbox 1 jest odznaczony, zaś checkbox 2 jest zaznaczony
  Zaznacz checkbox 1, odznacz checkbox 2
  Sprawdź, że checkbox 1 jest zaznaczony, zaś checkbox 2 jest odznaczony*/

  @BeforeClass
  public void prepareTest() {
    cbPage = new CheckboxesPage(driver);
    cbPage.goTo();
  }

  @Test
  public void checkboxesTest() {
    cbPage.assertThatFirstCheckboxNotSelected();
    cbPage.assertThatSecondCheckboxSelected();

    cbPage.clickFirstCheckbox();
    cbPage.clickSecondCheckbox();

    cbPage.assertThatFirstCheckboxSelected();
    cbPage.assertThatSecondCheckboxNotSelected();
  }

}
