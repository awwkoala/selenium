package com.github.awwkoala.selenium;

import com.github.awwkoala.selenium.page.HiddenElementPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HiddenElementTests extends TestBase {

  private HiddenElementPage hePage;
/*  Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
  Przejdź na stronę dynamic_loading/1
  Sprawdź, że po wejściu na stronę tekst Hello World! jest niewidoczny!
  Naciśnij na przycisk Start
  Sprawdź, że po jakimś czasie tekst Hello World! jest widoczny.
  Uwaga: Przed przystąpieniem do pracy sprawdź jak działa funkcjonalność na stronie.
  Tekst Hello World! jest dostępny na stronie cały czas, pomimo tego, że go nie widać!*/

  @BeforeClass
  public void prepareTest() {
    hePage = new HiddenElementPage(driver);
    hePage.goTo();
  }

  @Test
  public void verifyElementHidesAndAppears() {
    hePage
      .assertThatHelloTextIsNotVisible()
      .clickStartButton()
      .assertThatHelloTextIsVisible();
  }

}
