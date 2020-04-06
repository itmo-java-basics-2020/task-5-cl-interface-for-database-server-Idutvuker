package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandReadKey implements DatabaseCommand {
	private final String databaseName;
	private final String tableName;
	private final String key;
	private final ExecutionEnvironment environment;

	public CommandReadKey(ExecutionEnvironment environment, String databaseName, String tableName, String key) {
		this.databaseName = databaseName;
		this.tableName = tableName;
		this.key = key;
		this.environment = environment;
	}

	@Override
	public DatabaseCommandResult execute() throws DatabaseException {
		Optional<Database> databaseOptional = environment.getDatabase(databaseName);
		if (databaseOptional.isPresent()) {
			String value = databaseOptional.get().read(tableName, key);
			return DatabaseCommandResult.success(value);
		}
		else {
			return DatabaseCommandResult.error("Database not found");
		}
	}
}
