package com.github.awwkoala.selenium.util;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:WebDriver.properties"})
public interface WebDriverProperties extends Config {

  @Config.Key("WEB_DRIVER_PATH")
  String webDriverPath();

}
