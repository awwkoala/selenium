package com.github.awwkoala.selenium.page;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoversPage extends BasePage {

  Actions actions = new Actions(driver);

  @FindBy(css = ".figure")
  private List<WebElement> pictures;

  @FindBy(css = ".figcaption h5")
  private List<WebElement> captions;

  public HoversPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public void goTo() {
    driver.get("http://theinternet.przyklady.javastart.pl/hovers");
  }

  private HoversPage mouseHoverElement(int i) {
    waitUtils.waitUntilIsVisible(pictures.get(i));
    actions.moveToElement(pictures.get(i)).perform();
    return this;
  }

  public HoversPage mouseHoverFirstPicture() {
    return mouseHoverElement(0);
  }

  public HoversPage mouseHoverSecondPicture() {
    return mouseHoverElement(1);
  }

  public HoversPage mouseHoverThirdPicture() {
    return mouseHoverElement(2);
  }

  private boolean isCaptionDisplayed(String expectedText) {
    return captions.stream()
      .map(webElement -> webElement.getText())
      .anyMatch(actualText -> expectedText.equals(actualText));
  }

  public HoversPage assertThatCaptionIsDisplayed(String text) {
    Assertions.assertThat(isCaptionDisplayed(text)).describedAs("Caption %s is displayed", text).isTrue();
    return this;
  }

  public HoversPage assertThatCaptionIsNotDisplayed(String text) {
    Assertions.assertThat(isCaptionDisplayed(text)).describedAs("Caption %s is not displayed", text).isFalse();
    return this;
  }

}
