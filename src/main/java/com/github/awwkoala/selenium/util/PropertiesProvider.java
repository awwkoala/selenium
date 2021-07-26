package com.github.awwkoala.selenium.util;

import lombok.experimental.UtilityClass;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@UtilityClass
public class PropertiesProvider {
  private final Map<Class<? extends Config>, Config> propertiesMap = new ConcurrentHashMap<>();

  @SuppressWarnings("unchecked")
  public <T extends Config> T getProperties(Class<T> propertiesClass) {
    return (T) propertiesMap
      .computeIfAbsent(propertiesClass, ignored ->
        ConfigFactory.create(propertiesClass, System.getProperties(), System.getenv()));
  }
}
