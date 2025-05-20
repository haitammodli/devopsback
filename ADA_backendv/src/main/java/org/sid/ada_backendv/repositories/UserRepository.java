package org.sid.ada_backendv.repositories;

import org.sid.ada_backendv.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select c from User c where c.username like :kw")
    List<User> searchUser(@Param("kw") String keyword);
}
