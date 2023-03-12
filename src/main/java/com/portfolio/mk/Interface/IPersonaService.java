package com.portfolio.mk.Interface;
import com.portfolio.mk.Entity.Persona;

import java.util.List;

public interface IPersonaService {
    //Traer una lista de personas
  List<Persona> getPersona();

    //Guardar un objeto de tipo Persona
    void savePersona(Persona persona);

    //Eliminar un objeto, pero lo buscamos por ID
  void deletePersona(Long id);

    //Buscar una persona por ID
    Persona findPersona(Long id);

}
