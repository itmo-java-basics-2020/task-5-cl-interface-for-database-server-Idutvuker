package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class CreateDatabaseCommand implements DatabaseCommand {
	private ExecutionEnvironment env;
	private String databaseName;

	public CreateDatabaseCommand(ExecutionEnvironment env, String databaseName) {
		this.env = env;
		this.databaseName = databaseName;
	}

	@Override
	public DatabaseCommandResult execute() throws DatabaseException {
		env.addDatabase(null);

		return DatabaseCommandResult.success("Database created");
	}
}
