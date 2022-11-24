package kr.kko.kakaoassignapi.api.department.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Accessors(chain = true)
@Setter
@Getter
@ToString
public class DepartmentQuery {

    private Long corporationId;
    @Past
    private LocalDate searchDate;
    private String searchEmployeeName;
    private boolean isHistory;

    public boolean existSearchEmployeeName() {
        return StringUtils.hasText(this.searchEmployeeName);
    }
}