package org.sid.ada_backendv.repositories;

import org.sid.ada_backendv.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Query("select c from Admin c where c.username like :kw")
    List<Admin> searchAdmin(@Param("kw") String keyword);
}
