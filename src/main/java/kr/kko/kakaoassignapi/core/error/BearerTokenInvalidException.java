package kr.kko.kakaoassignapi.core.error;

import kr.kko.kakaoassignapi.core.error.base.BaseException;
import kr.kko.kakaoassignapi.core.error.code.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class BearerTokenInvalidException extends BaseException {
    public BearerTokenInvalidException() {
    }

    public BearerTokenInvalidException(String message) {
        super(message);
    }

    public BearerTokenInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public BearerTokenInvalidException(Throwable cause) {
        super(cause);
    }

    public BearerTokenInvalidException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.DUPLICATE;
    }
}