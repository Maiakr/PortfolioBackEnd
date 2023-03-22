package com.portfolio.mk.Controller;

import com.portfolio.mk.Dto.dtoSkills;
import com.portfolio.mk.Entity.Skills;
import com.portfolio.mk.Security.Controller.Mensaje;
import com.portfolio.mk.Service.SSkills;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins ="http://localhost:4200")


public class CSkills {
    @Autowired
    SSkills sSkills;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id")int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }

        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity(new Mensaje("habilidad eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sSkills.existsByNombre(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(dtoskills.getNombre(), dtoskills.getPorcentaje()
        );
        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("habilidad agregada"), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkills dtoskills){
        //Validamos si existe el ID
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        //Compara nombre de skills
        if(sSkills.existsByNombre(dtoskills.getNombre()) && sSkills.getByNombre(dtoskills.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if(StringUtils.isBlank(dtoskills.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = sSkills.getOne(id).get();

        skills.setNombre(dtoskills.getNombre());
        skills.setPorcentaje(dtoskills.getPorcentaje());

        sSkills.save(skills);

        return new ResponseEntity(new Mensaje("habilidad actualizada"), HttpStatus.OK);
    }


}
