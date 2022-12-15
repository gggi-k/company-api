package kr.company.api.core.error.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATE("중복되었습니다"),
    UNAUTHORIZED("인증되지 않았습니다"),
    NOT_FOUND("존재하지 않습니다");

    private final String defaultMessage;
}