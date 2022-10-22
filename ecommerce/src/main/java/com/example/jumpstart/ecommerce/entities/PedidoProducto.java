package com.example.jumpstart.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name="pedidoproducto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class PedidoProducto extends Base{
    @Column(name="cant_producto")
    private int cant_producto;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name= "fk_producto")
    private Producto producto;
}
