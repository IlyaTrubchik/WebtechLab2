package by.bsuir.webtech.ilya.ConnectionPool;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.sql.*;
public class ConnectionPool {

    private final static String password ="ilyabkmz";
    private final static String login="root";
    private final static String url="jdbc:mysql://localhost/bookshop";
    private static  ConnectionPool instance;
    private BlockingQueue<ProxyConnection> freeConnections;
    private Queue<ProxyConnection> givenConnections;

    private final int DEFAULT_POOL_SIZE = 1;
    private ConnectionPool()
    {
        //register drivers
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        freeConnections = new LinkedBlockingDeque<>(DEFAULT_POOL_SIZE);
        for(int i = 0;i<DEFAULT_POOL_SIZE;i++)
        {
            try {
                ProxyConnection proxyConnection = new ProxyConnection(DriverManager.getConnection(url,login,password));
                freeConnections.add(proxyConnection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
            givenConnections = new ArrayDeque<>();
        //init connections
    }
    public static ConnectionPool getInstance()
    {
        if(ConnectionPool.instance == null)
        {
            ConnectionPool.instance =  new ConnectionPool();
        }
        return  ConnectionPool.instance;
    }
    public Connection getConnection()  { //Returns ProxyConnection
        Connection connection = null;
        try {
            connection =  freeConnections.take();
            givenConnections.offer((ProxyConnection) connection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return  connection;
    }
    public void releaseConnection(Connection connection)
    {
        if( connection.getClass() == ProxyConnection.class)//If not proxy connection, then its not our connection
        {
            givenConnections.remove(connection);
            freeConnections.offer((ProxyConnection) connection);
        }
        else{
            //Exception
        }

    }
    public void destroyPool()
    {
        for(int i = 0;i<DEFAULT_POOL_SIZE;i++)
        {
            try {
                freeConnections.take().reallyClose();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        deregisterDrivers();
    }
    public void deregisterDrivers()
    {
        DriverManager.getDrivers().asIterator().forEachRemaining(driver -> {
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
