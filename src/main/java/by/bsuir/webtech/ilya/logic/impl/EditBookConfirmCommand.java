package by.bsuir.webtech.ilya.logic.impl;

import by.bsuir.webtech.ilya.Controller.JspPageName;
import by.bsuir.webtech.ilya.DAO.BookDao;
import by.bsuir.webtech.ilya.entities.Book;
import by.bsuir.webtech.ilya.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Date;

public class EditBookConfirmCommand implements ICommand {
    private final BookDao bookDao = new BookDao();
    @Override
    public String execute(HttpServletRequest request) {
        return executeUpdate(request);
    }

    public String executeUpdate(HttpServletRequest request)
    {
        Book book = new Book(Long.parseLong(request.getParameter("book_id")),
                request.getParameter("author"),
                request.getParameter("title"),
                Integer.parseInt(request.getParameter("price")),
                request.getParameter("genre"),
                request.getParameter("description"),
                Date.valueOf(request.getParameter("publication_date"))
       );
        bookDao.updateBook(book,book.getId());
        request.setAttribute("book",book);
        return JspPageName.EDIT_BOOK_PAGE;
    }
}
