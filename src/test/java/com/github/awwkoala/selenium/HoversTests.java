package com.github.awwkoala.selenium;

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
    String user1 = "name: user1";
    String user2 = "name: user2";
    String user3 = "name: user3";

    hPage
      .mouseHoverFirstPicture()
      .assertThatCaptionIsDisplayed(user1)
      .assertThatCaptionIsNotDisplayed(user2)
      .assertThatCaptionIsNotDisplayed(user3)
      .mouseHoverSecondPicture()
      .assertThatCaptionIsDisplayed(user2)
      .assertThatCaptionIsNotDisplayed(user1)
      .assertThatCaptionIsNotDisplayed(user3)
      .mouseHoverThirdPicture()
      .assertThatCaptionIsDisplayed(user3)
      .assertThatCaptionIsNotDisplayed(user1)
      .assertThatCaptionIsNotDisplayed(user2);
  }

}
