package mobile.exception;

public class BadReadMobileException extends Exception{
    public BadReadMobileException() {
    }

    public BadReadMobileException(String message) {
        super(message);
    }

    public BadReadMobileException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadReadMobileException(Throwable cause) {
        super(cause);
    }

    public BadReadMobileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
