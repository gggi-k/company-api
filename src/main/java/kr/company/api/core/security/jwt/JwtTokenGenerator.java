package kr.company.api.core.security.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.mint.ConfigurableJWSMinter;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import kr.company.api.core.security.dto.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class JwtTokenGenerator {

    public static final String ACCESS_TOKEN_KEY = "accessToken";
    private final ConfigurableJWSMinter<SecurityContext> jwsMinter;

    public String generate(UserPrincipal userPrincipal) throws JOSEException {

        final JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.RS256)
                .type(JOSEObjectType.JWT)
                .build();

        final JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .jwtID(UUID.randomUUID().toString())
                .subject(userPrincipal.getUsername())
                .issueTime(new Date())
                .notBeforeTime(new Date())
                .expirationTime(Date.from(ZonedDateTime.now(ZoneId.systemDefault()).plusHours(1).toInstant()))
                .build();

        return jwsMinter.mint(jwsHeader, claimsSet.toPayload(), null).serialize();
    }
}