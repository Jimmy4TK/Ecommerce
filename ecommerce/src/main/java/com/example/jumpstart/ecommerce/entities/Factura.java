package com.example.jumpstart.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="factura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Factura extends Base {
    @Column(name = "total")
    private float total;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "tipo")
    private char tipo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_tarjeta")
    private Tarjeta tarjeta;
}
