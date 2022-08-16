package org.eyesky.back.repository.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "users")
@NoArgsConstructor
@Getter
@Setter
@Data
//public class JpaUser extends BaseEntity implements Serializable {
public class JpaUser implements Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 120)
    private String password;

    //    @Column(name = "PROVIDER_USER_ID")
//    private String providerUserId;


//    @Column(name = "enabled", columnDefinition = "BIT", length = 1)
//    private boolean enabled;

//    @Column(name = "DISPLAY_NAME")
//    private String displayName;


//    @Column(name = "created_date", nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    protected Date createdDate;

//    @Temporal(TemporalType.TIMESTAMP)
//    protected Date modifiedDate;

//    private String provider;

    //     bi-directional many-to-many association to Role
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<JpaRole> roles;

//    public JpaUser(String userID, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//    }

//    public User toUser() {
//        //TODO a finir
//        return new User();
//    }
}
