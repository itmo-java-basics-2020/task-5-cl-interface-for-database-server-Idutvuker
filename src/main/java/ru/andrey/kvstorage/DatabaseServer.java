package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.*;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        if (commandText == null) {
            return DatabaseCommandResult.error("Null string input");
        }

        String[] args = commandText.split(" ");

        try {
            return DatabaseCommands.valueOf(args[0]).getCommand(env, args).execute();
        } catch(DatabaseException | IllegalArgumentException e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
