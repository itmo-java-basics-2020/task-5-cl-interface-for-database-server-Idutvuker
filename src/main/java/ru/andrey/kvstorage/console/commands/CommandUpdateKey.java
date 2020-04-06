package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandUpdateKey implements DatabaseCommand {
	private final String databaseName;
	private final String tableName;
	private final String key;
	private final String value;
	private final ExecutionEnvironment environment;

	public CommandUpdateKey(ExecutionEnvironment environment, String databaseName,
							String tableName, String key, String value) {
		this.databaseName = databaseName;
		this.tableName = tableName;
		this.key = key;
		this.value = value;
		this.environment = environment;
	}

	@Override
	public DatabaseCommandResult execute() throws DatabaseException {
		Optional<Database> databaseOptional = environment.getDatabase(databaseName);

		if (databaseOptional.isPresent()) {
			databaseOptional.get().write(tableName, key, value);
			return DatabaseCommandResult.success("Key updated");
		}
		else {
			return DatabaseCommandResult.error("Database not found");
		}
	}
}
