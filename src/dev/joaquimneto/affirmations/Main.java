package dev.joaquimneto.affirmations;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;

public class Main {
  public static void main(String[] args) {
    Logger.info("Did you know?");

    String affirmation = fetchAffirmation();
    Logger.info(affirmation);
    Logger.inline("Bye 💙");

    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String fetchAffirmation() {
    HttpClient http = HttpClient.newHttpClient();
    HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create("https://www.affirmations.dev/")).build();

    HttpResponse<String> res;
    try {
      res = http.send(req, BodyHandlers.ofString(Charset.defaultCharset()));
      String json = res.body();
      return json.substring(16, json.length() - 2);
    } catch (IOException | InterruptedException e) {
      // it's okay
    }
    return "You matter!";
  }
}
