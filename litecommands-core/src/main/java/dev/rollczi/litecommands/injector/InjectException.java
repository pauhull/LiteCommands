package dev.rollczi.litecommands.injector;

public class InjectException extends RuntimeException {

    public InjectException() {
    }

    public InjectException(String message) {
        super(message);
    }

    public InjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public InjectException(Throwable cause) {
        super(cause);
    }

}
