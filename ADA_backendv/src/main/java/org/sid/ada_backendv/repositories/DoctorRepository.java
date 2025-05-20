package org.sid.ada_backendv.repositories;


import org.sid.ada_backendv.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    @Query("select c from Doctor c where c.username like :kw")
    List<Doctor> searchDoctor(@Param("kw") String keyword);
}