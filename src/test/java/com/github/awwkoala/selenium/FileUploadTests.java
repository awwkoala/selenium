package com.github.awwkoala.selenium;

import com.github.awwkoala.selenium.page.FileUploadPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadTests extends TestBase {

  private FileUploadPage fuPage;
/*  Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
  Przed przystąpieniem do pracy utwórz w dowolnym miejscu na dysku plik testfile.txt z dowolną treścią.
  (dałam ten plik w resources)
  Przejdź na stronę upload
  Wybierz plik z nazwą testfile.txt
  Załaduj plik, klikając w przycisk Upload
  Sprawdź, że po załadowaniu pliku jego nazwa dostępna jest na stronie*/

  @BeforeClass
  public void prepareTest() {
    fuPage = new FileUploadPage(driver);
    fuPage.goTo();
  }

  @Test
  public void verifyUploadFileWorksCorrectly() {
    fuPage
      .chooseFileToUpload()
      .clickUpload()
      .assertThatDisplayedFilenameIsTestfileTxt();
  }

}
