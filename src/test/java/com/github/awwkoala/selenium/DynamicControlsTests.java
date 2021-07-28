package com.github.awwkoala.selenium;

import com.github.awwkoala.selenium.page.DynamicControlsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicControlsTests extends TestBase {

  private DynamicControlsPage dcPage;
/*  Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
  Przejdź na stronę dynamic controls
  Sprawdź, że po wejściu na stronę checkbox jest odznaczony oraz widoczny
  Naciśnij na przycisk Remove
  Sprawdź, że po jakimś czasie pojawi się tekst It's gone!

  CZĘŚĆ DRUGA:

  Na bazie rozwiązania z zadania poprzedniego zmodyfikuj kod w taki sposób aby, kod spełniał następujący scenariusz:
  (tu jest zmodyfikuj, ale ja zrobię dwa testy :))
  Przejdź na stronę dynamic controls
  Sprawdź, że po wejściu na stronę checkbox jest odznaczony oraz widoczny
  Naciśnij na przycisk Remove
  Sprawdź, że po jakimś czasie pojawi się tekst It's gone!
  Naciśnij na przycisk Add
  Sprawdź, że checkbox jest odznaczony oraz widoczny*/

  @BeforeMethod
  public void prepareTest() {
    dcPage = new DynamicControlsPage(driver);
    dcPage.goTo();
  }

  @Test
  public void verifyThatCheckboxDisappears() {
    String expectedMessage = "It's gone!";

    dcPage
      .assertThatCheckboxIsVisible()
      .assertThatCheckboxIsNotSelected()
      .clickButton()
      .assertThatMessageIsAsExpected(expectedMessage);
  }

  @Test
  public void verifyThatCheckboxDisappearsAndAppears() {
    String expectedMessage = "It's gone!";

    dcPage
      .assertThatCheckboxIsVisible()
      .assertThatCheckboxIsNotSelected()
      .clickButton()
      .assertThatMessageIsAsExpected(expectedMessage)
      .clickButton()
      .assertThatCheckboxIsVisible()
      .assertThatCheckboxIsNotSelected();
  }

}
