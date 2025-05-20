package org.sid.ada_backendv.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DoctorDTO extends UserDTO {
    private String specialty;
    private String licenseNumber;
    private String email;
    private String phone;
}