package ua.danit.util;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ua.danit.servlet.HelloWorldServlet;

public class TinderServer {
  private int port;

  public TinderServer(int port) {
    this.port = port;
  }

  public void start() throws Exception {
    Server server = new Server(port);
    ServletContextHandler handler = new ServletContextHandler();

    ServletHolder userHolder = new ServletHolder(new HelloWorldServlet());
    handler.addServlet(userHolder, "/*");

    server.setHandler(handler);

    server.start();
    server.join();
  }
}
