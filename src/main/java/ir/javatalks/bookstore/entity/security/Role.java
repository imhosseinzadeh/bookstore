package ir.javatalks.bookstore.entity.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Collections.emptySet()),
    CUSTOMER(Set.of(Permission.BOOK_READ)),
    ADMIN(Set.of(Permission.BOOK_READ, Permission.BOOK_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return authorities;
    }
}
