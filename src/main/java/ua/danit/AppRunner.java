package ua.danit;

import ua.danit.util.TinderServer;

public class AppRunner {
  public static void main(String[] args) throws Exception {
    TinderServer tinderServer = new TinderServer();
    tinderServer.start();
  }
}
