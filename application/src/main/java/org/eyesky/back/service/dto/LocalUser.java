//package org.eyesky.back.service.dto;
//
//import org.eyesky.back.repository.entity.JpaUser;
//import org.eyesky.back.service.utils.GeneralUtils;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.oauth2.core.oidc.OidcIdToken;
//import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//
//import java.util.Collection;
//import java.util.Map;
//
//public class LocalUser extends JpaUser implements OAuth2User, OidcUser, UserDetails {
//    /**
//     *
//     */
//    private static final long serialVersionUID = -2845160792248762779L;
//    private final OidcIdToken idToken;
//    private final OidcUserInfo userInfo;
//    private Map<String, Object> attributes;
//    private JpaUser user;
//
//    public LocalUser(final String userID, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired,
//                     final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities, final JpaUser user) {
//        this(userID, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, user, null, null);
//    }
//
//    public LocalUser(final String userID, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired,
//                     final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities, final JpaUser user, OidcIdToken idToken,
//                     OidcUserInfo userInfo) {
//        super(userID, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//        this.user = user;
//        this.idToken = idToken;
//        this.userInfo = userInfo;
//    }
//
//    public static LocalUser create(JpaUser user, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo) {
//        LocalUser localUser = new LocalUser(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, GeneralUtils.buildSimpleGrantedAuthorities(user.getRoles()),
//                user, idToken, userInfo);
//        localUser.setAttributes(attributes);
//        return localUser;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() { return null; }
//
//    @Override
//    public boolean isAccountNonExpired() { return false; }
//
//    @Override
//    public boolean isAccountNonLocked() { return false; }
//
//    @Override
//    public boolean isCredentialsNonExpired() { return false; }
//
//    @Override
//    public Map<String, Object> getAttributes() {
//        return this.attributes;
//    }
//
//    public void setAttributes(Map<String, Object> attributes) {
//        this.attributes = attributes;
//    }
//
//    @Override
//    public Map<String, Object> getClaims() {
//        return this.attributes;
//    }
//
//    @Override
//    public OidcUserInfo getUserInfo() { return this.userInfo; }
//
//    @Override
//    public OidcIdToken getIdToken() {
//        return this.idToken;
//    }
//
//    public JpaUser getUser() {
//        return user;
//    }
//
//    @Override
//    public String getUsername() { return null; }
//
//    @Override
//    public String getName() { return this.user.getDisplayName(); }
//
//
//}
