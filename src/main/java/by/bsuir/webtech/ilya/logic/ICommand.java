package by.bsuir.webtech.ilya.logic;

import jakarta.servlet.http.HttpServletRequest;

public interface ICommand {
    String execute(HttpServletRequest request);
}
