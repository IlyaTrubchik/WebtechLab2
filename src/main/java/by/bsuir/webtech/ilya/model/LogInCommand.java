package by.bsuir.webtech.ilya.model;

import by.bsuir.webtech.ilya.DAO.UserDao;
import by.bsuir.webtech.ilya.entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LogInCommand implements  ICommand{
    private final UserDao userDao =  new UserDao();
    @Override
    public String execute(HttpServletRequest request) {

        return executeLogin(request);
    }
    private String executeLogin(HttpServletRequest request)
    {
        User user =  userDao.findByEmail(request.getParameter("login"));
        if(user.getEmail().equals(request.getParameter("login"))
                && user.getPasswordHash().equals(request.getParameter("password")) )
        {
            HttpSession session = request.getSession();
            session.setAttribute("userId",user.getId());
            session.setAttribute("role",user.getRole());
            return "WEB-INF/jsp/login.jsp";
        }
        else
        {
            return null;
        }
    }
}
