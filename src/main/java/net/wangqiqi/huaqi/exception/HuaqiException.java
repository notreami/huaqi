package net.wangqiqi.huaqi.exception;

/**
 * Created by notreami on 17/9/10.
 */
public class HuaqiException extends RuntimeException {
    public HuaqiException() {
        super();
    }

    public HuaqiException(String message) {
        super(message);
    }

    public HuaqiException(Throwable cause) {
        super(cause);
    }

    public HuaqiException(String message, Throwable cause) {
        super(message, cause);
    }

    protected HuaqiException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
