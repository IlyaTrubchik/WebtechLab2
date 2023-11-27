package by.bsuir.webtech.ilya.logic.impl;

import by.bsuir.webtech.ilya.Controller.JspPageName;
import by.bsuir.webtech.ilya.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

public class RegistrationPageCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) {
        return executeGet(request);
    }
    private String executeGet(HttpServletRequest request)
    {
        return JspPageName.REGISTRATION_PAGE;
    }
}
