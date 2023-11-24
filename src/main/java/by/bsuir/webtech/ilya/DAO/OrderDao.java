package by.bsuir.webtech.ilya.DAO;

import by.bsuir.webtech.ilya.ConnectionPool.ConnectionPool;
import by.bsuir.webtech.ilya.entities.Order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderDao implements IDao<Order>{
    private final String INSERT_ORDER = "INSERT INTO orders (order_date,total_amount,Users_user_id) VALUES (?,?,?)";
    @Override
    public Order findById(long id) {
        return null;
    }
    public boolean insertOrder(Order order)
    {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement =  connection.prepareStatement(INSERT_ORDER);
            statement.setDate(1, Date.valueOf(LocalDate.now()));
            statement.setInt(2,order.getPrice());
            statement.setLong(3,order.getUserId());
            statement.execute();

            connection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Order> findAll() {
        return null;
    }
}
