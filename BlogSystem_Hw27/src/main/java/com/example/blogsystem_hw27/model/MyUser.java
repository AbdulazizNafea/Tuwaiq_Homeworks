package com.example.blogsystem_hw27.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MyUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(50)", unique = true, nullable = false)
    private String username;


    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(50)",nullable = false)
    @Size(min= 3)
    private String password;

    @NotEmpty(message = "should be not null")
    @Column(columnDefinition = "varchar(10)",nullable = false)
    @Size(min= 3)
    private String role;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "myUser")
  private List<Blog> blog;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
}
