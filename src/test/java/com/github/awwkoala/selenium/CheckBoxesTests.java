package com.github.awwkoala.selenium;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBoxesTests {
/*  Stwórz test automatyczny na podstawie poniższego scenariusza testowego:
  Przejdź na stronę checkboxes
  Sprawdź, że po wejściu na stronę checkbox 1 jest odznaczony, zaś checkbox 2 jest zaznaczony
  Zaznacz checkbox 1, odznacz checkbox 2
  Sprawdź, że checkbox 1 jest zaznaczony, zaś checkbox 2 jest odznaczony*/

  @Test
  public void checkBoxesTest() {
    System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("http://theinternet.przyklady.javastart.pl/checkboxes");
    List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
    if (!checkboxes.get(0).isSelected() && checkboxes.get(1).isSelected()) {
      checkboxes.get(0).click();
      checkboxes.get(1).click();
    }
    Assertions.assertThat(checkboxes.get(0).isSelected())
      .describedAs("checkbox 1 is selected").isTrue();
    Assertions.assertThat(checkboxes.get(1).isSelected())
      .describedAs("checkbox 2 is not selected").isFalse();
    driver.quit();
  }

}
