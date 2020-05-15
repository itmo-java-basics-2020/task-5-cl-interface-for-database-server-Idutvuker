package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreateTableCommand implements DatabaseCommand {
	private ExecutionEnvironment env;
	private String databaseName;
	private String tableName;

	public CreateTableCommand(ExecutionEnvironment env, String databaseName, String tableName) {
		this.env = env;
		this.databaseName = databaseName;
		this.tableName = tableName;
	}

	public DatabaseCommandResult execute() throws DatabaseException {
		Optional<Database> databaseOptional = env.getDatabase(databaseName);
		if (databaseOptional.isPresent()) {
			databaseOptional.get().createTableIfNotExists(tableName);
			return DatabaseCommandResult.success("Table created");
		}
		else {
			return DatabaseCommandResult.error("Database not found");
		}
	}
}
