package by.bsuir.webtech.ilya.model;

import by.bsuir.webtech.ilya.DAO.BookDao;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteBooksCommand implements ICommand {

    private final BookDao bookDao = new BookDao();
    @Override
    public String execute(HttpServletRequest request) {
        return executeDelete(request);
    }
    private String executeDelete(HttpServletRequest request)
    {
        bookDao.deleteById(Long.parseLong(request.getParameter("book_id")));
        return "WEB-INF/jsp/books.jsp";
    }
}
