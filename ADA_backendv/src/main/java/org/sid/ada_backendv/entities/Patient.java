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
@DiscriminatorValue("PATIENT")
public class Patient extends User {
    private String email;
    private String phone;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
