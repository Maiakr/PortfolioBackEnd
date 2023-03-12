package com.portfolio.mk.Security.Service;

import com.portfolio.mk.Security.Entity.Rol;
import com.portfolio.mk.Security.Enums.RolNombre;
import com.portfolio.mk.Security.Repository.iRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional //si algo falla sigue igual como antes y no impacta en el servidor
public class RolService {
    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
