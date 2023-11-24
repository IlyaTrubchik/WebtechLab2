package by.bsuir.webtech.ilya.DAO;

import by.bsuir.webtech.ilya.ConnectionPool.ConnectionPool;
import by.bsuir.webtech.ilya.entities.Role;
import by.bsuir.webtech.ilya.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IDao<User>{
    private final static String FIND_BY_ID = "SELECT * FROM users WHERE id = ?";
    private final static String FIND_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    private final static String SELECT_ALL = "SELECT * FROM users";
    private final static String ROLE_BY_ID = "SELECT r.role_name FROM users u JOIN roles r ON u.Roles_role_id = r.role_id WHERE u.Roles_role_id = ?";
    private final static String INSERT = "INSERT Into users (name,email,password,Roles_role_id,phone,address) VALUES (?,?,?,?,?,?)";
    @Override
    public User findById(long id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement =  connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1,id);

            ResultSet rs = statement.executeQuery();
            User user = null;
            while(rs.next())
            {
               user = new User(id,rs.getString("Email"),rs.getString("Name"),
                        rs.getString("Password"),rs.getString("phone"),rs.getString("address"),rs.getInt("Roles_role_id"));
            }
            statement = connection.prepareStatement(ROLE_BY_ID);
            statement.setInt(1,user.getRoleId());
            rs = statement.executeQuery();
            if(rs.next()) {
                user.setRole(rs.getString("role_name"));
            }
            connection.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User findByEmail(String email)
    {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement =  connection.prepareStatement(FIND_BY_EMAIL);
            statement.setString(1,email);

            ResultSet rs = statement.executeQuery();
            User user = null;
            while(rs.next())
            {
                user = new User(rs.getLong("user_id"),rs.getString("email"),rs.getString("name"),
                        rs.getString("password"),rs.getString("phone"),rs.getString("address"),rs.getInt("Roles_role_id"));
            }
            statement = connection.prepareStatement(ROLE_BY_ID);
            statement.setInt(1,user.getRoleId());
            rs = statement.executeQuery();
            if(rs.next()) {
                user.setRole(rs.getString("role_name"));
            }
            connection.close();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement =  connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            ArrayList<User> userList =  new ArrayList<>();
            User user = null;
            while(rs.next())
            {
                user = new User(rs.getLong("id"),rs.getString("Email"),rs.getString("Name"),
                        rs.getString("Password"),rs.getString("phone"),rs.getString("address"),rs.getInt("Roles_role_id"));
                userList.add(user);
            }
            statement = connection.prepareStatement(ROLE_BY_ID);
            statement.setInt(1,user.getRoleId());
            rs = statement.executeQuery();
            if(rs.next()) {
                user.setRole(rs.getString("role_name"));
            }
            connection.close();
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean InsertUser(User user)
    {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement =  connection.prepareStatement(INSERT);

            statement.setString(1,user.getName());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPasswordHash());
            statement.setInt(4,user.getRoleId());
            statement.setString(5,user.getPhone());
            statement.setString(6,user.getAddress());
            statement.execute();

            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
