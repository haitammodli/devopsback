package org.sid.ada_backendv.dtos;

import lombok.Data;
import org.sid.ada_backendv.enums.Role;

@Data
public abstract class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
}
