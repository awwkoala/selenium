package com.github.awwkoala.selenium;

import com.github.awwkoala.selenium.page.WaitForElementPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WaitForElementTests extends TestBase {

  private WaitForElementPage wfePage;
/*  Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
  Przejdź na stronę dynamic_loading/2
  Naciśnij na przycisk Start
  Sprawdź, że po jakimś czasie tekst Hello World! jest widoczny.
  Użyj implementacji FluentWait do czekania*/

  @BeforeClass
  public void prepareTest() {
    wfePage = new WaitForElementPage(driver);
    wfePage.goTo();
  }

  @Test
  public void test() {
    wfePage
      .clickButton()
      .waitUntilHelloTextIsDisplayed();
  }

}
