package dev.joaquimneto.affirmations;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
  public static void info(String line) {
    System.out.printf("%s %s\n", getFormattedDate(), line);
  }

  public static void inline(String line) {
    System.out.printf("%s %s", getFormattedDate(), line);
  }

  private static String getFormattedDate() {
    String pattern = "yyyy-MM-dd HH:mm:ssZ";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    return simpleDateFormat.format(new Date());
  }
}
