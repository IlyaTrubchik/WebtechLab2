package by.bsuir.webtech.ilya.model;

import by.bsuir.webtech.ilya.DAO.UserDao;
import by.bsuir.webtech.ilya.entities.User;
import jakarta.servlet.http.HttpServletRequest;

public class RegisterCommand implements ICommand{
    private final UserDao dao = new UserDao();
    @Override
    public String execute(HttpServletRequest request) {
        return executeRegistration(request);
    }

    private String executeRegistration(HttpServletRequest request){
        String login  =  request.getParameter("login");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone  =  request.getParameter("phone");
        String address = request.getParameter("address");
        dao.InsertUser(new User((long)0,login,name,password,phone,address,1));
        return "WEB-INF/jsp/register.jsp";
    }
}
