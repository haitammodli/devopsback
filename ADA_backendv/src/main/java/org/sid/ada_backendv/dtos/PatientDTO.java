package org.sid.ada_backendv.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PatientDTO extends UserDTO {
    private String cin;
    private String email;
    private String phone;
}