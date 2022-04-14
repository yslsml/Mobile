package mobile.exception;

public class BadMobileException extends Exception{
    public BadMobileException() {
    }

    public BadMobileException(String message) {
        super(message);
    }

    public BadMobileException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadMobileException(Throwable cause) {
        super(cause);
    }

    public BadMobileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
