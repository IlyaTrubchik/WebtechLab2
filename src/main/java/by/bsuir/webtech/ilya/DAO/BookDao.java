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

    private final String UPDATE_BY_ID = "UPDATE books SET title = ?, author = ?, genre = ?, price = ?, publication_date = ?, description = ? WHERE book_id = ?";
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
                         rs.getInt("price"),rs.getString("genre"),rs.getString("description"),rs.getDate("publication_date"));
            }
            connection.close();
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateBook(Book book,Long id)
    {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID);
            statement.setString(1,book.getTitle());
            statement.setString(2,book.getAuthor());
            statement.setString(3,book.getGenre());
            statement.setInt(4,book.getPrice());
            statement.setDate(5,book.getPublicationDate());
            statement.setString(6, book.getDescription());
            statement.setLong(7,book.getId());

            ;
            if(statement.executeUpdate() == 6)
            {
                connection.close();
                return true;
            }
            else
            {
                connection.close();
                return false;
            }

        }catch (SQLException e)
        {
            throw  new RuntimeException(e);
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
