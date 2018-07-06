package ua.danit;

import ua.danit.util.TinderServer;

import java.util.Arrays;

public class AppRunner {
  public static void main(String[] args) throws Exception {
    System.out.println(Arrays.toString(args));
    int port = Integer.parseInt(args[0].split("=")[1]);

    TinderServer tinderServer = new TinderServer(port);
    tinderServer.start();
  }
}
