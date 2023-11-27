package by.bsuir.webtech.ilya.logic.impl;

import by.bsuir.webtech.ilya.Controller.JspPageName;
import by.bsuir.webtech.ilya.DAO.BookDao;
import by.bsuir.webtech.ilya.DAO.OrderDao;
import by.bsuir.webtech.ilya.entities.Book;
import by.bsuir.webtech.ilya.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public class GetBooksCommand implements ICommand {
    private final BookDao bookDao = new BookDao();
    private final OrderDao orderDao =  new OrderDao();
    @Override
    public String execute(HttpServletRequest request) {
       return executeViewBooks(request);
    }
    private String executeViewBooks(HttpServletRequest request)
    {
        List<Book> books = bookDao.findAll();
        request.setAttribute("books",books);
        return JspPageName.BOOKS_PAGE;
    }
}
