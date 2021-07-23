package com.github.awwkoala.selenium;

import com.github.awwkoala.selenium.page.CheckboxesPage;
import com.github.awwkoala.selenium.page.HoversPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HoversTests extends TestBase {

  private HoversPage hPage;
/*  Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
  Przejdź na stronę hovers
  Najedź myszką na pierwsze (z lewej) zdjęcie użytkownika
  Sprawdź, że po najechaniu myszką pod zdjęciem dostępny jest napis name: user1
  oraz że, dla pozostałych dwóch kolejnych zdjęć podpis jest pusty
  Wykonaj analogicznie kroki 2 i 3 dla kolejnych zdjęć użytkownika*/

  @BeforeClass
  public void prepareTest() {
    hPage = new HoversPage(driver);
    hPage.goTo();
  }

  @Test
  public void verifyMouseHoverUsersPictures() {
    hPage
      .mouseHoverFirstPicture()
      .assertThatCaptionUserOneIsDisplayed()
      .assertThatCaptionUserTwoIsNotDisplayed()
      .assertThatCaptionUserThreeIsNotDisplayed()
      .mouseHoverSecondPicture()
      .assertThatCaptionUserTwoIsDisplayed()
      .assertThatCaptionUserOneIsNotDisplayed()
      .assertThatCaptionUserThreeIsNotDisplayed()
      .mouseHoverThirdPicture()
      .assertThatCaptionUserThreeIsDisplayed()
      .assertThatCaptionUserTwoIsNotDisplayed()
      .assertThatCaptionUserOneIsNotDisplayed();
  }

}
