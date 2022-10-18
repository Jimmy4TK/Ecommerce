package com.example.jumpstart.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="domicilio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Domicilio extends Base{
    @Column(name="nombre")
    private String nombre;

    @Column(name="numero")
    private int numero;
}
