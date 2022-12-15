package kr.company.api.api.department.domain.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PositionCode {

    LEADER("팀장"),
    MEMBER("팀원");

    private final String name;
}