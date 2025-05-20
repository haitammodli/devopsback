package org.sid.ada_backendv.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("DOCTOR")
public class Doctor extends User {
    private String specialty;
    private String licenseNumber;
    private String email;
    private String phone;

}
