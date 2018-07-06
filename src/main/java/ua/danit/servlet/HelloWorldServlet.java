package ua.danit.servlet;

import ua.danit.dao.UsersDao;
import ua.danit.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class HelloWorldServlet extends HttpServlet {
  private Boolean choice;
  private int currentUserIndex = 0;
  private UsersDao usersDao = new UsersDao();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();

    User user = usersDao.getUserByIndex(currentUserIndex);

    writer.write("<!DOCTYPE html>\n" +
        "<html lang=\"en\">\n" +
        "<head>\n" +
        "  <meta charset=\"UTF-8\">\n" +
        "  <title>Title</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>"+ user.getName() + "</h1>" +
        "<img width='600' src='" + user.getPhoto() + "'>" +
        "<form method='POST' action='/users'>" +
        "<button name='choice' value='yes'>Yes</button>" +
        "<button name='choice' value='no'>No</button>" +
        "</form>" +
        "</body>\n" +
        "</html>");

    List<User> allUsers = usersDao.getAllUsers();
    currentUserIndex++;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userChoice = req.getParameter("choice");

    choice = "yes".equals(userChoice);

    doGet(req, resp);
//    resp.sendRedirect("/users");
  }
}
