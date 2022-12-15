package kr.company.api.core.error.base;


import kr.company.api.core.error.code.ErrorCode;
import org.springframework.util.StringUtils;

public abstract class BaseException extends RuntimeException {
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public abstract ErrorCode getErrorCode();

    @Override
    public String getMessage() {
        return StringUtils.hasText(super.getMessage()) ? super.getMessage() : getErrorCode().getDefaultMessage();
    }
}