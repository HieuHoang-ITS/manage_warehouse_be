package com.warehouse.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.warehouse.entity.Roles;
import com.warehouse.entity.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
    public static UserDetailsImpl build(User user) {
        Set<String> roles = new HashSet<>();
        List<GrantedAuthority> authorities = new ArrayList<>();
        Roles userRoles = user.getRoles();
        if(Boolean.TRUE.equals(userRoles.getAvailibilityFlag())) {
            Boolean orderFlag = userRoles.getOrderFlag();
            Boolean approverFlag = userRoles.getApproverFlag();
            Boolean statisticianFlag = userRoles.getStatisticianFlag();
            Boolean systemFlag = userRoles.getSystemFlag();
            if(Boolean.TRUE.equals(orderFlag)) {
                roles.add(ERole.ORDERS_ADMIN.toString());
            }
            if(Boolean.TRUE.equals(approverFlag)) {
                roles.add(ERole.APPROVERS_ADMIN.toString());
            }
            if(Boolean.TRUE.equals(statisticianFlag)) {
                roles.add(ERole.STATISTICS_ADMIN.toString());
            }
            if(Boolean.TRUE.equals(systemFlag)) {
                roles.add(ERole.SYSTEM_INFO_ADMIN.toString());
            }
            if(orderFlag && approverFlag && statisticianFlag && systemFlag) {
                roles.add(ERole.SYSTEM_ADMIN.toString());
            }
            
            authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        }
        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), authorities);
    }
    
}
