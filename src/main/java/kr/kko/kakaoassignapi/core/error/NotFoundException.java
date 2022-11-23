package kr.kko.kakaoassignapi.core.error;

import kr.kko.kakaoassignapi.core.error.base.BaseException;
import kr.kko.kakaoassignapi.core.error.code.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BaseException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public ErrorCode getErrorCode() {
        return ErrorCode.NOT_FOUND;
    }
}