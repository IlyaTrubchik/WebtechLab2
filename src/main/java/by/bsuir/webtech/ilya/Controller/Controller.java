package by.bsuir.webtech.ilya.Controller;


import by.bsuir.webtech.ilya.logic.CommandHelper;
import by.bsuir.webtech.ilya.logic.CommandName;
import by.bsuir.webtech.ilya.logic.ICommand;
import by.bsuir.webtech.ilya.logic.impl.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
    {
        CommandHelper commandHelper = CommandHelper.getInstance();
        String commandName = req.getParameter(RequestParameterName.COMMAND_NAME);
        ICommand command;
        if( (command = commandHelper.getCommand(commandName)) != null)
        {
            String page = command.execute(req);
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req,resp);
        }
    }
}
