package kg.alatoo.springwebapp.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements GrantedAuthority {
    @Id
    private String name = "ROLE_ADMIN";

    @Override
    public String getAuthority() {
        return name;
    }
}
