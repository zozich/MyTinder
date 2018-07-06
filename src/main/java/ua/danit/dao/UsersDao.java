package ua.danit.dao;

import ua.danit.entity.User;
import ua.danit.util.ConnectionToDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersDao {
  private List<User> users = new ArrayList<>();

  public UsersDao() {
    users.add(new User(1, "Joanna", "http://hdwallpapersfreepics.com/wp-content/uploads/2018/01/5284674-image-girl.jpg"));
    users.add(new User(2, "Betty", "http://szzljy.com/data/3/7/32357.jpg"));
    users.add(new User(3, "Kate", "https://images.indianexpress.com/2017/11/disha-patani-759.jpg"));
    System.out.println("Done!");
  }

  public User getUserByIndex(int index) {
    return users.get(index % users.size());
  }

  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();

    String sql = "SELECT * FROM zozich_users";

    try (
        Connection connection = ConnectionToDataBase.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet rSet = statement.executeQuery();
    ) {
      while (rSet.next()) {
        User user = new User();

        user.setId(rSet.getInt("id"));
        user.setName(rSet.getString("name"));
        user.setPhoto(rSet.getString("photo"));

        users.add(user);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return users;
  }
}
