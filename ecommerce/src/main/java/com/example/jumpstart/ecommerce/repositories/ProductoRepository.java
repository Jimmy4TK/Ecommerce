package com.example.jumpstart.ecommerce.repositories;

import com.example.jumpstart.ecommerce.entities.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends BaseRepository<Producto, Long>{
    @Query(value="SELECT * FROM producto WHERE producto.nombre LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM producto",
            nativeQuery = true)
    Page<Producto> search(@Param("filtro") String filtro, Pageable pageable);
}
