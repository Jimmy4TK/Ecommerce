package com.example.jumpstart.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="factura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Factura extends Base{
    @Column(name="total")
    private float total;

    @Column(name="fecha")
    private Date fecha;

    @Column(name="tipo")
    private char tipo;
}
