package kr.kko.kakaoassignapi.core.error;

import kr.kko.kakaoassignapi.core.error.base.BaseException;
import kr.kko.kakaoassignapi.core.error.code.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateException extends BaseException {

    public DuplicateException() {
    }

    public DuplicateException(String message) {
        super(message);
    }

    public DuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateException(Throwable cause) {
        super(cause);
    }

    public DuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.DUPLICATE;
    }
}