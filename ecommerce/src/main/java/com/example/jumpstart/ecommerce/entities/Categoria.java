package com.example.jumpstart.ecommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Categoria extends Base{
}
