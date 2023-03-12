package com.portfolio.mk.Service;

import com.portfolio.mk.Entity.Skills;
import com.portfolio.mk.Repository.RSkills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class SSkills {
    @Autowired
    RSkills rSkills;

    public List<Skills> list(){
        return rSkills.findAll();
    }
    public Optional<Skills>getOne (int id){
        return rSkills.findById(id);
    }
    public Optional<Skills> getByNombre (String nombre) {
        return rSkills.findByNombre(nombre);
    }
    public void save (Skills skill) {
        rSkills.save(skill);
    }
    public void delete (int id) {
        rSkills.deleteById(id);
    }
    public boolean existsById(int id) {
        return rSkills.existsById(id);
    }
    public boolean existsByNombre(String nombre){
        return rSkills.existsByNombre(nombre);
    }
}
