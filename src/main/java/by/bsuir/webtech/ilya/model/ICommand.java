package by.bsuir.webtech.ilya.model;

import jakarta.servlet.http.HttpServletRequest;

public interface ICommand {
    String execute(HttpServletRequest request);
}
