package com.portfolio.mk.Repository;

import com.portfolio.mk.Entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RSkills extends JpaRepository<Skills, Integer> {
    Optional<Skills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);

}
