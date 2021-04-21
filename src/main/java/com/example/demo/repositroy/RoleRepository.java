package com.example.demo.repositroy;

import com.example.demo.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
    @Query(value = "select * from Roles where Role = ?",nativeQuery = true)
     Roles findByRole(@Param("Role") String role);
}
