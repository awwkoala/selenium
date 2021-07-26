package com.github.awwkoala.selenium.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

  public Path getPathFromResources(Path filename) {
    return Paths.get("src", "main", "resources").resolve(filename);
  }

}
