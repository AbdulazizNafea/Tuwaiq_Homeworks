package com.example.hw28_relationsecurity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "username should be not empty")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "password should be not empty")
    @Column(nullable = false, columnDefinition = "varchar(250) not null")
    @Size(min = 3, message = "should be more 3 ")
    private String password;

    //@NotEmpty(message = "role Cannot be null")
    @Pattern(regexp = "(ADMIN|USER)",message = "Role must be in admin or user only")
    @Column(columnDefinition = "varchar(10) not null check (role='ADMIN' or role='USER')")
    private String role;

    private boolean isAccountNonLocked;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Order> order;
    //private boolean isLocked=true;


    @Override

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override    @JsonIgnore

    public boolean isAccountNonExpired() {
        return true;
    }
    @Override    @JsonIgnore

    public boolean isAccountNonLocked() {
        return true;
    }

    @Override    @JsonIgnore

    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override    @JsonIgnore

    public boolean isEnabled() {
        return true;
    }
}
