package by.bsuir.webtech.ilya.DAO;

import by.bsuir.webtech.ilya.ConnectionPool.ConnectionPool;
import by.bsuir.webtech.ilya.entities.Book;
import by.bsuir.webtech.ilya.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao implements IDao<Book>{
    private final String  FIND_BY_AUTHOR = "";
    private final String FIND_BY_NAME = "";
    private final String DELETE_BY_ID = "DELETE FROM books WHERE book_id = ?";
    private final static String FIND_BY_ID = "SELECT * FROM books WHERE book_id = ?";
    private final String FIND_ALL = "SELECT * FROM books";
    @Override
    public Book findById(long id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement =  connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1,id);

            ResultSet rs = statement.executeQuery();
            Book book = null;
            while(rs.next())
            {
                 book = new Book(rs.getLong("book_id"),rs.getString("author"),rs.getString("title"),
                         rs.getInt("price"),rs.getString("genre"));
            }
            connection.close();
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteById(Long id)
    {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);
            statement.setLong(1,id);
            int count = statement.executeUpdate();
            if(count == 1)
            {
                connection.close();
                return  true;
            }
            else{
                connection.close();
                return false;
            }

        }catch (SQLException e)
        {
            throw  new RuntimeException(e);
        }
    }
    @Override
    public List<Book> findAll() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try {
            PreparedStatement statement =  connection.prepareStatement(FIND_ALL);
            ResultSet rs = statement.executeQuery();
            ArrayList<Book> bookList =  new ArrayList<>();
            Book book = null;
            while(rs.next())
            {
                book = new Book(rs.getLong("book_id"),rs.getString("author"),rs.getString("title"),
                        rs.getInt("price"),rs.getString("genre"));
                bookList.add(book);
            }
            connection.close();
            return bookList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
