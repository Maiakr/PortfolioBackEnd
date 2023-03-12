package com.portfolio.mk.Repository;

import com.portfolio.mk.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer> {
    public Optional<Educacion>findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
