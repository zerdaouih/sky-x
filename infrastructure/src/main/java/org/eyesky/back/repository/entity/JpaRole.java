package org.eyesky.back.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the role database table.
 */
@Entity(name = "Roles")
@Getter
@Setter
@NoArgsConstructor
public class JpaRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum name;

//    @ManyToMany(mappedBy = "roles")
//    private Set<JpaUser> users;

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((name == null) ? 0 : name.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(final Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final JpaRole role = (JpaRole) obj;
//        if (!role.equals(role.name)) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        final StringBuilder builder = new StringBuilder();
//        builder.append("Role [name=").append(name).append("]").append("[id=").append(id).append("]");
//        return builder.toString();
//    }
}
