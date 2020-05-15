package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String result) {
        return new DatabaseCommandResultImpl(DatabaseCommandStatus.SUCCESS, result);
    }

    static DatabaseCommandResult error(String message) {
        return new DatabaseCommandResultImpl(DatabaseCommandStatus.FAILED, message);
    }

    class DatabaseCommandResultImpl implements DatabaseCommandResult {
        private final DatabaseCommandStatus status;
        private final String resultMessage;
        private final String errorMessage;

        private DatabaseCommandResultImpl(DatabaseCommandStatus status, String message) {
            this.status = status;

            if (isSuccess()) {
                this.resultMessage = message;
                this.errorMessage = null;
            }
            else {
                this.resultMessage = null;
                this.errorMessage = message;
            }
        }

        @Override
        public Optional<String> getResult() {
            return Optional.of(resultMessage);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return status;
        }

        @Override
        public boolean isSuccess() {
            return status == DatabaseCommandStatus.SUCCESS;
        }

        @Override
        public String getErrorMessage() {
            return errorMessage;
        }
    }
}