package kr.company.api.core.security.dto;


import com.nimbusds.jwt.JWTClaimsSet;
import kr.company.api.api.employee.domain.entity.EmployeeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;

@FieldNameConstants
@Getter
@Builder(access = AccessLevel.PRIVATE)
@ToString
public class UserPrincipal implements UserDetails, CredentialsContainer {

    private final String employeeId;
    private final Long departmentId;
    private final String name;
    private String password;

    public static UserPrincipal fromEntity(EmployeeEntity employeeEntity) {
        return UserPrincipal.builder()
                .employeeId(employeeEntity.getEmployeeId())
                .password(employeeEntity.getPassword())
                .name(employeeEntity.getName())
                .build();
    }

    public static UserPrincipal fromJwtClaimSet(JWTClaimsSet claimsSet) throws ParseException {
        return UserPrincipal.builder()
                .employeeId(claimsSet.getSubject())
                .name(claimsSet.getStringClaim(Fields.name))
                .build();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getUsername() {
        return this.employeeId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }
}