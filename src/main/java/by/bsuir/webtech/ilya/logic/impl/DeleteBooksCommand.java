package by.bsuir.webtech.ilya.logic.impl;

import by.bsuir.webtech.ilya.Controller.JspPageName;
import by.bsuir.webtech.ilya.DAO.BookDao;
import by.bsuir.webtech.ilya.entities.Book;
import by.bsuir.webtech.ilya.logic.CommandHelper;
import by.bsuir.webtech.ilya.logic.CommandName;
import by.bsuir.webtech.ilya.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class DeleteBooksCommand implements ICommand {

    private final BookDao bookDao = new BookDao();
    @Override
    public String execute(HttpServletRequest request) {
        return executeDelete(request);
    }
    private String executeDelete(HttpServletRequest request)
    {
        bookDao.deleteById(Long.parseLong(request.getParameter("book_id")));
        return CommandHelper.getInstance().getCommand("VIEW_BOOKS_COMMAND").execute(request);
    }
}
