package org.sid.ada_backendv.repositories;

import org.sid.ada_backendv.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("select c from Patient c where c.username like :kw")
    List<Patient> searchPatient(@Param("kw") String keyword);
}
