package com.example.security.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "rol")
@Getter
@Setter
public class Rol {

    @Id
    @GeneratedValue(generator = "rol_id_rol_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "rol_id_rol_seq", sequenceName = "public.rol_id_rol_seq", allocationSize = 1)
    @Column(name = "id_rol")
    private int id;

    @Column(name = "rol")
    private String rol;

}
