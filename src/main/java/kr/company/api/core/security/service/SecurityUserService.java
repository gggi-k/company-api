package kr.company.api.core.security.service;


import kr.company.api.api.employee.repository.EmployeeRepository;
import kr.company.api.core.security.dto.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SecurityUserService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserPrincipal.fromEntity(employeeRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 사용자가 존재하지 않습니다")));
    }
}