package com.github.awwkoala.selenium.page;

import com.github.awwkoala.selenium.util.PathUtils;
import com.github.awwkoala.selenium.util.WaitUtils;
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

  public FileUploadPage chooseFileToUpload(String filename) {
    PathUtils pathUtils = new PathUtils();
    String absolutePath = pathUtils.getPathFromResources(Paths.get(filename)).toAbsolutePath().toString();
    waitUtils.waitUntilClickable(chooseFileBtn);
    chooseFileBtn.sendKeys(absolutePath);
    return this;
  }

  public FileUploadPage clickUpload() {
    waitUtils.waitUntilClickable(submitFileBtn);
    submitFileBtn.click();
    return this;
  }

  public FileUploadPage assertThatDisplayedFilenameIsCorrect(String filename) {
    waitUtils.waitUntilIsVisible(uploadedFilesText);
    Assertions.assertThat(filename)
      .describedAs("Displayed filename is %s", filename)
      .isEqualTo(uploadedFilesText.getText());
    return this;
  }

}
