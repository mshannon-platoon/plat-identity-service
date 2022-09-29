package ie.plat.identity.domain.factory;

import ie.plat.identity.domain.model.User;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@UtilityClass
public class UserDetailsFactory {

  boolean enabled = true;

  boolean accountNonExpired = true;

  boolean credentialsNonExpired = true;

  boolean accountNonLocked = true;

  public UserDetails from(User user) {
    return new org.springframework.security.core.userdetails.User(
        user.getEmail(),
        user.getPassword().toLowerCase(),
        enabled,
        accountNonExpired,
        credentialsNonExpired,
        accountNonLocked,
        getAuthorities(user.getRoles()));
  }

  private static List<GrantedAuthority> getAuthorities(List<String> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }
    return authorities;
  }
}
