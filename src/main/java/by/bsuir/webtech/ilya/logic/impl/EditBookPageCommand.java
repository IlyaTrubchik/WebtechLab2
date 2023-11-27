package by.bsuir.webtech.ilya.logic.impl;

import by.bsuir.webtech.ilya.Controller.JspPageName;
import by.bsuir.webtech.ilya.DAO.BookDao;
import by.bsuir.webtech.ilya.entities.Book;
import by.bsuir.webtech.ilya.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

public class EditBookPageCommand implements ICommand {
    private final BookDao bookDao = new BookDao();
    @Override
    public String execute(HttpServletRequest request) {
        return executeGet(request);
    }

    private String executeGet(HttpServletRequest request)
    {
        Long bookId = Long.parseLong(request.getParameter("book_id"));
        Book book = bookDao.findById(bookId);
        request.setAttribute("book",book);
        return JspPageName.EDIT_BOOK_PAGE;
    }
}
