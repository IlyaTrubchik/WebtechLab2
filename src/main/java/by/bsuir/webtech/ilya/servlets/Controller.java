package by.bsuir.webtech.ilya.servlets;


import by.bsuir.webtech.ilya.ConnectionPool.ProxyConnection;
import by.bsuir.webtech.ilya.model.*;
import jakarta.servlet.Registration;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        switch (req.getParameter("command"))
        {
            case "registration":
            {
                requestDispatcher = req.getRequestDispatcher(new RegisterCommand().execute(req));
                break;
            }
            case "login":
            {
                requestDispatcher = req.getRequestDispatcher(new LogInCommand().execute(req));
                if(requestDispatcher == null)
                {
                    resp.sendRedirect("/register?command=registration");
                }
                break;
            }
            case "deleteBook":{
                requestDispatcher = req.getRequestDispatcher(new DeleteBooksCommand().execute(req));
                if(requestDispatcher != null)
                {
                    resp.sendRedirect("/books?command=viewbooks");
                    return;
                }
                break;
            }
            case "orderBook":{
                requestDispatcher = req.getRequestDispatcher(new BuyBookCommand().execute(req));
                if(requestDispatcher != null)
                {
                    resp.sendRedirect("/books?command=viewbooks");
                    return;
                }
                break;
            }
        }

        if(requestDispatcher != null)
        {
            requestDispatcher.forward(req, resp);
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command  = req.getParameter("command");
        RequestDispatcher requestDispatcher = null;
        switch (command) {
            case "registration": {
                requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/register.jsp");
                break;
            }
            case "login": {
                requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/login.jsp");
                break;
            }
            case "viewbooks":
            {
                requestDispatcher = req.getRequestDispatcher(new GetBooksCommand().execute(req));
                break;
            }
        }
        requestDispatcher.forward(req, resp);
    }
}
