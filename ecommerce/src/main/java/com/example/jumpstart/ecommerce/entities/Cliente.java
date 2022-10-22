package com.example.jumpstart.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Cliente extends Base{
    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="dni")
    private int dni;

    @Column(name="telefono")
    private int telefono;

    @Column(name="cuil")
    private int cuil;

    @Column(name="mail")
    private String mail;

    @OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
    private List<Tarjeta> tarjetas= new ArrayList<Tarjeta>();

    @OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
    private List<Domicilio> domicilios= new ArrayList<Domicilio>();
}
