package com.portfolio.mk.Security.Entity;

import com.portfolio.mk.Security.Enums.RolNombre;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    //Constructor
public Rol(){

}
    public Rol(RolNombre rolNombre) {this.rolNombre = rolNombre;
    }

    //Getter y Setter
    public int getId() {return id;
    }

    public void setId(int id) {this.id = id;
    }

    public RolNombre getRolNombre() {return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
