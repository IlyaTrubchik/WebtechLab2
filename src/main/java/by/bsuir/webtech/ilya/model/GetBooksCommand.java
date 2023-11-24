package by.bsuir.webtech.ilya.model;

import by.bsuir.webtech.ilya.DAO.BookDao;
import by.bsuir.webtech.ilya.DAO.OrderDao;
import by.bsuir.webtech.ilya.entities.Book;
import by.bsuir.webtech.ilya.entities.Order;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GetBooksCommand implements ICommand {
    private final BookDao bookDao = new BookDao();
    private final OrderDao orderDao =  new OrderDao();
    @Override
    public String execute(HttpServletRequest request) {

        if(request.getMethod().equals("POST")){
            return  executePost(request);
        }else
        {
            return executeViewBooks(request);
        }
    }
    private String executeViewBooks(HttpServletRequest request)
    {
        List<Book> books = bookDao.findAll();
        request.setAttribute("books",books);
        HttpSession session =  request.getSession();
        if (session.getAttribute("role").equals("USER")) {
            return "WEB-INF/jsp/books.jsp";
        } else if (session.getAttribute("role").equals("ADMINISTRATOR")) {
            return "WEB-INF/jsp/books_admin.jsp";
        }
        return "WEB-INF/jsp/books.jsp";
    }
    private String executePost(HttpServletRequest request)
    {

        return "WEB-INF/jsp/books.jsp";
    }
}
