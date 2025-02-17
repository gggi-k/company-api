package kr.company.api.core.security.filter;


import kr.company.api.core.error.BearerTokenInvalidException;
import kr.company.api.core.security.jwt.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class BearerJwtTokenAuthenticationFilter extends OncePerRequestFilter {

    private static final Pattern authorizationPattern = Pattern.compile("^Bearer (?<token>[a-zA-Z0-9-._~+/]+=*)$", Pattern.CASE_INSENSITIVE);

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String token = resolve(request);
        if(token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(jwtAuthenticationProvider.authenticate(token));
        SecurityContextHolder.setContext(context);

        filterChain.doFilter(request, response);
    }

    private String resolve(HttpServletRequest request) {
        final String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.startsWithIgnoreCase(token, "bearer")) {
            return null;
        }
        Matcher matcher = authorizationPattern.matcher(token);
        if(!matcher.matches()) {
            throw new BearerTokenInvalidException("잘못된 토큰입니다");
        }

        return matcher.group("token");
    }
}