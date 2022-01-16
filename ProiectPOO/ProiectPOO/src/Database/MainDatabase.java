package Database;

import controllers.ControllerLogin;

import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainDatabase {

    private String host = "jdbc:mysql://localhost/database";
    private String username = "root";
    private String password = "29022000";

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User getUser(String username) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(getHost(), getUsername(), getPassword());
             PreparedStatement statement = createStatement(connection, username);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                user = new User(rs.getInt("ID"), rs.getString("Username"), rs.getString("Password"),rs.getString("Gender"),rs.getInt("Age"),rs.getString("Type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<User>();
        try (Connection con = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = createStatementGetAllUsers(con);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                users.add(new User(rs.getInt("ID"), rs.getString("Username"), rs.getString("Password")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void insertUser(User user) {
        try (Connection connection = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = createStatementInsertUser(connection, user);) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userid){
        try (Connection connection = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = createStatementDeleteUser(connection, userid);) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertSubscription(User user) {
        try (Connection connection = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = StatementInsertSubscription(connection, user);) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertRateing(User user) {
        try (Connection connection = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = StatementInsertFeedback(connection, user);) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTrainer(User user) {
        try (Connection connection = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = StatementInsertTrainer(connection, user);) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertGym(User user) {
        try (Connection connection = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = StatementInsertGym(connection, user);) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDiet(User user) {
        try (Connection connection = DriverManager.getConnection(host, username, password);
             PreparedStatement ps = StatementInsertDiet(connection, user);) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private PreparedStatement createStatementGetAllUsers(Connection con) throws SQLException {
        String sql = "SELECT * FROM user";
        PreparedStatement statement = con.prepareStatement(sql);
        return statement;
    }

    private PreparedStatement createStatement(Connection con, String username) throws SQLException {
        String sql = "SELECT * FROM user WHERE Username = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, username);
        return statement;
    }

    private PreparedStatement createStatementInsertUser(Connection con, User user) throws SQLException {
        String sql = "INSERT INTO user(Username, Password, Gender, Age, Type) " + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getGender());
        statement.setInt(4, user.getAge());
        statement.setString(5, user.getType());
        return statement;
    }

    private PreparedStatement createStatementDeleteUser(Connection con,int userId ) throws SQLException {
        String sql = " DELETE FROM user WHERE ID=? ";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, userId);
        return statement;
    }

    private PreparedStatement StatementInsertSubscription(Connection con,User user) throws SQLException {
        String insert = "INSERT INTO subscription(Username,Period, Date, Trainer, Description) " + "VALUES(?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(insert);
        statement.setString(1, ControllerLogin.getInstance().username());
        statement.setString(2, user.getPeriod());
        statement.setString(3, user.getDate());
        statement.setString(4, user.getTrainer());
        statement.setString(5, user.getDescription());
        return statement;
    }

    private PreparedStatement StatementInsertFeedback(Connection con,User user) throws SQLException {
        String insert = "INSERT INTO feedback(Category,Feedback, Rateing) " + "VALUES(?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(insert);
        statement.setString(1,user.getCategory());
        statement.setString(2,user.getFeedback());
        statement.setInt(3,user.getRateing());
        return statement;
    }

    private PreparedStatement StatementInsertTrainer(Connection con,User user) throws SQLException {
        String insert = "INSERT INTO trainer(Username,TrainerName, Info) " + "VALUES(?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(insert);
        statement.setString(1,user.getUsername());
        statement.setString(2,user.getFullName());
        statement.setString(3,user.getInfo());
        return statement;
    }

    private PreparedStatement StatementInsertGym(Connection con,User user) throws SQLException {
        String insert = "INSERT INTO gym(Equipment, Quantity) " + "VALUES(?, ?)";
        PreparedStatement statement = con.prepareStatement(insert);
        statement.setString(1,user.getEquipment());
        statement.setString(2,user.getQuantity());
        return statement;
    }

    private PreparedStatement StatementInsertDiet(Connection con,User user) throws SQLException {
        String insert = "INSERT INTO diet(Username, Diet) " + "VALUES(?, ?)";
        PreparedStatement statement = con.prepareStatement(insert);
        statement.setString(1,user.getEquipment());
        statement.setString(2,user.getQuantity());
        return statement;
    }
}
