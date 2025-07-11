package com.project.auth.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeycloakJwtAuthenticationConverter.class);

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        List<String> roles = jwt.getClaimAsStringList("roles");
        LOGGER.info("JWT roles: " + roles);
        if (roles == null) {
            return Collections.emptyList();
        }
        roles.stream()
                .map(SimpleGrantedAuthority::new)
                .forEach(authority -> LOGGER.info("GrantedAuthority: {}", authority));

        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
