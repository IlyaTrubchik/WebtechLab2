package by.bsuir.webtech.ilya.logic.impl;

import by.bsuir.webtech.ilya.Controller.JspPageName;
import by.bsuir.webtech.ilya.DAO.BookDao;
import by.bsuir.webtech.ilya.DAO.OrderDao;
import by.bsuir.webtech.ilya.entities.Book;
import by.bsuir.webtech.ilya.entities.Order;
import by.bsuir.webtech.ilya.logic.CommandName;
import by.bsuir.webtech.ilya.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class BuyBookCommand implements ICommand {
    private final BookDao bookDao = new BookDao();
    private final OrderDao orderDao = new OrderDao();
    @Override
    public String execute(HttpServletRequest request) {
        return executeBuy(request);
    }
    private String executeBuy(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        if(userId!=null)
        {
            Long bookId = Long.parseLong(request.getParameter("book_id"));
            Order order =  new Order(userId, Date.valueOf(LocalDate.now()),bookDao.findById(bookId).getPrice());
            orderDao.insertOrder(order);
        }
        List<Book> books = bookDao.findAll();
        request.setAttribute("books",books);
        return JspPageName.BOOKS_PAGE;
    }
}
