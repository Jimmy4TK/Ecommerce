package com.example.jumpstart.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name="producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Producto extends Base{
    @Column(name="codProducto")
    private String codProducto;

    @Column(name="nombreProducto")
    private String nombreProducto;

    @Column(name="descuento")
    private int descuento;

    @Column(name="stock")
    private int stock;

    @Column(name="precio")
    private int precio;

    @Column(name="Litro")
    private int litro;

    @Column(name="masVendido")
    private Boolean masVendido;

    @Column(name="Recomendado")
    private Boolean recomendado;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;
}
