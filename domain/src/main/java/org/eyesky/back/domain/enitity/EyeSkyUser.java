package org.eyesky.back.domain.enitity;

import lombok.Data;

@Data
public class EyeSkyUser {
    private Long id;
    private String firstName;
    private String LastName;

    public EyeSkyUser(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
    }
}
