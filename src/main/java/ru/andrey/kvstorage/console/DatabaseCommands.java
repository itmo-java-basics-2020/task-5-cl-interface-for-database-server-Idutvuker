package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.console.commands.*;

public enum DatabaseCommands {
	CREATE_DATABASE {
		@Override
		public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
			if (args.length != 2)
				throw new IllegalArgumentException("CREATE_DATABASE require 1 argument");
			return new CommandCreateDatabase(env, args[1]);
		}
	},

	CREATE_TABLE {
		@Override
		public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
			if (args.length != 3)
				throw new IllegalArgumentException("CREATE_TABLE require 2 arguments");
			return new CommandCreateTable(env, args[1], args[2]);
		}
	},

	UPDATE_KEY {
		@Override
		public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
			if (args.length != 5)
				throw new IllegalArgumentException("UPDATE_KEY require 4 arguments");
			return new CommandUpdateKey(env, args[1], args[2], args[3], args[4]);
		}
	},

	READ_KEY {
		@Override
		public DatabaseCommand getCommand(ExecutionEnvironment env, String... args) {
			if (args.length != 4)
				throw new IllegalArgumentException("READ_KEY require 3 argument");
			return new CommandReadKey(env, args[1], args[2], args[3]);
		}
	};

	public abstract DatabaseCommand getCommand(ExecutionEnvironment env, String... args);
}
