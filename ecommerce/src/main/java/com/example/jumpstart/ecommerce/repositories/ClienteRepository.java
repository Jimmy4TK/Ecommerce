package com.example.jumpstart.ecommerce.repositories;

import com.example.jumpstart.ecommerce.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long>{
    @Query(value="SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido Like %:filtro%",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true)

    Page<Cliente> search(@Param("filtro") String filtro, Pageable pageable);
}
