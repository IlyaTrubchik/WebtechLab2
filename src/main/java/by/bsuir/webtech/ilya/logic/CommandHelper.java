package by.bsuir.webtech.ilya.logic;

import by.bsuir.webtech.ilya.logic.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    private static final CommandHelper instance = new CommandHelper();
    private Map<CommandName, ICommand> commands = new HashMap<>();
    public CommandHelper() {
        commands.put(CommandName.BUY_BOOK_COMMAND,new BuyBookCommand());
        commands.put(CommandName.REGISTRATION_COMMAND, new RegisterCommand());
        commands.put(CommandName.AUTHORIZATION_COMMAND, new LogInCommand());
        commands.put(CommandName.DELETE_BOOK_COMMAND, new DeleteBooksCommand());
        commands.put(CommandName.AUTHORIZATION_PAGE_COMMAND, new LoginPageCommand());
        commands.put(CommandName.REGISTRATION_PAGE_COMMAND, new RegistrationPageCommand());
        commands.put(CommandName.VIEW_BOOKS_COMMAND,new GetBooksCommand());
    }
    public static CommandHelper getInstance()
    {
        return instance;
    }
    public ICommand getCommand(String commandName){
        CommandName name = CommandName.valueOf(commandName.toUpperCase());
        ICommand command;
        if ( null != name){
            command = commands.get(name);
        }
        else{
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }
}
