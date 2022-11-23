package kr.kko.kakaoassignapi.api.department.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Accessors(chain = true)
@Setter
@Getter
@ToString
public class DepartmentQuery {

    private LocalDate searchDate = LocalDate.now();

    public boolean isToday() {
        return LocalDate.now().isEqual(this.searchDate);
    }

}