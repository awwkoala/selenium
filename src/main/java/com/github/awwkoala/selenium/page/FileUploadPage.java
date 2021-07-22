package com.github.awwkoala.selenium.page;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.Paths;

public class FileUploadPage extends BasePage {

  @FindBy(id = "file-upload")
  private WebElement chooseFileBtn;

  @FindBy(id = "file-submit")
  private WebElement submitFileBtn;

  @FindBy(id = "uploaded-files")
  private WebElement uploadedFilesText;

  public FileUploadPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void goTo() {
    driver.get("http://theinternet.przyklady.javastart.pl/upload");
  }

  public FileUploadPage chooseFileToUpload() {
    waitUtils.waitUntilClickable(chooseFileBtn);
    String path = Paths.get("src", "main", "resources", "testfile.txt").toAbsolutePath().toString();
    chooseFileBtn.sendKeys(path);
    return this;
  }

  public FileUploadPage clickUpload() {
    waitUtils.waitUntilClickable(submitFileBtn);
    submitFileBtn.click();
    return this;
  }

  private String displayedUploadedFilename() {
    return uploadedFilesText.getText();
  }

  private void assertThatDisplayedFilenameIsCorrect(String filename) {
    Assertions.assertThat(filename)
      .describedAs("Displayed filename is %s", filename)
      .isEqualTo(displayedUploadedFilename());
  }

  public FileUploadPage assertThatDisplayedFilenameIsTestfileTxt() {
    assertThatDisplayedFilenameIsCorrect("testfile.txt");
    return this;
  }

}
