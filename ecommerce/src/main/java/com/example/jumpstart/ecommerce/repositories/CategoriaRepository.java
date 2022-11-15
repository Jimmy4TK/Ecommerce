package com.example.jumpstart.ecommerce.repositories;


import com.example.jumpstart.ecommerce.entities.Categoria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long>{
}
