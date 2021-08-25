package com.huixiong.domain.dto;

import com.huixiong.domain.model.Admin;
import com.huixiong.domain.model.Permission;
import com.huixiong.enums.AdminStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author timothy.yang cloudwise
 * @since 2021-08-24 17:14
 */
public class AdminUserDetailsDto implements UserDetails {

    private Admin admin;
    private List<Permission> permissions;

    public AdminUserDetailsDto(Admin admin, List<Permission> permissions) {
        this.admin = admin;
        this.permissions = permissions;
    }

    /**
     * 获取当前用户的权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissions.stream()
                .filter(permission -> permission.getValue() != null)
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    /**
     * 账户是否 没有失效
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 证书是否 没有过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return AdminStatus.Active == admin.getStatus();
    }
}
