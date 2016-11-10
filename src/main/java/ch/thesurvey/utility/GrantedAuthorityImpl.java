package ch.thesurvey.utility;

import org.springframework.security.core.GrantedAuthority;

/**
 * Custom granted authority implementation
 * @author Samuel Alfano
 * @date 08.11.2016
 * @version v0.1
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    private String role;

    public GrantedAuthorityImpl(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return role;
    }
}
