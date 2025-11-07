package com.unai.Usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unai.Usuarios.models.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
